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
import model.Hstudent;

/**
 * Servlet implementation class StudentClassDetailsServlet
 */
@WebServlet("/StudentClassDetailsServlet")
public class StudentClassDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentClassDetailsServlet() {
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
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
					List<Hclass> allclasses=Dataget.getallclassesbycourseid(Long.parseLong(session.getAttribute("studentcourseid").toString()));
					
					session.setAttribute("AllclassesbyCourse", allclasses);
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					Hstudent student=(Hstudent)session.getAttribute("student");
					
					List<Long> allclassids=Dataget.getallclassidsbycourseid(Long.parseLong(session.getAttribute("studentcourseid").toString()));
					
					List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
					
					HashMap<Long, Long> classstatus=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
					
					session.setAttribute("classstatusforstudent", classstatus);
					
					request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
				
				
				}
				else
				{
					List<Hclass> allsearchclasses=Dataget.searchClassesbycourse(search, Long.parseLong(session.getAttribute("studentcourseid").toString()));
					session.setAttribute("AllclassesbyCourse", allsearchclasses);
					HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
					
					session.setAttribute("Weekday", weekdayhashmap);
					
					Hstudent student=(Hstudent)session.getAttribute("student");
					
					List<Long> allclassids=Dataget.searchClassidsbycourse(search, Long.parseLong(session.getAttribute("studentcourseid").toString()));
					
					List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
					
					HashMap<Long, Long> classstatus=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
					
					session.setAttribute("classstatusforstudent", classstatus);
					
					request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
					
					
				}
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
