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
import model.Hclass;
import model.Hcourse;
import model.Hinstructor;
import model.Hstudent;

/**
 * Servlet implementation class InstructorHomeServlet
 */
@WebServlet("/InstructorHomeServlet")
public class InstructorHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorHomeServlet() {
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
				Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
				List<Hcourse> mycourses=Dataget.getCoursebyInstructor(instructor.getInstructorid());
				
				session.setAttribute("Allmycourses", mycourses);
				
				request.getRequestDispatcher("/instructorhome.jsp").forward(request, response);
			}
			else
			{
				Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
				List<Hcourse> searchcourses=Dataget.searchcoursebyinstructor(search, instructor.getInstructorid());
				
				session.setAttribute("Allmycourses", searchcourses);
				request.getRequestDispatcher("/instructorhome.jsp").forward(request, response);
			}
		}
		}
		if(courseid!=null)
		{
			session.setAttribute("instructorcourseid", courseid);
			List<Hclass> allclasses=Dataget.getallclassesbycourseid(Long.parseLong(courseid));
			
			session.setAttribute("AllclassesbyCourse", allclasses);
			
			HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
			
			session.setAttribute("Weekday", weekdayhashmap);
			
			Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
			
			List<Long> allclassids=Dataget.getallclassidsbycourseid(Long.parseLong(courseid));
			
			List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
			
			HashMap<Long, Long> classstatus=Dataget.getclassStatusforinstructor(allclassids, allinstructorclassids);
			
			session.setAttribute("classstatusforinstructor", classstatus);
			
			request.getRequestDispatcher("/instructorclassdetails.jsp").forward(request, response);
			
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
