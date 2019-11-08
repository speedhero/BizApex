<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<body> 
	 	<form action="<portlet:actionURL/>" method="post">
	 	<input type="hidden" name="action" value="create"/>
	 	<table>
	 		<tr>
	 			<th>ID</th>
	 			<td><input type="text" name="id" value="${account.id }" /></td>
	 		</tr>
	 		<tr>
	 			<th>Name</th>
	 			<th><input type="text" name="username"/></th>
	 		</tr>
	 		<tr>
	 			<td colspan="2">
	 				<input type="submit" value="submit"/>
	 				<input type="reset" value="reset"/>
	 			</td>
	 		</tr>
	 	</table>
	 	</form>
	</body> 
	 
		 
</html>



