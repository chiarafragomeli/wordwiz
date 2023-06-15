package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.LoginSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/userinfo")

public class UserInfo extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newEmail = request.getParameter("newEmail");
        String username = request.getParameter("user");
        
        LoginSvc svc = new LoginSvc(ds);
        int id = ((User)request.getSession().getAttribute("user")).getId();
        
        if (svc.updateUser(newEmail, id)) {
            User user = svc.getUser(username, newEmail);
            HttpSession session = request.getSession();
            session.setAttribute("email", user);
            request.setAttribute("message", "Email modificata.");
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Non è stato possibile modificare l'email.");
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }
    }
}
