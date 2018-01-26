package ru.job4j.servlet3.servlets;

import org.apache.log4j.Logger;
import ru.job4j.servlet3.logic.UserStore;

import javax.servlet.http.HttpServlet;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 26.01.2018
 */


public class GetUserServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(GetUserServlet.class);
    /**
     * UserStore.
     */
    private final UserStore userStore = UserStore.getInstance();
}
