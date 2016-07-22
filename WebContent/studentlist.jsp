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


<form action="StudentListServlet"   id="myform" name="myform" >
<div class="container">
<table align="center" border="0" class="table">
<thead>
<tr ><th>Search student</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#4db6ac ">

<td >Please enter student name:</td></tr>
<tr align="center"><td><input type="text" name="searchstudentname" value=""/></td></tr>

<tr align="center"><td>
<input type="submit" name="method" value="Search" class="button"/>
</td>
</tr>

</tbody>
</table>
</div>



<div class="container">


<br /><br />

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Student List in Class ${myclass.crnnumber}</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Student Name</div></th>
<th align="center"><div align="center">Major</div></th>
<th align="center"><div align="center">Entry Year</div></th>
<th align="center"><div align="center">Grade</div></th>

</tr>
</thead>
 <tbody>
 <c:forEach var="stu" items="${studentlist}">
<tr>   
    <td align="center">   
        <c:out value="${stu.hstudent.studentname}"/>
    <td align="center"> 
	
        <c:out value="${stu.hstudent.hmajor.majorname}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${stu.hstudent.entryyear}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${stu.grade}"/>  
    
   </td> 

   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 

 </div> 
</form>

</body>
</html>


