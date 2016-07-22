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
<title>My Schedule</title>
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


<form action="StudentScheduleServlet"   id="myform" name="myform" >


<div class="container">


<br /><br />

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">My Schedule</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center"></div></th>
<th align="center"><div align="center">Monday</div></th>
<th align="center"><div align="center">Tuesday</div></th>
<th align="center"><div align="center">Wednesday</div></th>
<th align="center"><div align="center">Thursday</div></th>
<th align="center"><div align="center">Friday</div></th>
<th align="center"><div align="center">Saturday</div></th>
<th align="center"><div align="center">Sunday</div></th>
</tr>
</thead>
 <tbody>
 <c:set var="Section1Monday" value="11"/>
 <c:set var="Section1Tuesday" value="12"/>
  <c:set var="Section1Wednesday" value="13"/>
  <c:set var="Section1Thursday" value="14"/>
   <c:set var="Section1Friday" value="15"/>
    <c:set var="Section1Saturday" value="16"/>
     <c:set var="Section1Sunday" value="17"/>
      <c:set var="Section2Monday" value="21"/>
 <c:set var="Section2Tuesday" value="22"/>
  <c:set var="Section2Wednesday" value="23"/>
  <c:set var="Section2Thursday" value="24"/>
   <c:set var="Section2Friday" value="25"/>
    <c:set var="Section2Saturday" value="26"/>
     <c:set var="Section2Sunday" value="27"/>
         <c:set var="Section3Monday" value="31"/>
 <c:set var="Section3Tuesday" value="32"/>
  <c:set var="Section3Wednesday" value="33"/>
  <c:set var="Section3Thursday" value="34"/>
   <c:set var="Section3Friday" value="35"/>
    <c:set var="Section3Saturday" value="36"/>
     <c:set var="Section3Sunday" value="37"/>
         <c:set var="Section4Monday" value="41"/>
 <c:set var="Section4Tuesday" value="42"/>
  <c:set var="Section4Wednesday" value="43"/>
  <c:set var="Section4Thursday" value="44"/>
   <c:set var="Section4Friday" value="45"/>
    <c:set var="Section4Saturday" value="46"/>
     <c:set var="Section4Sunday" value="47"/>
         <c:set var="Section5Monday" value="51"/>
 <c:set var="Section5Tuesday" value="52"/>
  <c:set var="Section5Wednesday" value="53"/>
  <c:set var="Section5Thursday" value="54"/>
   <c:set var="Section5Friday" value="55"/>
    <c:set var="Section5Saturday" value="56"/>
     <c:set var="Section5Sunday" value="57"/>
     
                 
<tr>
   <td align="center">   
        <c:out value="8:00AM-10:10AM"/>
    <td align="center">   
        <c:out value="${studentschedule[Section1Monday]}"/>
    <td align="center"> 
	
        <c:out value="${studentschedule[Section1Tuesday]}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${studentschedule[Section1Wednesday]}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${studentschedule[Section1Thursday]}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${studentschedule[Section1Friday]}"/>  
    
   </td>
   <td align="center">
   
    <c:out value="${studentschedule[Section1Saturday]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${studentschedule[Section1Sunday]}"/>  
    
   </td>
   
	 </tr> 
	 
	 <tr>
   <td align="center">   
        <c:out value="10:30AM-12:40AM"/>
    <td align="center">   
        <c:out value="${studentschedule[Section2Monday]}"/>
    <td align="center"> 
	
        <c:out value="${studentschedule[Section2Tuesday]}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${studentschedule[Section2Wednesday]}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${studentschedule[Section2Thursday]}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${studentschedule[Section2Friday]}"/>  
    
   </td>
   <td align="center">
   
    <c:out value="${studentschedule[Section2Saturday]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${studentschedule[Section2Sunday]}"/>  
    
   </td>
   
	 </tr> 
	 
	 <tr>
   <td align="center">   
        <c:out value="1:00PM-3:10PM"/>
    <td align="center">   
        <c:out value="${studentschedule[Section3Monday]}"/>
    <td align="center"> 
	
        <c:out value="${studentschedule[Section3Tuesday]}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${studentschedule[Section3Wednesday]}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${studentschedule[Section3Thursday]}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${studentschedule[Section3Friday]}"/>  
    
   </td>
   <td align="center">
   
    <c:out value="${studentschedule[Section3Saturday]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${studentschedule[Section3Sunday]}"/>  
    
   </td>
   
	 </tr> 
	 
	 <tr>
   <td align="center">   
        <c:out value="3:30PM-5:40PM"/>
    <td align="center">   
        <c:out value="${studentschedule[Section4Monday]}"/>
    <td align="center"> 
	
        <c:out value="${studentschedule[Section4Tuesday]}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${studentschedule[Section4Wednesday]}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${studentschedule[Section4Thursday]}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${studentschedule[Section4Friday]}"/>  
    
   </td>
   <td align="center">
   
    <c:out value="${studentschedule[Section4Saturday]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${studentschedule[Section4Sunday]}"/>  
    
   </td>
   
	 </tr>
	 
	 <tr>
   <td align="center">   
        <c:out value="6:00PM-8:10PM"/>
    <td align="center">   
        <c:out value="${studentschedule[Section5Monday]}"/>
    <td align="center"> 
	
        <c:out value="${studentschedule[Section5Tuesday]}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${studentschedule[Section5Wednesday]}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${studentschedule[Section5Thursday]}"/>  
    
   </td> 
   <td align="center">
    <c:out value="${studentschedule[Section5Friday]}"/>  
    
   </td>
   <td align="center">
   
    <c:out value="${studentschedule[Section5Saturday]}"/>  
    
   </td> 
    <td align="center">
    <c:out value="${studentschedule[Section5Sunday]}"/>  
    
   </td>
   
	 </tr>  
	
	  </tbody> 
 </table> 

 </div> 
 <script  src="js/studentclassdetails.js"></script>
</form>

</body>
</html>


