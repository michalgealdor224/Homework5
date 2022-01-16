public class Product {

    private String name;
    private boolean ifInStock;
    private float price;
    private int discountPercentages;

    public Product (String name,boolean ifInStock,float price,int discountPercentages) {
        this.name= name;
        this.ifInStock = ifInStock;
        this.price=price;
        this.discountPercentages= discountPercentages;
    }

    public int getDiscountPercentages() {
        return discountPercentages;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setIfInStock(boolean ifInStock) {
        this.ifInStock = ifInStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIfInStock() {
        return ifInStock;
    }

    @Override
    public String toString() {
        return name;
    }
}
