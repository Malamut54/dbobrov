package ru.job4j.jsp.servlets;

import org.apache.log4j.Logger;
import ru.job4j.jsp.logic.User;
import ru.job4j.jsp.logic.UserStore;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Task JSP.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */

public class CreateUserServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(CreateUserServlet.class);
    /**
     * UserStore.
     */
    private final UserStore userStore = UserStore.getInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String name = req.getParameter("first_name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        userStore.addUser(new User(name, login, email));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
