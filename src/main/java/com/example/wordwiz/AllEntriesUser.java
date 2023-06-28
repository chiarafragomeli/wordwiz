package com.example.wordwiz;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Entry;
import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.EntrySvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/allentriesuser")
public class AllEntriesUser extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntrySvc svcEntry = new EntrySvc(ds);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user != null) {
            List<Entry> allEntries = svcEntry.getAllEntriesUser(user.getId());
            request.setAttribute("entries", allEntries);
            request.getRequestDispatcher("allEntriesUser.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Utente non riconosciuto");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
