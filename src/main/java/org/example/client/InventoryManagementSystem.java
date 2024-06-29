package org.example.client;

import org.example.dto.ProductDTO;
import org.example.service.ProductService;

import java.util.Scanner;

public class InventoryManagementSystem {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createProduct(scanner);


    }

    public static void createProduct(Scanner scanner){
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
}
