package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtil.Dataget;
import Util.PasswordUtil;
import model.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		
		DBUtil.EmailValidator emailvalidator=new DBUtil.EmailValidator();
		String method=request.getParameter("method");
		if(method.equals("Create"))
		{
		try
		{
			String username=request.getParameter("username");
			String userpassword=request.getParameter("userpassword");
			String useremail=request.getParameter("useremail");
			String userfullname=request.getParameter("userfullname");
			String usermajor=request.getParameter("usermajor");
			String userentryyear=request.getParameter("userentryyear");
			
			if(username!=null&&userpassword!=null&&useremail!=null&&userfullname!=null&&usermajor!=null&&userentryyear!=null)
			{
				if(emailvalidator.validate(useremail))
				{
					Huser user=new Huser();
					user.setUseremail(useremail);
					user.setUsername(username);
					user.setPwd(userpassword);
					user.setUserrole(1);
					
					Dataget.insert(user);
					
					Huser inserteduser=Dataget.getUserByEmail(useremail);
	
					Hstudent student=new Hstudent();
					
					student.setStudentname(userfullname);
					
					
					Hmajor major=Dataget.getMajorByMajorName(usermajor);
					
					student.setHmajor(major);
					student.setHuser(inserteduser);
					student.setEntryyear(userentryyear);
					
					Dataget.insert(student);
					
					request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);;
					
				}
				else
				{
					request.setAttribute("result", "The email is not valided");
				}
			}
			else
			{
				request.setAttribute("result", "There is a null text");
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		else if(method.equals("Back"))
		{
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);;
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
