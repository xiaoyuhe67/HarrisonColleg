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
import model.Hinstructor;
import model.Hstudentclassbridge;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String method=request.getParameter("method");
		String search=request.getParameter("searchstudentname");
		
		if(method!=null)
		{
			if(method.equals("Search"))
			{
				if(search==null)
				{
							
					List<Hstudentclassbridge> studentlistbyclassid=Dataget.getstudentlistbyclassid(Long.parseLong(session.getAttribute("classid").toString()));
					session.setAttribute("studentlist", studentlistbyclassid);
					
					request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
				
				
				}
				else
				{
					List<Hstudentclassbridge> searchstudentlistbyclassid=Dataget.searchstudentfromstudentlistbyclass(search, Long.parseLong(session.getAttribute("classid").toString()));
					
					session.setAttribute("studentlist", searchstudentlistbyclassid);
					
					request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
					
					
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
