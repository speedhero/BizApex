<%@ page import="com.apex.form.User" %>
<%@ page import="com.apex.form.UserContext" %>
<%@ page import="com.apex.form.context.PageModeContext" %>
<%@ page import="com.apex.form.context.PageModeManager" %>
<%@ page import="com.apex.livebos.workflow.TaskInitiateFilterCondition" %>
<%@ page import="com.apex.livebos.workflow.TaskParticipateFiltertCondition" %>
<%@ page import="com.apex.livebos.workflow.TodoTasksContext" %>
<%@ page import="com.apex.util.ApexRowSet" %>
<%@ page import="com.apex.workflow.WorkTask" %>
<%@ page import="com.apex.workflow.WorkflowProfile" %>
<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="org.dom4j.io.HTMLWriter" %>
<%@ page import="org.dom4j.io.OutputFormat" %>
<%@ page import="org.dom4j.tree.BaseElement" %>
<%@ page import="org.dom4j.tree.DefaultDocument" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.apex.form.context.PageContextException" %>
<%@ page language="java" isErrorPage="false" pageEncoding="GBK" %>
<%
	 

	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT"); 
	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); 
	response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
	response.setHeader("Pragma", "no-cache");
 
    String modStr = request.getParameter("MOD");
    if (modStr == null) {
         return;
    }
    if (modStr.equals("WFNAME")){
		 User user = UserContext.getContext().getUser(); 
        out.clear();
        response.reset();
        response.setContentType("text/xml;charset=GBK");
        response.setCharacterEncoding("GBK");
        out.println("<?xml version=\"1.0\" encoding=\"GBK\" ?>"); 
        Document doc = getWFNameDocument(user);  
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("GBK");
        org.dom4j.io.XMLWriter xmlWriter = new HTMLWriter(out, of);
        xmlWriter.write(doc);
	}
    else if (modStr.equals("MYTASKS")) { //我的任务
		String type = request.getParameter("taskType"); 
	 
		User user = UserContext.getContext().getUser();
        
        out.clear();
        response.reset();
        response.setContentType("text/xml;charset=GBK");
        response.setCharacterEncoding("GBK");
        out.println("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        int pageNo = 1;
        int pageSize = 10;
        if (request.getParameter("pageNo") != null) {
            try {
                pageNo = Integer.parseInt(request.getParameter("pageNo"));
            } catch (Exception e) {
            }
        }
        if (request.getParameter("pageSize") != null) {
            try {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            } catch (Exception e) {
            }
        }
        Document doc = getMyTasksDocument(user, pageSize, pageNo,request,type);
	 
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("GBK");
        org.dom4j.io.XMLWriter xmlWriter = new HTMLWriter(out, of);
 
        xmlWriter.write(doc);
        
//        out.print(doc.asXML());
        if (true) return;
    }
	
%><%!
    private static final int FLAG_NOT_FRAME = 2;//不包含iframe1

    private Document getMyTasksDocument(User user, int pageSize, int pageNo,HttpServletRequest req,String type) throws Exception {

        Element rootEl = new BaseElement("tasks");
		 


		TodoTasksContext context = (TodoTasksContext)getContext(req) ;
		context.setCurrentPage(pageNo);
		context.setPageRows(pageSize);
		if("participate".equals(type))
		{	 
			context.setTaskType(context.TASK_TYPE_PARTICIPATE);
			context.putCondition(new TaskParticipateFiltertCondition(user,false));
		}
		else if("initiated".equals(type))
		{ 
			context.setTaskType(context.TASK_TYPE_INITIATED);
			context.putCondition(new TaskInitiateFilterCondition(user));
		}
		else
		{
		    context.setTaskType(context.TASK_TYPE_TODO);
			context.putCondition(new TaskInitiateFilterCondition(user));
		}  
        ApexRowSet rs = context.getRsRecord();
	 
		
        ResultSetMetaData md = rs.getMetaData();
        rootEl.addAttribute("count", String.valueOf(rs.getCount()));
        rootEl.addAttribute("size", String.valueOf(rs.size()));
        rs.beforeFirst();
        while (rs.next()) {
			
            Element taskEl = new BaseElement("task"); 
            rootEl.add(taskEl);
            for (int c_i = 0; c_i < md.getColumnCount(); c_i++) {
                String key = md.getColumnName(c_i + 1);
                String val = rs.getString(key);
				
                Element colEl = new BaseElement("property");
				
				colEl.addAttribute("id", c_i+"");
                colEl.addAttribute("name", key);
                colEl.addAttribute("value", val == null ? "null" : val);
	 
                taskEl.add(colEl);
				
            }
        }
        return new DefaultDocument(rootEl);  
    }
	 private Document getWFNameDocument(User user) throws Exception {
			 Element rootEl = new BaseElement("wfNames");
			List<WorkflowProfile> list = WorkTask.getMyWorkflowDescribes(user);
	 
			for(WorkflowProfile wf : list )
		    {
				Element taskEl = new BaseElement("wfName");
				rootEl.add(taskEl);
				Element colEl = new BaseElement("property");
				colEl.addAttribute("name", wf.getName());
				colEl.addAttribute("describe", wf.getDescribe());
				colEl.addAttribute("category", wf.getCategory()); 
				taskEl.add(colEl);
			}
		  return new DefaultDocument(rootEl);

    }
	private PageModeContext getContext(HttpServletRequest req){
		String objName = getObjName();

		PageModeManager manager = PageModeManager.getPageManager(req);
		 
		PageModeContext context =null;
		try {
			String alias = objName + ".cowork";
			context = manager.getContext(alias);
			if (context == null) {
				context = manager.createContext(req, objName, alias);
				manager.putContext(context);
			}

		} catch (SQLException e) {
            e.printStackTrace();
        } catch (PageContextException e) {
            e.printStackTrace();
        }

        return context;
	} 
	private String getObjName() {
		return "WORKFLOW_TOTASKS";
	}
%>