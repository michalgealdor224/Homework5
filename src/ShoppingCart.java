import java.util.Date;

public class ShoppingCart  {
    public static final int LENGTH_OF_ARRAY= 0;


    Product [] products= new Product[LENGTH_OF_ARRAY];
    private Product product;
    private int amountOfProduct;
    private float price;
    private Date date;


    public Product[] getProducts() {
        return products;
    }
    public ShoppingCart (Product product, int amountOfProduct,float price) {
        this.product= product;
        this.amountOfProduct= amountOfProduct;
        this.price= price;
    }

    @Override
    public String toString() {
        return  "\n"+
                "product:" +" "+product + "\n" +
                 "amount:"+" "+amountOfProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }



}
