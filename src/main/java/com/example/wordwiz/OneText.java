package com.example.wordwiz;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.sql.DataSource;

import com.example.wordwiz.dao.Text;
import com.example.wordwiz.svc.TextSvc;

@SuppressWarnings("serial")
@WebServlet("/onetext")
public class OneText extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        TextSvc svc = new TextSvc(ds);
        Text text = svc.getText(Integer.parseInt(id));
        
        request.setAttribute("text", text);
        request.getRequestDispatcher("oneText.jsp").forward(request, response);
    }
}
