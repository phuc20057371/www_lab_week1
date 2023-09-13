package vn.edu.fit.repositories;

import jakarta.servlet.http.HttpSession;
import vn.edu.fit.entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private Connection connection;
    private HttpSession session;

    public AccountRepository(HttpSession session) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb", "root", "sapassword");
        this.session = session;
    }


}
