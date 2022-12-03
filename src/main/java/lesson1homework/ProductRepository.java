package lesson1homework;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ProductRepository {


    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product("Bread"));
        productList.add(new Product("Milk"));
        productList.add(new Product("Banana"));
        productList.add(new Product("Apple"));
        productList.add(new Product("Chocolate"));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product list: \n");
        for (Product product: productList) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    public Product getById(int id){
        return productList.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
    }
}
