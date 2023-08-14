package com.example.jparelacje;

import com.example.jparelacje.address.Address;
import com.example.jparelacje.category.Category;
import com.example.jparelacje.category.CategoryRepository;
import com.example.jparelacje.laptop.Laptop;
import com.example.jparelacje.product.Product;
import com.example.jparelacje.product.ProductRepository;
import com.example.jparelacje.student.Student;
import com.example.jparelacje.student.StudentRepository;
import com.example.jparelacje.student.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaRelacjeApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaRelacjeApplication.class, args);
        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);


        // ONE TO ONE
        Student student = new Student();
        student.setName("Zbyszek");
        student.setAbout("To jest opis Zbyszka");

        Laptop laptop = new Laptop();
        laptop.setModelNumber("13H#");
        laptop.setBrand("Panasonic");
        laptop.setStudent(student);

        student.setLaptop(laptop);

        studentRepository.save(student);


        //ONE TO MANY
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Laptok");
        laptop1.setModelNumber("asdf");

        Student student1 = new Student();
        student1.setName("Kasia");
        student1.setAbout("To jest opis Kasi");
        student1.setLaptop(laptop1);

        laptop1.setStudent(student1);

        Address address = new Address();
        address.setStreet("ul. Katowicka 12A/23");
        address.setCity("Chorzów");
        address.setCountry("Polska");
        address.setStudent(student1);

        Address address1 = new Address();
        address1.setStreet("ul. Kopernika 1/3");
        address1.setCity("Bydgoszcz");
        address1.setCountry("Polska");
        address1.setStudent(student1);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);

        student1.setAddressList(addressList);

        studentRepository.save(student1);


        // MANY TO MANY
        Category category1 = new Category();
        category1.setTitle("Electronics");

        Category category2 = new Category();
        category2.setTitle("Mobile Phone");

        Product product1 = new Product();
        product1.setName("Iphone 14 max PRO");

        Product product2 = new Product();
        product2.setName("Samsung S10");

        Product product3 = new Product();
        product3.setName("Samsung TV");


        Set<Product> category1Products = category1.getProducts();
        category1Products.add(product1);
        category1Products.add(product2);
        category1Products.add(product3);


        Set<Product> category2Products = category2.getProducts();
        category2Products.add(product1);
        category2Products.add(product2);

        categoryRepository.save(category1);

        categoryRepository.save(category2);




    }

}
