package transaction;

public class Product {
    public int price;
    public int id;
    public String name;
    public String companyName;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
