package org.example.client;

import org.example.Entity.Product;
import org.example.dto.ProductDTO;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter 1 if you want to create a product or enter 2 if you want to view all products.");
            System.out.println("Enter 0 if you want to exit the application.");
            int choice = scanner.nextInt();

            if(choice == 1) {
                createProduct(scanner);
            } else if(choice == 2){
                displayAllProducts();
            }else{
                return;
            }
        }
    }

    public static void createProduct(Scanner scanner) throws Exception {
        System.out.println("Please enter the name of the product: ");
        String name = scanner.next();

        System.out.println("Please enter the price of the product: ");
        Double price = scanner.nextDouble();

        System.out.println("Please enter the quantity of the product: ");
        Integer quantity = scanner.nextInt();

        System.out.println("Please enter the id of the category of the product: ");
        Long categoryId = scanner.nextLong();

        System.out.println("Please enter the description of the product: ");
        String description = scanner.next();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setPrice(price);
        productDTO.setQuantity(quantity);
        productDTO.setCategoryId(categoryId);
        productDTO.setDescription(description);

        ProductService productService = new ProductService();
        productService.createProduct(productDTO);
    }


    private static void displayAllProducts() {
        ProductService productService = new ProductService();
        List<Product> products = productService.getAllProducts();

        for (Product product : products) {
            System.out.println(product);
        }

    }
}
