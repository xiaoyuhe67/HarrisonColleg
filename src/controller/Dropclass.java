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
 * Servlet implementation class Dropclass
 */
@WebServlet("/Dropclass")
public class Dropclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dropclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String classid=request.getParameter("classid");
		
		Hstudent student=(Hstudent)session.getAttribute("student");
				
		Dataget.dropclass(Long.parseLong(classid), student.getStudentid());
		
		List<Hclass> allclasses=Dataget.getallclassesbycourseid(Long.parseLong((session.getAttribute("studentcourseid").toString())));
		
		session.setAttribute("AllclassesbyCourse", allclasses);
		
		HashMap<Long, String> weekdayhashmap=Dataget.weekdayhashmap();
		
		session.setAttribute("Weekday", weekdayhashmap);
		
		List<Hclass> allstudentclass=Dataget.getallclassesbystudentid(student.getStudentid());
		
		session.setAttribute("Allstudentclass", allstudentclass);
		
		HashMap<String,String> studentschedule=Dataget.getSchedule(allstudentclass);
		
		session.setAttribute("studentschedule", studentschedule);
		
		List<Long> allclassids=Dataget.getallclassidsbycourseid(Long.parseLong((session.getAttribute("studentcourseid").toString())));
		
		List<Long> allstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
		
		HashMap<Long, Long> classstatus=Dataget.getclassStatusforstudent(allclassids, allstudentclassids);
		
		session.setAttribute("classstatusforstudent", classstatus);
		
		List<Long> Allallclassids=Dataget.getallclassids();
		List<Long> Allallstudentclassids=Dataget.getallclassidsbystudentid(student.getStudentid());
		
		HashMap<Long,Long> allclassstatusforstudent=Dataget.getclassStatusforstudent(Allallclassids, Allallstudentclassids);
		
		session.setAttribute("Allclassstatusforstudent", allclassstatusforstudent);
		
		request.getRequestDispatcher("/studentclassdetails.jsp").forward(request, response);
		
		
	}

}
