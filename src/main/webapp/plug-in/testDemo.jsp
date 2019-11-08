<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2019/11/5
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="bean" uri= "http://struts.apache.org/tags-bean" %>
<%@ taglib prefix ="logic" uri= "http://struts.apache.org/tags-logic" %>
<%@ taglib prefix ="html" uri= "http://struts.apache.org/tags-html" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.apex.form.User" %>
<%@ page import="com.apex.form.UserContext" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- -- /obejctUrl.mvc--%>
<h4>Welcome to the Maven 2 World!</h4>
<%
    String urlSu= com.apex.util.JsUtil.getInstance().generateObjectURI( "WO_CPSQDJD",null,-1,null,null);
    String url=basePath+urlSu;
    String url2=basePath+"obejctUrl.mvc";
    ServletContext context= this.getServletConfig().getServletContext();
    context.setAttribute("userContext",UserContext.getContext());
    out.println(url);
%>
<a href="<%out.println(url);%>">open</a>
<a href="<%out.println(url2);%>">open2</a>
<h3><%out.println(UserContext.getContext().toString());%></h3>
</body>
</html>
