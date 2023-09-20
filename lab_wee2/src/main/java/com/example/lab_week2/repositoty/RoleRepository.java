package com.example.lab_week2.repositoty;

import com.example.lab_week2.db.Connection;
import com.example.lab_week2.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RoleRepository {
     private SessionFactory factory;

    public RoleRepository() {
        factory = Connection.getInstance().getSessionFactory();
    }
    public Role findOne(String id) {
        Transaction transaction = null;
        Role role = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            role = session.find(Role.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
