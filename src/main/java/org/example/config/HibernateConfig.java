package org.example.config;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
     @Getter
     private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
         try{
             return new Configuration()
                     .configure("hibernate.cfg.xml")
                     .buildSessionFactory();
         }catch(Exception e){
             System.out.println(e.getLocalizedMessage());
             return null;
         }
     }
}
