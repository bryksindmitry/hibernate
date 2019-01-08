package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args){
        // create ssession factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try{
            // use the session object to Save java object.
            System.out.println("Creating 3 students object...");

            // create a student object
            Student tempStudent = new Student("John", "Doe", "John@mail.ru");
            Student tempStudent2 = new Student("Mary", "Public", "Mary@mail.ru");
            Student tempStudent3 = new Student("Bonita", "Appleb", "Bonita@mail.ru");

            //start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println(" Saving the students...");
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !");
        }
        finally {
            factory.close();
        }



    }
}
