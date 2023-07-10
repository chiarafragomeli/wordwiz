package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.UpdateUserInfoSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/updatepassword")

public class UpdatePassword extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        
        UpdateUserInfoSvc  updateSvc = new UpdateUserInfoSvc(ds);
        int id = ((User)request.getSession().getAttribute("user")).getId();
        
        try { 
            if (updateSvc.updatePassword(oldPassword, newPassword, id)) {
                request.setAttribute("message", "Password changed.");
                request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }
            
        } catch(IllegalArgumentException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);
        }
    }
}
