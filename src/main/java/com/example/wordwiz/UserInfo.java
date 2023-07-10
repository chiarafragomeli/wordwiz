package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.LoginSvc;
import com.example.wordwiz.svc.UpdateUserInfoSvc;

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
        
        LoginSvc loginSvc = new LoginSvc(ds);
        UpdateUserInfoSvc  updateSvc = new UpdateUserInfoSvc(ds);
        int id = ((User)request.getSession().getAttribute("user")).getId();
        
        try { 
            if (updateSvc.updateEmail(newEmail, id)) {
                User user = loginSvc.get(username, newEmail);
                HttpSession session = request.getSession();
                session.setAttribute("info", user);
                request.setAttribute("message", "Email address changed.");
                request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }
            
        } catch(IllegalArgumentException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }
    }
}
