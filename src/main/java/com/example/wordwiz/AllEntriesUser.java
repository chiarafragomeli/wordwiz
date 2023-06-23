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
@WebServlet("/allentriesuser")

public class AllEntriesUser extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
