package Hibernet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//        FullName fullName=new FullName("dewashiv","verma");
//        Student student=new Student(101,fullName,988);
//        SessionFactory sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//
//
//// TODO: we have a concept for lazy and eager fetching from the database , that completely depends upon the database .
//// TODO: to save the data into the database
//        session.persist(student);
////        TODO: to fetch the data from the database
//        student= session.find(Student.class,101);
//        System.out.println(student);
//        // TODO: session.merge(student); for updating the particular record .
//
////        session.merge(student);
////session.remove(student);
//
//// TODO: this transaction is not required while fetchig the data from the database .
//        transaction.commit();
//        session.close();
//        sessionFactory.close();

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//        Laptop laptop=new Laptop(101,"linux");
//        Laptop laptop1=new Laptop(102,"windows");
//        User user =new User();
//        user.setId(1);
//        user.setMoney(1111);
//        user.setName("abc");
//        user.getLaptopList().add(laptop);
//        user.getLaptopList().add(laptop1);
//        laptop1.setUser(user);
//        laptop.setUser(user);
//        session.persist(laptop1);
//        session.persist(laptop);
//        session.persist(user);
//        transaction.commit();
//        session.close();
//        User user1=(User)session.get(User.class,1);
//        System.out.println(user1);
//        Session session1=sessionFactory.openSession();
//        user1= (User)session1.get(User.class,1);
//        System.out.println(user1);
//        System.out.println(sessionFactory.getStatistics().getSecondLevelCacheHitCount());
//        session1.close();

//        FullName fullName=new FullName("dewashiv","verma");
//        Student student =new Student(1,fullName,0432);
//
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(student);
//        session.getTransaction().commit();
//        session.close();

        Session session2=sessionFactory.openSession();
        session2.beginTransaction();
        Query q1= session2.createQuery("from Student where id=1");
        q1.setCacheable(true);
        Student student1=(Student) q1.uniqueResult();
        System.out.println(student1);
        session2.getTransaction().commit();
        session2.close();

        Session session3=sessionFactory.openSession();
        session3.beginTransaction();
        Query q2=session3.createQuery("from Student where id=1");
        q2.setCacheable(true);
        Student student2=(Student) q2.uniqueResult();
        System.out.println(student2);
        session3.getTransaction().commit();
        session3.close();
        sessionFactory.close();
    }
}
