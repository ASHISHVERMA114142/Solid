package Hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        FullName fullName=new FullName("dewashiv","verma");
        Student student=new Student(101,fullName,988);
        SessionFactory sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();


// TODO: we have a concept for lazy and eager fetching from the database , that completely depends upon the database .
// TODO: to save the data into the database
        session.persist(student);
//        TODO: to fetch the data from the database
        student= session.find(Student.class,101);
        System.out.println(student);
        // TODO: session.merge(student); for updating the particular record .

//        session.merge(student);
//session.remove(student);

// TODO: this transaction is not required while fetchig the data from the database .
        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
