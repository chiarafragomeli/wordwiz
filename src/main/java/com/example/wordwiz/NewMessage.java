package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.MessageSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/newmessage")
public class NewMessage extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        MessageSvc svc = new MessageSvc(ds);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (svc.saveMessage(message, user.getId())) {
            request.setAttribute("check", "Il messaggio è stato inviato correttamente.");
            request.getRequestDispatcher("contactForm.jsp").forward(request, response);
        } else {
            request.setAttribute("check", "Non è stato possibile inviare il messaggio.");
            request.getRequestDispatcher("contactForm.jsp").forward(request, response);
        }
    }

}
