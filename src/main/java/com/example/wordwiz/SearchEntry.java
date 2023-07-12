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
@WebServlet("/searchentry")
public class SearchEntry extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String entry = request.getParameter("entry");
        TextSvc svc = new TextSvc(ds);
        try {
            List<Text> texts = svc.getEntry(entry);
            request.setAttribute("text", texts);
            request.getRequestDispatcher("searchEntry.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            List<Text> texts = svc.getAllTexts();          
            request.setAttribute("text", texts);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("corpus.jsp").forward(request, response);
        }
    }
}
