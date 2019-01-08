package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String args[]){
        // create ssession factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            // use the session object to Save java object.
            System.out.println("Creating new student object...");

            // create a student object
            Student tempStudent = new Student("Paul", "Wall", "Paul@mail.ru");
            //start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println(" Saving the student...");
            session.save(tempStudent);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");
        }
        finally {

        }

    }
}
