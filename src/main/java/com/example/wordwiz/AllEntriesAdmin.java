package com.example.wordwiz;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Entry;
import com.example.wordwiz.svc.AdminSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/allentriesadmin")
public class AllEntriesAdmin extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminSvc svc = new AdminSvc(ds);       
            List<Entry> allEntries = svc.getAllEntriesAdmin();
            
            request.setAttribute("entries", allEntries);
            request.getRequestDispatcher("allEntriesAdmin.jsp").forward(request, response);     
    }

}
