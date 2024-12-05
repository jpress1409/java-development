package com.pluralsight.demo;

import com.pluralsight.demo.db.SimpleProductDAO;
import com.pluralsight.demo.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            SimpleProductDAO productDao = ctx.getBean(SimpleProductDAO.class);
            Scanner scan = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Choose an option:");
                System.out.println("1. List Products");
                System.out.println("2. Add Product");
                System.out.println("3. Exit");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Listing all products:");
                        productDao.getAll().forEach(System.out::println);
                        break;

                    case 2:
                        System.out.println("Enter product details:");
                        System.out.print("ID: ");
                        int id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Name: ");
                        String name = scan.nextLine();

                        System.out.print("Category: ");
                        String category = scan.nextLine();

                        System.out.print("Price: ");
                        double price = scan.nextDouble();

                        Product product = new Product(id, name, category, price);
                        productDao.add(product);
                        System.out.println("Product added successfully.");
                        break;

                    case 3:
                        running = false;
                        System.out.println("Good-Bye");
                        break;

                    default:
                        System.out.println("Invalid Entry.");
                }
            }

            scan.close();
        };
    }
}
