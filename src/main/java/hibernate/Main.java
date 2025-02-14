package hibernate;

import hibernate.daos.CartDAO;
import hibernate.daos.ItemDAO;
import hibernate.daos.StudentsDAO;

import hibernate.daos.UserDAO;
import hibernate.modelos.*;
import hibernate.utils.HibernateUtil;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        students();
//users();

//        carts();
//        items();

        carritos();
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

    public static void carts() {
        CartDAO studentDAO = new CartDAO();

        // Create new cart
        Cart cart = new Cart();
        cart.setName("CART 1");
        studentDAO.saveCart(cart);

        // Update cart
        cart.setName("CART 2");
        studentDAO.updateCart(cart);

        // Get cart by ID
        Cart retrievedCart = studentDAO.getCartById(cart.getId());
        System.out.println("Retrieved Cart: " + retrievedCart.getName());

        // Get all carts
        List<Cart> carts = studentDAO.getAllCart();
        System.out.println("All Carts:");
        carts.forEach(cart1 -> System.out.println(cart1.getName()));

        // Delete cart
        studentDAO.deleteCart(cart.getId());

        // Get all carts after deletion
        carts = studentDAO.getAllCart();
        System.out.println("All Carts after deletion:");
        carts.forEach(cart1 -> System.out.println(cart1.getName()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
    public static void items() {
        ItemDAO studentDAO = new ItemDAO();

        // Create new item
        Item cart = new Item();
        cart.setName("CART 1");
        studentDAO.saveItem(cart);

        // Update item
        cart.setName("CART 2");
        studentDAO.updateItem(cart);

        // Get item by ID
        Item retrievedItem = studentDAO.getItemById(cart.getId());
        System.out.println("Retrieved Item: " + retrievedItem.getName());

        // Get all items
        List<Item> items = studentDAO.getItems();
        System.out.println("All Items:");
        items.forEach(item1 -> System.out.println(item1.getName()));

        // Delete item
        studentDAO.deleteItem(cart.getId());

        // Get all items after deletion
        items = studentDAO.getItems();
        System.out.println("All Items after deletion:");
        items.forEach(item1 -> System.out.println(item1.getName()));

        // Shut down the SessionFactory
        HibernateUtil.shutdown();

    }

    public static void carritos(){

        ItemDAO itemDAO = new ItemDAO();
        CartDAO cartDAO = new CartDAO();

        Item item1 = new Item();
        item1.setName("pelota");
        Item item2 = new Item();
        item2.setName("canasta");
        Item item3 = new Item();
        item3.setName("mancuernas");
        Item item4 = new Item();
        item4.setName("gafas");

        Set<Item> items = new java.util.HashSet<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        Cart cart = new Cart();
        cart.setName("CARRITO 1");
        cart.setItems(items);


        Cart cart2 = new Cart();
        cart2.setName("Carrito 2");
        cart2.setItems(items);


        cartDAO.saveCart(cart);
        cartDAO.saveCart(cart2);

        List<Item> items2 =itemDAO.getItems();

        List<Cart> carritos =cartDAO.getAllCart();

// PRUEBAS
        for (int i = 0; i < carritos.size() ; i++) {

            System.out.println(carritos.get(i).getName());
            System.out.println(carritos.get(i).getItems());
        }


        HibernateUtil.shutdown();



    }


}
