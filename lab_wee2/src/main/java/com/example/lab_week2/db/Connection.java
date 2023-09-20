package com.example.lab_week2.db;

import com.example.lab_week2.entity.Account;
import com.example.lab_week2.entity.GrantAccess;
import com.example.lab_week2.entity.Log;
import com.example.lab_week2.entity.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class Connection {
    public static Connection instance;
    private SessionFactory sessionFactory;
    private Connection() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(GrantAccess.class)
                .addAnnotatedClass(Log.class)
                .addAnnotatedClass(Role.class)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        System.out.println("connect!!");
    }
    public static Connection getInstance(){
        if(instance==null){
            instance = new Connection();
        }
        return instance;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
