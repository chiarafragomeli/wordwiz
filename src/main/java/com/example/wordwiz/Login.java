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
        String admin = (String) sc.getInitParameter("superUser");
        String adminPassword = (String) sc.getInitParameter("superUserPassword");
        if (username.equals(admin) && password.equals(adminPassword)) {
            User user = new User(0, admin, (String) sc.getInitParameter("superUserEmail"));
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
            return;
        }

        LoginSvc svc = new LoginSvc(ds);

        try (User user = svc.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
