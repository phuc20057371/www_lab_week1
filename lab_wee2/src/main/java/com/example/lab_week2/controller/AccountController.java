package com.example.lab_week2.controller;

import com.example.lab_week2.db.Connection;
import com.example.lab_week2.entity.Account;
import com.example.lab_week2.repositoty.AccountRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "accountServlet", value = "/account")
public class AccountController extends HttpServlet {
    @Inject
    private AccountRepository accountRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountRepository = new AccountRepository();
        Account account = accountRepository.findOne("1");
        req.setAttribute("account", account);
        req.getRequestDispatcher("/account.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountRepository = new AccountRepository();
        Account account = new Account();
        account.setAccountId(req.getParameter("id"));
        account.setFullName(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        accountRepository.insert(account);
        resp.sendRedirect(req.getContextPath() + "/account");
    }
}
