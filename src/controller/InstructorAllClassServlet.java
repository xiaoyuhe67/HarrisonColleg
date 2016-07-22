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
 * Servlet implementation class InstructorAllClassServlet
 */
@WebServlet("/InstructorAllClassServlet")
public class InstructorAllClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorAllClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		Hinstructor instructor=(Hinstructor)session.getAttribute("instructor");
		
		String search=request.getParameter("searchcrnnumber");
		
		String method=request.getParameter("method");
		
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
					List<Hclass> allclasses=Dataget.getallclasses();
					
					session.setAttribute("Allclasses", allclasses);
					
					List<Long> allclassids=Dataget.getallclassids();
					
					List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
					
					HashMap<Long,Long> allclassstatusforinstructor=Dataget.getclassStatusforinstructor(allclassids, allinstructorclassids);
					
					session.setAttribute("Allclassstatusforinstructor", allclassstatusforinstructor);
					
						
					request.getRequestDispatcher("/allclassforinstructor.jsp").forward(request, response);
				
				
				}
				else
				{
					
					List<Hclass> allsearchclasses=Dataget.searchclass(search);
					
					session.setAttribute("Allclasses", allsearchclasses);
					
					List<Long> allsearchclassids=Dataget.searchclassids(search);
					List<Long> allinstructorclassids=Dataget.getallclassidsbyinstructorid(instructor.getInstructorid());
					
					HashMap<Long,Long> allclassstatusforinstructor=Dataget.getclassStatusforinstructor(allsearchclassids, allinstructorclassids);
					
					session.setAttribute("Allclassstatusforinstructor", allclassstatusforinstructor);
					
					request.getRequestDispatcher("/allclassforinstructor.jsp").forward(request, response);
					
					
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
