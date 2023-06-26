/*
 * Introduction to Jakarta Enterprise Edition - Servlet
 * 
 * https://github.com/egalli64/jees
 */
package com.example.wordwiz;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.wordwiz.svc.GrammaticalClassSvc;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Listen on web app events, add an attribute to the servlet context at startup
 */
@WebListener
public class WordwizContextListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(WordwizContextListener.class);
    @Resource(name = "jdbc/wordwiz")
    private DataSource ds;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        log.traceEntry();
        GrammaticalClassSvc svc = new GrammaticalClassSvc(ds);
        sce.getServletContext().setAttribute("grammClasses", svc.getAll());
    }
}
