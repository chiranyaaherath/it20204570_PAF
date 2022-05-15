<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Grid</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">
 
 	<h1>Notice Management</h1>
 	
	<form id="formNotice" name="formNotice" method="post" action="notice.jsp">
	 Notice Title:
		<input id="Notice_Title" name="Notice_Title" type="text"
		 	class="form-control form-control-sm">
		<br> Notice Time:
		<input id="Notice_Time" name="Notice_Time" type="text"
		 	class="form-control form-control-sm">
		<br> Notice Date:
		<input id="Notice_Date" name="Notice_Date" type="text"
		 	class="form-control form-control-sm">
		<br> Area:
		<input id="Area" name="Area" type="text"
		 	class="form-control form-control-sm">
		<br> Description:
		<input id="Description" name="Description" type="text"
		 	class="form-control form-control-sm">
		<br>
		<input id="btnSave" name="btnSave" type="button" value="Save"
		 	class="btn btn-primary">
		<input type="hidden" id="hidNoticeSave" name="hidNoticeSave" value="">
		<br><br>
	</form>
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divNoticesGrid">
		 <%
			 Notice noticeObj = new Notice();
			 out.print(noticeObj.readNotice());
		 %>
	</div>
</div> </div> </div> 
</body>
</html>