package com.hibernate.dao;

import com.hibernate.entity.Menu;
import com.hibernate.entity.Role;
import com.hibernate.entity.User;
import com.hibernate.until.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JuntTest {
     Session session=null;
    @Before
    public void before(){
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }
    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void add(){
        User u1=new User();
        User u2=new User();
        User u3=new User();
        u1.setAccount("崇祯");
        u2.setAccount("魏忠贤");
        u3.setAccount("林则徐");
        Role r1=new Role();
        Role r2=new Role();
        Role r3=new Role();
        r1.setName("皇帝");
        r2.setName("太监");
        r3.setName("大臣");
        Menu m1=new Menu();
        Menu m2=new Menu();
        Menu m3=new Menu();
        Menu m4=new Menu();
        m1.setName("宫里");
        m2.setName("政治");
        m3.setName("军事");
        m4.setName("地方");
        r1.getMenu().add(m1);
        r1.getMenu().add(m2);
        r1.getMenu().add(m3);
        r1.getMenu().add(m4);
        r2.getMenu().add(m1);
        r3.getMenu().add(m2);
        r3.getMenu().add(m3);
        r3.getMenu().add(m4);
        u1.getRole().add(r1);
        u2.getRole().add(r2);
        u2.getRole().add(r3);
        u3.getRole().add(r3);

        session.save(u1);
        session.save(u2);
        session.save(u3);
    }
    @Test
    public void update(){
        User user = session.get(User.class, 1);
        Role role = session.get(Role.class, 1);
        Menu menu = session.get(Menu.class, 1);
        user.getRole().add(role);
    }
}
