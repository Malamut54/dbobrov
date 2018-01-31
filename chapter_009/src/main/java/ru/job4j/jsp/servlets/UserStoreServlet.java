package ru.job4j.jsp.servlets;

import org.apache.log4j.Logger;
import ru.job4j.servlet3.logic.User;
import ru.job4j.servlet3.logic.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Task CRUD + HTML.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class UserStoreServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(UserStoreServlet.class);
    /**
     * Get instance.
     */
    private UserStore userStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
