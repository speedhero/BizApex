<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<body> 
	 	<%=request.getCharacterEncoding() %>--<br/>
	 	<%=response.getCharacterEncoding() %>---<br/>
	 	<table>
	 		<tr>
	 			<th>ID</th>
	 			<th>Name</th>
	 			<th colspan="2">Actions</th>
	 		</tr>
	 		<c:forEach var="account" items="${accounts }">
	 		<tr>
	 			<td>${account.id }</td>
	 			<td>${account.username }</td>
	 			<td><a href="<portlet:renderURL>
	 							<portlet:param name="action" value="edit"/>
	 							<portlet:param name="id" value="${account.id }"/>
	 						</portlet:renderURL>">Edit</a>
	 			</td>
	 			<td><a href="<portlet:renderURL>
	 							<portlet:param name="action" value="delete"/>
	 							<portlet:param name="id" value="${account.id }"/>
	 						</portlet:renderURL>">Delete</a>
	 			</td>
	 		</tr>
	 		</c:forEach>
	 		<tr>
	 			<td colspan="4">
	 				<a href="<portlet:renderURL>
	 							<portlet:param name="action" value="add"/>
	 							<portlet:param name="id" value="${account.id }"/>
	 						</portlet:renderURL>">Add</a>
	 			</td>
	 		</tr>
	 	</table>
	 	
	</body> 
	 
		 
</html>



