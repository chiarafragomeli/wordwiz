package com.example.wordwiz;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.AdminSvc;

@SuppressWarnings("serial")
@WebServlet("/allUser")
public class AllUser extends HttpServlet {


	    @Resource(name = "jdbc/wordwiz")
	    private DataSource ds;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        AdminSvc svc = new AdminSvc(ds);
	        List<User> users = svc.getAllUsers ();
	        
	        request.setAttribute("user", users);
	        request.getRequestDispatcher("allUsersAdmin.jsp").forward(request, response);
	    }

}
