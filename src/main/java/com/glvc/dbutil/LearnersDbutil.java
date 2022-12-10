package com.glvc.dbutil;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.glvc.main.Course;
import com.glvc.main.Designation;
import com.glvc.main.Student;
import com.glvc.main.Subject;
import com.glvc.main.Teacher;
import com.glvc.main.User;

public class LearnersDbutil {
 private static SessionFactory sessionFactory;

 public static SessionFactory getSessionFactory() {
  if (sessionFactory == null) {
   try {
    Configuration configuration = new Configuration();

    Properties settings = new Properties();
    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/learnersacademy?useSSL=false");
    settings.put(Environment.USER, "root");
    settings.put(Environment.PASS, "123456");
    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

    settings.put(Environment.SHOW_SQL, "true");

    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

    //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

    configuration.setProperties(settings);
    configuration.addAnnotatedClass(User.class);
    configuration.addAnnotatedClass(Student.class);
    configuration.addAnnotatedClass(Designation.class);
    configuration.addAnnotatedClass(Course.class);
    configuration.addAnnotatedClass(Subject.class);
    configuration.addAnnotatedClass(Teacher.class);

    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).build();
    System.out.println("Hibernate Java Config serviceRegistry created");
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;

   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return sessionFactory;
 }
}
