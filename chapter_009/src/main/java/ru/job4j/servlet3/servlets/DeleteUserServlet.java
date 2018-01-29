package ru.job4j.servlet3.servlets;

import org.apache.log4j.Logger;
import ru.job4j.servlet3.logic.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Task CRUD + HTML.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class DeleteUserServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(DeleteUserServlet.class);
    /**
     * UserStore.
     */
    private final UserStore userStore = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginForDel = req.getParameter("login");
        userStore.deleteUser(loginForDel);
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
