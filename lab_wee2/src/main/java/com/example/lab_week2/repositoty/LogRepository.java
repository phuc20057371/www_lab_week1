package com.example.lab_week2.repositoty;

import com.example.lab_week2.db.Connection;
import com.example.lab_week2.entity.Account;
import com.example.lab_week2.entity.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LogRepository {
    private SessionFactory factory;
    public LogRepository() {
        factory = Connection.getInstance().getSessionFactory();
    }
    public void insert(Log log){
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(log);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
