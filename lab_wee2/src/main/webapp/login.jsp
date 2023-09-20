<%@ page import="java.nio.file.LinkOption" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab_week2.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: catly
  Date: 09/20/2023
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <h1>Account List</h1>
    <hr>
    <%
        if(request.getAttribute("account") != null){
            Account account = (Account) request.getAttribute("account");
           %>
              <div>
                  ID : <%= account.getAccountId() %>
                  Email : <%= account.getEmail() %>
                  Full Name : <%= account.getFullName() %>
                  Password : <%= account.getPassword() %>
                  Phone : <%= account.getPhone() %>
                  Status : <%= account.getStatus() %>

    </div>
            <%
        } else if (request.getAttribute("accounts") != null) {
            %>
            <div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">ID</th>
                            <th scope="col">Email</th>
                            <th scope="col">Full name</th>
                            <th scope="col">Password</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Status</th>
                        </tr>
                        </thead>
                        <% List<Account> accounts = (List<Account>) request.getAttribute("accounts");
                                int i = 0;
                              for (Account account : accounts) {
                              %>

                        <tbody>
                        <tr>
                            <td><%= i++ %></td>
                            <td> <%= account.getAccountId() %></td>
                            <td><%= account.getEmail() %></td>
                            <td><%= account.getFullName() %></td>
                            <td><%= account.getPassword() %></td>
                            <td><%= account.getPhone() %></td>
                            <td><%= account.getStatus() %></td>
                        </tr>
                            <%
            }
        }
        %>
                        </tbody>
                    </table>
                </div>
    <button> <a href="account.jsp">Create account</a></button>
    <hr>
    <button> <a href="index.jsp">Log out</a></button>
</body>
</html>
