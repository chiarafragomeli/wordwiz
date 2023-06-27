package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.LoginSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")

public class Login extends HttpServlet {
	@Resource(name = "jdbc/wordwiz")
	private DataSource ds;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
//		check for superUser
		ServletContext sc = getServletContext();
		String admin = (String) sc.getAttribute("superUser");
		String adminPassword = (String) sc.getAttribute("superUserPassword");
		if (username.equals(admin) && password.equals(adminPassword)) {
		    User user = new User(0, admin, (String) sc.getAttribute("superUserEmail"));
		    HttpSession session = request.getSession();
            session.setAttribute("user", user);
//            inserire nei puntini la pagina dell'amministratore
            request.getRequestDispatcher("...").forward(request, response);
            return;
		}
		
		LoginSvc svc = new LoginSvc(ds);
		User user = svc.getUser(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Utente non riconosciuto");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
