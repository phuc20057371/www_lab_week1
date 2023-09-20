package com.example.lab_week2.controller;

import com.example.lab_week2.db.Connection;
import com.example.lab_week2.entity.Account;
import com.example.lab_week2.repositoty.AccountRepository;
import com.example.lab_week2.services.AccountService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "accountServlet", value = "/account")
public class AccountController extends HttpServlet {
    private AccountService accountService;
    public AccountController() {
        accountService = new AccountService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<Account> accounts = accountService.fillAll();
            Account account = accounts.get(accounts.size()-1);
            int id =Integer.parseInt(account.getAccountId()) ;
            id++;
            Account acc = new Account();
            acc.setAccountId(String.valueOf(id));
            acc.setEmail(req.getParameter("email"));
            acc.setFullName(req.getParameter("fullname"));
            acc.setPassword(req.getParameter("pwd"));
            acc.setStatus(1);
            accountService.insert(acc);
            resp.sendRedirect(req.getContextPath() + "/result.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
