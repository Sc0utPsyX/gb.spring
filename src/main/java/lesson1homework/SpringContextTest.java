package lesson1homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class SpringContextTest {
    public static void main(String[] args){
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("lesson1homework")) {
            ProductRepository productRepository = context.getBean(ProductRepository.class);
            System.out.println(productRepository);
            printMenu();
            Scanner sc = new Scanner(System.in);
            Cart cart = context.getBean(Cart.class);
            boolean q = true;
            while (q) {
                switch (sc.nextInt()) {
                    case 1 -> {
                        cart = context.getBean(Cart.class);
                        printMenu();
                    }
                    case 2 -> {
                        System.out.println("Select item");
                        System.out.println(productRepository);
                        int id = sc.nextInt();
                        cart.addToCart(productRepository, id);
                        System.out.println("Successful Added " + productRepository.getById(id).getTitle());
                        printMenu();
                    }
                    case 3 -> {
                        cart.printCart();
                        printMenu();
                    }
                    case 4 -> {
                        cart.printCart();
                        if (cart.deleteFromCart(productRepository, sc.nextInt())) {
                            System.out.println("Deleted");
                        } else {
                            System.out.println("Not Found");
                        }
                        printMenu();
                    }
                    case 5 -> q = false;
                }
            }
        }
    }

    static void printMenu(){
        System.out.println("Do something \n1. Create new cart\n2. Add item to cart\n3. Print Cart\n4. Delete from cart\n5. Quit");
    }

}
