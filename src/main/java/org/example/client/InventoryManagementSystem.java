package org.example.client;

import org.example.Entity.Category;
import org.example.Entity.Product;
import org.example.dto.CategoryDTO;
import org.example.dto.ProductDTO;
import org.example.service.CategoryService;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option from the menu: ");
            System.out.println("1 - Add product");
            System.out.println("2 - See all products in the inventory");
            System.out.println("3 - Delete product");
            System.out.println("4 - Find product by id");
            System.out.println("5 - Add category");
            System.out.println("6 - See all categories");
            System.out.println("Enter 0 if you want to exit the application.");
            int choice = scanner.nextInt();

            switch(choice){
                case 0:
                    return;
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    findProductById(scanner);
                    break;
                case 5:
                    createCategory(scanner);
                    break;
                case 6:
                    displayAllCategories();
                    break;
            }
        }
    }

    private static void createProduct(Scanner scanner) throws Exception {
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

    private static void deleteProduct(Scanner scanner) throws Exception {
        System.out.println("Please enter the id of the product: ");
        Long id = scanner.nextLong();

        ProductService productService = new ProductService();
        productService.deleteProduct(id);
    }

    private static Product findProductById(Scanner scanner) throws Exception {
        System.out.println("Please enter the id of the product: ");
        Long id = scanner.nextLong();

        ProductService productService = new ProductService();
        Product foundProduct = productService.findById(id);
        System.out.println(foundProduct);
        return foundProduct;
    }

    private static void createCategory(Scanner scanner) throws Exception {
        System.out.println("Please enter the name of the category: ");
        String name = scanner.next();

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(name);

        CategoryService categoryService = new CategoryService();
        categoryService.createCategory(categoryDTO);
    }

    private static void displayAllCategories() {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.getAllCategories();

        for (Category category : categories) {
            System.out.println(category);
        }
    }
}
