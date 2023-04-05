package taskFinal.util;

import java.util.Objects;

public class Product {
    private String name;
    private String size;
    private String color;
    private double  price;

    public Product(String productName, String productSize, String productColor, double productPrice)
    {
        name = productName;
        size = productSize;
        color = productColor;
        price = productPrice;
    }

    public String getName() {return name;}
    public String getSize() {return size;}
    public String getColor() {return color;}
    public double getPrice() {return price;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return  Objects.equals(name, product.name) &&
                Objects.equals(size, product.size) &&
                Objects.equals(color, product.color) &&
                Objects.equals(price, product.price);
    }
}
