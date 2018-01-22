package ru.job4j.servlet2;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Task Crud servlet.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 22.01.2018
 */


public class UsersServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(UsersServlet.class);
    /**
     * USerStore.
     */
    private final UserStore userStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("login");
        User user = userStore.getUser(login);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.format("Login - %s Name - %s Mail - %s Create Date - %s",
                user.getLogin(), user.getName(), user.getEmail(), user.getCreateDate()));
        writer.flush();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        userStore.addUser(new User(name, login, email));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newname");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        userStore.updateUser(newName, login, email);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        userStore.deleteUser(login);
    }
}
