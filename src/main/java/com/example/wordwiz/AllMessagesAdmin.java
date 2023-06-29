package com.example.wordwiz;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Message;
import com.example.wordwiz.svc.MessageSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/allmessagesadmin")
public class AllMessagesAdmin extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessageSvc svc = new MessageSvc(ds);
        List<Message> messages = svc.getAllMessages();
        
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("allMessagesAdmin.jsp").forward(request, response);
    }

}
