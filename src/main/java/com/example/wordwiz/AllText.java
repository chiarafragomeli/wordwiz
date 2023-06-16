
package com.example.wordwiz;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.example.wordwiz.dao.Text;
import com.example.wordwiz.svc.TextSvc;

@SuppressWarnings("serial")
@WebServlet("/alltext")
public class AllText extends HttpServlet {
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TextSvc svc = new TextSvc(ds);
        List<Text> texts = svc.getAllTexts();

    }
}
