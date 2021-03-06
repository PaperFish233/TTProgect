package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LetTaps;
import factory.DAOFactory;

public class Users_FindTapsByIdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		int Lno=Integer.parseInt(request.getParameter("Lno"));
		try{
			LetTaps lettaps=DAOFactory.getLetTapsDAOInstance().FindTapsById(Lno);
			request.getSession().setAttribute("lettaps", lettaps);
			request.getRequestDispatcher("users_taps_let.jsp").forward(request, response); 
		}catch(Exception e)
		{
			e.printStackTrace();
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doGet(request, response);
	}
}
