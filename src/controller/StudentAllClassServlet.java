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
 * Servlet implementation class StudentAllClassServlet
 */
@WebServlet("/StudentAllClassServlet")
public class StudentAllClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAllClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		String classid=request.getParameter("classid");
		
		Hstudent student=(Hstudent)session.getAttribute("student");
		
		String search=request.getParameter("searchcrnnumber");
		String method=request.getParameter("method");
		
		if(classid!=null)
		{
			Dataget.dropclass(Long.parseLong(classid), student.getStudentid());
			
			HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
			
			session.setAttribute("Weekday", weekdayhashmap);
			
			List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
			
			session.setAttribute("Allstudentclass", allstudentclass);
			
			HashMap<String,String> studentschedule=Dataget.getSchedule(allstudentclass);
			
			session.setAttribute("studentschedule", studentschedule);
			
			
			List<Long> Allallclassids=Dataget.getallclassids();
			List<Long> Allallstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
			
			HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(Allallclassids, Allallstudentclassids);
			
			session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
			
			request.getRequestDispatcher("/allclassforstudent.jsp").forward(request, response);
			
			
		}
		
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
					List<Hclass> allclasses=Dataget.getallclasses();
					
					session.setAttribute("Allclasses", allclasses);
					
					List<Long> allclassids=Dataget.getallclassids();
					List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
					
					HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
					
					session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
					
						
					request.getRequestDispatcher("/allclassforstudent.jsp").forward(request, response);
				
				
				}
				else
				{
					
					List<Hclass> allsearchclasses=Dataget.searchclass(search);
					
					session.setAttribute("Allclasses", allsearchclasses);
					
					List<Long> allsearchclassids=Dataget.searchclassids(search);
					List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
					HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(allsearchclassids, allstudentclassids);
					
					session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
					
					request.getRequestDispatcher("/allclassforstudent.jsp").forward(request, response);
					
					
				}
			}
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String classid=request.getParameter("classid");
		
		Hstudent student=(Hstudent)session.getAttribute("student");
		
		Hclass myclass=Dataget.getClassByClassid(Long.parseLong(classid));
		
		List<Hclass> enrolledclass=Dataget.getallclassesbystudentid(student.getStudentid());
		
		if(Dataget.checktimeConflict(myclass, enrolledclass)==false)
		{
			if(Dataget.checkcapacity(myclass)==false)
			{
				Dataget.enrollclass(Long.parseLong(classid), student.getStudentid());
				
			
				HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
				
				session.setAttribute("Weekday", weekdayhashmap);
				
				List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
				
				session.setAttribute("Allstudentclass", allstudentclass);
				
				HashMap<String,String> studentschedule=Dataget.getSchedule(allstudentclass);
				
				session.setAttribute("studentschedule", studentschedule);
				
				
				List<Long> Allallclassids=Dataget.getallclassids();
				List<Long> Allallstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
				
				HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(Allallclassids, Allallstudentclassids);
				
				session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
				
				request.getRequestDispatcher("/allclassforstudent.jsp").forward(request, response);
				
			}
			else
			{
				session.setAttribute("Error", "Sorry, This class doesn't have extra space for you!!");
				request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
			}
		}
		else
		{
			session.setAttribute("Error", "This class is time conflicted with your current enrolled classes!!");
			request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
		}
	}

}
