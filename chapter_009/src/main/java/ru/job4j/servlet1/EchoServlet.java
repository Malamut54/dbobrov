package ru.job4j.servlet1;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Task1.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 12.01.2018
 */


public class EchoServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Hello world " + login);
        writer.flush();

    }
}
