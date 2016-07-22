package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtil.DBUtil;
import DBUtil.Dataget;
import model.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		
		if(request.getParameter("register")!=null)
		{
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		else
		{
		
		try
		{	
			String email= request.getParameter("email");
			String password=request.getParameter("password");
			Huser user=Dataget.getUserByEmail(email);		
			if(Dataget.isValidUser(email,password))
			{	
				List<Hclass> allclasses=Dataget.getallclasses();
				
				session.setAttribute("Allclasses", allclasses);
				
				List<Hcourse> allcourses=Dataget.getallcourse();
				
				session.setAttribute("Allcourses", allcourses);
				
				session.setAttribute("user", user);
				session.setAttribute("userid", user.getUserid());
				session.setAttribute("useremail",user.getUseremail());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("userpassword", user.getPwd());
				session.setAttribute("userrole", user.getUserrole());
				session.setAttribute("images", "https://www.gravatar.com/avatar/"+Util.MD5Util.md5Hex(user.getUseremail())+"?s=80");
				
				if(user.getUserrole()==1)
				{
					List<Hcourse> courses=Dataget.getallcourse();
					
					Hstudent student=Dataget.getStudentByUserid(user.getUserid());
					
					List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
					
					HashMap<String,String> studentschedule=Dataget.getSchedule(allstudentclass);
					
					session.setAttribute("student", student);
					
					session.setAttribute("Allcourses", courses);
					
					session.setAttribute("Allstudentclass", allstudentclass);
					
					session.setAttribute("studentschedule", studentschedule);
					
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					
					List<Long> allclassids=Dataget.getallclassids();
					List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
					
					HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
					
					session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
					
					request.getRequestDispatcher("/studenthome.jsp").forward(request, response);
				}
				else if(user.getUserrole()==2)
				{
					
					Hinstructor instructor=Dataget.getInstructorByUserid(user.getUserid());
					
					List<Hcourse> mycourses=Dataget.getCoursebyInstructor(instructor.getInstructorid());
					
					session.setAttribute("Allmycourses", mycourses);
					
					session.setAttribute("instructor", instructor);
					
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					List<Long> allclassids=Dataget.getallclassids();
					
					List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
					
					HashMap<Long,Long> allclassstatusforinstructor=Dataget.getclassStatusforinstructor(allclassids, allinstructorclassids);
					
					session.setAttribute("Allclassstatusforinstructor", allclassstatusforinstructor);
					
					request.getRequestDispatcher("/instructorhome.jsp").forward(request, response);
				}
						
					
			}	
			else
			{
				request.setAttribute("loginerror", "The user is not valid");
			
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}		
					
			
			
		}catch(Exception e)
		{
			String message1="There is no match";
			System.out.println(e.getMessage());
			request.setAttribute("loginerror", message1);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
	
		}
		finally
		{
			em.close();
			
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
