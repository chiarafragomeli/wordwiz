package com.example.wordwiz;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.wordwiz.svc.LoginSvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")

public class Login extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Login.class);
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        log.trace("User is {" + user + "}");
        
        String password = request.getParameter("password");
        LoginSvc svc = new LoginSvc();
        if (svc.checkUser(user, password)) {
            request.getRequestDispatcher("dashboard.html").forward(request, response);
        } else {
            request.setAttribute("message", "Utente non riconosciuto");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
