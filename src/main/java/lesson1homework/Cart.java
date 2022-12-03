package lesson1homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@Scope("prototype") // 4 задание, чтобы создавалась новая корзина
public class Cart {
    private ArrayList<Product> currentCart;

    @Autowired
    public Cart() {
    }

    public ArrayList<Product> getCurrentCart() {
        return currentCart;
    }

    @PostConstruct
    public void init(){
        currentCart = new ArrayList<>();
    }

    public void addToCart(ProductRepository pr, int id){
        currentCart.add(pr.getById(id));
    }

    public boolean deleteFromCart(ProductRepository pr, int id){
        return currentCart.remove(pr.getById(id));
    }

    public void printCart(){
        System.out.printf("Current Cart: \n" + this + "%n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product: currentCart) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}
