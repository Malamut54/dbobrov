package ru.job4j.servlet3.servlets;

import org.apache.log4j.Logger;
import ru.job4j.servlet3.logic.User;
import ru.job4j.servlet3.logic.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Task CRUD + HTML.
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method='post' class='reg-form'>\n" +
                "<div class='form-row'>\n" +
                "<label for='form_fname'>First Name: </label>\n" +
                "<input type='text' id='form_fname' name='first_name'>\n" +
                "</div>\n" +
                "<div class='form-row'>\n" +
                "<label for='form_flogin'>Login: </label>\n" +
                "<input type='text' id='form_flogin' name='login'>\n" +
                "</div>\n" +
                "<div class='form-row'>\n" +
                "<label for='form_email'>Email: </label>\n" +
                "<input type='email' id='form_email' name='email'>\n" +
                "</div>\n" +
                "<div class=\"form-row\">\n" +
                "<input type=\"submit\" value='Create'>\n" +
                "</div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String name = req.getParameter("first_name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        userStore.addUser(new User(name, login, email));
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
