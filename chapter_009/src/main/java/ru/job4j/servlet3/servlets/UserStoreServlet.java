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
        List<User> listAllUser;
        listAllUser = userStore.getAllUser();
//I'am sure, if I will see this code after some months, I will be ashamed.
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "<table border=\"1\">\n" +
                "    <tr>\n" +
                "        <th>Name</th>\n" +
                "        <th>Login</th>\n" +
                "        <th>Email</th>\n" +
                "        <th>Date</th>\n" +
                "        <th>Update</th>\n" +
                "        <th>Delete</th>\n" +
                "    </tr>");

        for (User user : listAllUser) {
            String buttonUpd = String.format("<form action=\"http://%s:%d%s/main/update/\">\n" +
                    "    <input type=\"hidden\" name=\"login\" value=\"%s\" />\n" +
                    "    <button type=\"submit\">Update</button>\n" +
                    "</form>", req.getServerName(), req.getServerPort(), req.getContextPath(), user.getLogin());

            String buttonDel = String.format("<form action=\"http://%s:%d%s/main/delete/\">\n" +
                    "    <input type=\"hidden\" name=\"login\" value=\"%s\" />\n" +
                    "    <button type=\"submit\">Delete</button>\n" +
                    "</form>", req.getServerName(), req.getServerPort(), req.getContextPath(), user.getLogin());

            writer.append(String.format("<tr> <th>%s</th> <th>%s</th> <th>%s</th> <th>%s</th> <th>%s</th> <th>%s</th><t/r>",
                    user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate(), buttonUpd, buttonDel));
        }
        writer.append("</table>\n");
        writer.append(String.format("<p><a href=\"http://%s:%d%s/main/create/\">Create user</a></p>", req.getServerName(), req.getServerPort(), req.getContextPath()));
        writer.append("</center>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
    }
}
