package com.example.wordwiz;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")

public class Logout extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Logout.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.traceEntry();

        request.getSession().invalidate();
        request.setAttribute("message", "Hai terminato la tua sessione.");
        request.getRequestDispatcher("logout.jsp").forward(request, response);

    }
}