package com.example.lab_week2.repositoty;

import com.example.lab_week2.db.Connection;
import com.example.lab_week2.entity.Account;
import com.example.lab_week2.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private SessionFactory factory;
    private RoleRepository roleRepository;

    public AccountRepository() {
        factory = Connection.getInstance().getSessionFactory();
        roleRepository = new RoleRepository();
    }
    public void insert(Account account){
        Transaction transaction = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.persist(account);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Account findOne(String id){
        Transaction transaction = null;
        Account account = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();
            account = session.find(Account.class, id);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return account;
    }
    public List<Account> fillAll(){
        Transaction transaction = null;
        List<Account> accounts = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();
            accounts = session.createQuery("from Account", Account.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return accounts;
    }
    public List<Role> getRoleByAccount(String id){
        Transaction transaction = null;
        List<Role> roles = new ArrayList<>();
        List<Object[]> list = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();
            String sql = "select t_role.role_id " +
                    "from t_account join t_grant_access " +
                    "on t_account.account_id = t_grant_access.account_id " +
                    "join t_role on t_role.role_id = t_grant_access.role_id " +
                    "where t_account.account_id = "+id;
            list = session.createNativeQuery(sql, Object[].class).getResultList();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        for (Object o : list){
            roles.add(roleRepository.findOne((String) o));
        }
        return roles;
    }

}
