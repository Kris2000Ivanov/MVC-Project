package conntorllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import models.Bean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		//Bean loginBean = new Bean();

		//loginBean.setUsername(userName);
		//loginBean.setPassword(password);

		LoginDao loginDao = new LoginDao();

		Bean bean = loginDao.authenticateUser(userName,password);
		if (bean!=null) {
			//Трябва да сетвам нещо в сесията!
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", password);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
