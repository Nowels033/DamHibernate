package hibernate;

import hibernate.daos.StudentsDAO;

import hibernate.daos.UserDAO;
import hibernate.modelos.Address;
import hibernate.modelos.Students;
import hibernate.modelos.User;
import hibernate.utils.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        students();
users();
    }
    public static void students() {
        StudentsDAO studentDAO = new StudentsDAO();

        // Create new students
        Students student1 = new Students();
        student1.setName("Amit Sharma");
        student1.setEmail("amit.sharma@example.com");
        student1.setAverageMark(2.0f);

        Students student2 = new Students();
        student2.setName("Priya Singh");
        student2.setEmail("priya.singh@example.com");
        student2.setAverageMark(4.76f);

        // Save students
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);

        // Update student
        student1.setEmail("amit.sharma_updated@example.com");
        studentDAO.updateStudent(student1);
        student2.setEmail("nuevo@email.com");
        studentDAO.updateStudent(student2);

        // Get student by ID
        Students retrievedStudent = studentDAO.getStudentById(student1.getId());
        System.out.println("Retrieved Student: " + retrievedStudent.getName() + " - " + retrievedStudent.getEmail());

        // Get all students
        List<Students> students = studentDAO.getAllStudents();
        System.out.println("All Students:");
        students.forEach(student -> System.out.println(student.getName() + " - " + student.getEmail()));

        // Delete student
//        studentDAO.deleteStudent(student2.getId());

        // Get all students after deletion
        students = studentDAO.getAllStudents();
        System.out.println("All Students after deletion:");
        students.forEach(student -> System.out.println(student.getName() + " - " + student.getEmail()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();

    }
    public static void users() {
        UserDAO userDAO = new UserDAO();

        // Create new students
        User student1 = new User();
        User student2 = new User();

        // Save students
        userDAO.saveStudent(student1);
        userDAO.saveStudent(student2);

        // Update student
        student1.setAddress(new Address());
        userDAO.updateUser(student1);
        student2.setAddress(new Address());
        userDAO.updateUser(student2);

        // Get student by ID
        User retrievedStudent = userDAO.getUserById(student1.getId());
        System.out.println("Retrieved User: " + retrievedStudent.getId() + " - " + retrievedStudent.getAddress().getFullDescription());

        // Get all students
        List<User> students = userDAO.getAllUser();
        System.out.println("All Students:");
        students.forEach(student -> System.out.println(student.getId() + " - " + student.getAddress().getFullDescription()));

        // Delete student
//        studentDAO.deleteStudent(student2.getId());

        // Get all students after deletion
        students = userDAO.getAllUser();
        System.out.println("All Students after deletion:");
        students.forEach(student -> System.out.println(student.getId() + " - " + student.getAddress().getFullDescription()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
