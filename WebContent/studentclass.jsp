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
<title>My Classes</title>
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


<form action="StudentClassServlet"   id="myform" name="myform" >
<div class="container">
<table align="center" border="0" class="table">
<thead>
<tr ><th>Search class</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#4db6ac ">

<td >Please enter CRN number:</td></tr>
<tr align="center"><td><input type="text" name="searchcrnnumber" value=""/></td></tr>

<tr align="center"><td>
<input type="submit" name="method" value="Search" class="button"/>
</td>
</tr>

</tbody>
</table>
</div>



<div class="container">


<br /><br />

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">All Classes</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">CRN Number</div></th>
<th align="center"><div align="center">Course</div></th>
<th align="center"><div align="center">Instructor</div></th>
<th align="center"><div align="center">Building Name</div></th>
<th align="center"><div align="center">Room Number</div></th>
<th align="center"><div align="center">Week Day</div></th>
<th align="center"><div align="center">Time</div></th>
<th align="center"><div align="center">Number of Students</div></th>
<th align="center"><div align="center">Operations</div></th>
</tr>
</thead>
 <tbody>
 <c:forEach var="cs" items="${Allstudentclass}">
<tr>   
    <td align="center">   
        <c:out value="${cs.crnnumber}"/>
    <td align="center"> 
	
        <c:out value="${cs.hcourse.coursename}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${cs.hinstructor.instructorname}"/>
        <input type="button" class="Sendemail" name="Sendemail${cs.hinstructor.huser.useremail}" id="Sendemail${cs.hinstructor.huser.useremail}" value="Sendemail"/> 
    
 	</td> 
	<td align="center">
    <c:out value="${cs.hclassroom.buildingname}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${cs.hclassroom.roomnumber}"/>  
    
   </td>
   <td align="center">
   <c:set var="week" value="${cs.weekday}"/>
    <c:out value="${Weekday[week]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${cs.classtime}"/>  
    
   </td>
    <td align="center">
    <c:out value="${cs.studentcount}"/>  
    
   </td>
   
    <td align="center">
    
    <c:set var="classid" value="${cs.classid}"/>
     
    <input type="button" class="Dropclass" name="Dropclass${classid}" id="Dropclass${classid}" value="Drop Class"/> 
       
   </td>
   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 

 </div> 
 <script  src="js/studentclass.js"></script>
</form>

</body>
</html>


