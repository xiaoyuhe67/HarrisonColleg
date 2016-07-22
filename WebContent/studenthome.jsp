<%@page import="DBUtil.Dataget"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	
%> 
<fmt:setLocale value="en_US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="css/mycss.css" />
</head>
<body >

<script language="javascript" type="text/javascript">
function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}


</script>

<jsp:include page="navbar.jsp" />


<form action="StudentHomeServlet"   id="myform" name="myform" >
<div class="container">
<table align="center" border="0" class="table">
<thead>
<tr ><th>Search course</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#4db6ac ">

<td >Please enter course name:</td></tr>
<tr align="center"><td><input type="text" name="searchcoursename" value=""/></td></tr>

<tr align="center"><td>
<input type="submit" name="method" value="Search" class="button"/>
</td>
</tr>

</tbody>
</table>
</div>



<div class="container">


<br /><br />

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">All Courses</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Course Name</div></th>
<th align="center"><div align="center">Subject Code</div></th>
<th align="center"><div align="center">Description</div></th>
<th align="center"><div align="center">Department</div></th>
<th align="center"><div align="center">Credits</div></th>
</tr>
</thead>
 <tbody>
 <c:forEach var="course" items="${Allcourses}">
<tr>   
    <td align="center">   
        <c:set var="myid" value="${course.courseid}"/>
        <a href="StudentHomeServlet?courseid=<c:out value="${myid}"/>" >${course.coursename}</a>
    <td align="center"> 
	
        <c:out value="${course.subjectcode}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${course.coursedes}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${course.hdepartment.departmentname}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${course.credits}"/>  
    
   </td> 
   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 

 </div> 
 
</form>

</body>
</html>


