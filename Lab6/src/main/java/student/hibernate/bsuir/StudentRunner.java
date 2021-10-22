package student.hibernate.bsuir;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        StudentRunner studentRunner = new StudentRunner();

        System.out.println("Adding student's records to the DB");


        studentRunner.addStudent(1, "Petrov", 22);
        studentRunner.addStudent(2, "Smirnov", 21);
        studentRunner.addStudent(3, "Antonova", 20);
        studentRunner.addStudent(4, "Kuzmina", 21);

        System.out.println("List of students");


        List<Student> students = studentRunner.listStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("===================================");
        System.out.println("Removing Some student and updating them");

        studentRunner.updateStudent(18, 45);
        studentRunner.removeStudent(20);

        System.out.println("Final list of students");


        students = studentRunner.listStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("===================================");

    }

    public void addStudent(int id, String name, int age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = new Student(id, name, age);
        session.save(student);
        transaction.commit();
        session.close();
    }

    public List<Student> listStudents() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Student> students = session.createQuery("FROM student").list();

        transaction.commit();
        session.close();
        return students;
    }

    public void updateStudent(int id, int age) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        student.setAge(age);
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void removeStudent(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

}