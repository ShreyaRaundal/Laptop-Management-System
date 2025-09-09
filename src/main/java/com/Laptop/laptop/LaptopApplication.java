package com.Laptop.laptop;

import com.Laptop.laptop.Dao.LaptopDAO;
import com.Laptop.laptop.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LaptopDAO laptopDAO) {
        return runner -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== Laptop Management ===");
            System.out.println("1. Register New Laptop");
            System.out.println("2. Find Laptop by IMEI");
            System.out.println("3. Fetch All Laptops");
            System.out.println("4. Update Laptop Price");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Brand: ");
                String brand = sc.nextLine();

                System.out.print("Enter Model: ");
                String model = sc.nextLine();

                System.out.print("Enter IMEI No: ");
                long imeiNo = sc.nextLong();
                sc.nextLine();

                System.out.print("Enter Processor: ");
                String processor = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                Laptop laptop = new Laptop(brand, model, imeiNo, processor, price);
                laptopDAO.save(laptop);

                System.out.println("\n Laptop Saved Successfully!");
                System.out.println(laptop);

            } else if (choice == 2) {
                System.out.print("Enter IMEI No: ");
                long imei = sc.nextLong();
                Laptop foundLaptop = laptopDAO.findByImei(imei);
                if (foundLaptop != null) {
                    System.out.println("\n Laptop Found: " + foundLaptop);
                } else {
                    System.out.println("\n No laptop found with this IMEI.");
                }

            } else if (choice == 3) {
                List<Laptop> laptops = laptopDAO.fetchAll();
                System.out.println("\n=== All Laptops ===");
                laptops.forEach(System.out::println);

            } else if (choice == 4) {
                System.out.print("Enter Laptop ID to Update: ");
                int id = sc.nextInt();
                System.out.print("Enter New Price: ");
                double newPrice = sc.nextDouble();

                laptopDAO.updatePrice(id, newPrice);
            } else {
                System.out.println("Invalid choice!");
            }
        };
    }
}
