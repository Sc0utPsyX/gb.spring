package lesson1homework;

public class Product {
    private static int count = 1;
    private int id;
    private String title;
    private long cost;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(id + ". " + title + ", cost: " + cost);
    }

    public Product(String title) {
        this.id = count++;
        this.title = title;
        this.cost = (long) (Math.random() * 100);

    }
}
