<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default" style="background-color: #01579b">
  <div class="container-fluid ">
    <div class="navbar-header" >
      <a class="navbar-brand " href="login.jsp" style="color: #fff; font-weight: bold;font-size:20px">Harrison College</a>
    </div>
    <ul class="nav navbar-nav">
     <li><a href="userprofile.jsp" style="color: #fff; font-weight: bold;font-size:20px"><img src= ${ images}  width="20" height="20"></img> ${username}</a></li>
      <c:if test="${userrole == 1}">
      <li ><a href="studenthome.jsp" style="color: #fff; font-weight: bold;font-size:20px" >All Courses
      </a></li>
       <li><a href="studentschedule.jsp" style="color: #fff; font-weight: bold;font-size:20px" >View Schedule
      </a></li>
      <li><a href="studentclass.jsp" style="color: #fff; font-weight: bold;font-size:20px" >View My Classes
      </a></li>
      <li><a href="allclassforstudent.jsp" style="color: #fff; font-weight: bold;font-size:20px" >View All Classes
      </a></li>    
      </c:if>
      <c:if test="${userrole == 2}">
      <li><a href="instructorhome.jsp" style="color: #fff; font-weight: bold;font-size:20px" >All My Courses
      </a></li>
      <li> <a href="allcourseforinstructor.jsp" style="color: #fff; font-weight: bold;font-size:20px" >All Courses
      </a></li>
      <li> <a href="allclassforinstructor.jsp" style="color: #fff; font-weight: bold;font-size:20px" >View All Classes
      </a></li>    
      </c:if>
      
      <li ><a href="<%=request.getContextPath() %>/Logout"  style="color: #fff; font-weight: bold;font-size:20px">Log Out</a></li>
    </ul>
  
  </div>
</nav>