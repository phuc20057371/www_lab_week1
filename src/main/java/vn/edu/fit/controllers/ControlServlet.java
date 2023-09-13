package vn.edu.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.fit.repositories.AccountRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    private AccountRepository repository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            HttpSession session = req.getSession(true);
            repository = new AccountRepository(session);
            String action = req.getParameter("action");
            System.out.println(action);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
