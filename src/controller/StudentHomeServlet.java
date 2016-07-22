package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtil.Dataget;
import model.*;

/**
 * Servlet implementation class StudentHomeServlet
 */
@WebServlet("/StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String method=request.getParameter("method");
		
		String courseid=request.getParameter("courseid");
		String search=request.getParameter("searchcoursename");
		if(method!=null)
		{
		if(method.equals("Search"))
		{
			if(search==null)
			{
				List<Hcourse> courses=Dataget.getallcourse();
				session.setAttribute("Allcourses", courses);
				request.getRequestDispatcher("/studenthome.jsp").forward(request, response);
			}
			else
			{
				List<Hcourse> searchcourses=Dataget.searchallCourse(search);
				session.setAttribute("Allcourses", searchcourses);
				request.getRequestDispatcher("/studenthome.jsp").forward(request, response);
			}
		}
		}
		if(courseid!=null)
		{
			session.setAttribute("studentcourseid", courseid);
			List<Hclass> allclasses=Dataget.getallclassesbycourseid(Long.parseLong(courseid));
			
			session.setAttribute("AllclassesbyCourse", allclasses);
			
			HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
			
			session.setAttribute("Weekday", weekdayhashmap);
			
			Hstudent student=(Hstudent)session.getAttribute("student");
			
			List<Long> allclassids=Dataget.getallclassidsbycourseid(Long.parseLong(courseid));
			
			List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
			
			HashMap<Long, Long> classstatus=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
			
			session.setAttribute("classstatusforstudent", classstatus);
			
			request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
			
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
