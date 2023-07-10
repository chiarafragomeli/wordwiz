package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.LoginSvc;
import com.example.wordwiz.svc.SignupSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/signup")

public class Signup extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginSvc loginSvc = new LoginSvc(ds);
        SignupSvc signupSvc = new SignupSvc(ds);

        try {
            if (signupSvc.saveUser(username, email, password)) {
                User user = loginSvc.get(username, password);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("message", "Welcome " + username + "!");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
}
