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
import model.*;

/**
 * Servlet implementation class InstructorClassDetailsServlet
 */
@WebServlet("/InstructorClassDetailsServlet")
public class InstructorClassDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorClassDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String method=request.getParameter("method");
		String search=request.getParameter("searchcrnnumber");
		String classid=request.getParameter("classid");
		
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
					List<Hclass> allclasses=Dataget.getallclassesbycourseid(Long.parseLong(session.getAttribute("instructorcourseid").toString()));
					
					session.setAttribute("AllclassesbyCourse", allclasses);
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
					
					List<Long> allclassids=Dataget.getallclassidsbycourseid(Long.parseLong(session.getAttribute("instructorcourseid").toString()));
					
					List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
					
					HashMap<Long, Long> classstatus=Dataget.getclassStatusforinstructor(allclassids, allinstructorclassids);
					
					session.setAttribute("classstatusforinstructor", classstatus);
					
					request.getRequestDispatcher("/instructorclassdetails.jsp").forward(request, response);
				
				
				}
				else
				{
					List<Hclass> allsearchclasses=Dataget.searchClassesbycourse(search, Long.parseLong(session.getAttribute("instructorcourseid").toString()));
					
					session.setAttribute("AllclassesbyCourse", allsearchclasses);
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
					
					List<Long> allclassids=Dataget.searchClassidsbycourse(search, Long.parseLong(session.getAttribute("instructorcourseid").toString()));
					
					List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
					
					HashMap<Long, Long> classstatus=Dataget.getclassStatusforstudent(allclassids, allinstructorclassids);
					
					session.setAttribute("classstatusforinstructor", classstatus);
					
					request.getRequestDispatcher("/instructorclassdetails.jsp").forward(request, response);
					
					
				}
			}
		}
		if(classid!=null)
		{
			
			session.setAttribute("classid", classid);
			
			Hclass myclass=Dataget.getClassByClassid(Long.parseLong(classid));
			
			session.setAttribute("myclass", myclass);
			List<Hstudentclassbridge> studentlistbyclassid=Dataget.getstudentlistbyclassid(Long.parseLong(classid));
			session.setAttribute("studentlist", studentlistbyclassid);
				
			
			request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
			
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
