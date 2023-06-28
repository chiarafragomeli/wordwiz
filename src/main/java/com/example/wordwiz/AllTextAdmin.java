package com.example.wordwiz;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Text;
import com.example.wordwiz.svc.TextSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/alltextadmin")
public class AllTextAdmin extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TextSvc svc = new TextSvc(ds);
        List<Text> texts = svc.getAllTexts();
        
        request.setAttribute("text", texts);
        request.getRequestDispatcher("corpusAdmin.jsp").forward(request, response);
    }
}
