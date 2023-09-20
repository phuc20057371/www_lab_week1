package com.example.lab_week2.controller;

import com.example.lab_week2.entity.Account;
import com.example.lab_week2.entity.Log;
import com.example.lab_week2.entity.Role;
import com.example.lab_week2.repositoty.AccountRepository;
import com.example.lab_week2.services.AccountService;
import com.example.lab_week2.services.LogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginController extends HttpServlet {
    private AccountService accountService;
    private LogService logService;

    public LoginController() {
        accountService = new AccountService();
        logService = new LogService();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("pwd");
        Account account = new Account(id, password);
        PrintWriter out = resp.getWriter();
        Account account1 = accountService.findOne(id);
        if(account1!=null && account1.getPassword().equals(password)){
            List<Role> roles = accountService.getRoleByAccount(id);
            for(Role role : roles){
                if(role.getRoleName().equalsIgnoreCase("admin")){
                   List<Account> accounts = accountService.fillAll();

                     req.setAttribute("accounts", accounts);
                     logService.insert(new Log(account1.getAccountId(),new Date(System.currentTimeMillis()),null,"Login success"));
                     req.getRequestDispatcher("/login.jsp").forward(req, resp);
                   break;
                }
                else{
                    req.setAttribute("account", account1);

                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }else{
            out.println("<h1> Login failed <h1>");
        }

    }
}
