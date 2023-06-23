package com.example.wordwiz;

import java.io.IOException;

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
@WebServlet("/newentry")

public class NewEntry extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String entry = request.getParameter("entry");
        int classId = Integer.parseInt(request.getParameter("grammarClass"));
        String note = request.getParameter("note");
        EntrySvc svc = new EntrySvc(ds);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (svc.saveEntry(entry, note, classId, user.getId())) {
            request.setAttribute("message", "Lemma " + entry + " inserito.");
            request.getRequestDispatcher("newEntry.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Non è stato possibile inserire il lemma.");
            request.getRequestDispatcher("newEntry.jsp").forward(request, response);
        }
    }
}