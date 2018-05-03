package ru.job4j.todo.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.todo.model.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/create")
public class CreateItem extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("description");
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Item.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setDesc(desc);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(false);
        session.save(item);
        session.getTransaction().commit();
        session.close();

    }
}
