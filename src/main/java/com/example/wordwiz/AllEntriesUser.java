package com.example.wordwiz;

import java.io.IOException;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Entry;
import com.example.wordwiz.dao.User;
import com.example.wordwiz.svc.EntrySvc;
import com.example.wordwiz.svc.LoginSvc;

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
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        LoginSvc svc = new LoginSvc(ds);
        User user = svc.getUser(username, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
//          List <class> name = chimata al servizio che chiama il Dao
//            session.setAttribute("grammaticalClasses", grammaticalClasses);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Utente non riconosciuto");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
