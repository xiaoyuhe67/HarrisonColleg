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
 * Servlet implementation class StudentClassServlet
 */
@WebServlet("/StudentClassServlet")
public class StudentClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String classid=request.getParameter("classid");
		String search=request.getParameter("searchcrnnumber");
		String method=request.getParameter("method");
		
		if(classid!=null)
		{
		
		Hstudent student=(Hstudent)session.getAttribute("student");
		
		Dataget.dropclass(Long.parseLong(classid), student.getStudentid());
		
		List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
		
		session.setAttribute("Allstudentclass", allstudentclass);
		
		HashMap<String,String> studentschedule=Dataget.getSchedule(allstudentclass);
		
		session.setAttribute("studentschedule", studentschedule);
		
		List<Long> Allallclassids=Dataget.getallclassids();
		List<Long> Allallstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
		
		HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(Allallclassids, Allallstudentclassids);
		
		session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
		
		request.getRequestDispatcher("/studentclass.jsp").forward(request, response);
		}
		
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
					Hstudent student=(Hstudent)session.getAttribute("student");
					List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
					
					session.setAttribute("Allstudentclass", allstudentclass);
					
						
					request.getRequestDispatcher("/studentclass.jsp").forward(request, response);
				
				
				}
				else
				{
					Hstudent student=(Hstudent)session.getAttribute("student");
					List<Hclass> allsearchclasses=Dataget.searchClassesbystudentid(search, student.getStudentid());
					
					session.setAttribute("Allstudentclass", allsearchclasses);
					
					request.getRequestDispatcher("/studentclass.jsp").forward(request, response);
					
					
				}
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
