package org.example.model;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String brand;
    private String unit;
    private Integer quantity;
    private Double discount;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getUnit() {
        return unit;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getDiscount() {
        return discount;
    }

    public static class Builder{
        private String name;
        private BigDecimal price;
        private String brand;
        private String unit;
        private Integer quantity;
        private Double discount;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder price(BigDecimal price){
            this.price = price;
            return this;
        }
        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }
        public Builder unit(String unit){
            this.unit = unit;
            return this;
        }
        public Builder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder discount(Double discount){
            this.discount = discount;
            return this;
        }
        public Product build(){
            return new Product(this);
        }
    }
    private Product (Builder builder){
        this.name=builder.name;
        this.price=builder.price;
        this.brand=builder.brand;
        this.unit=builder.unit;
        this.quantity=builder.quantity;
        this.discount=builder.discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", unit=" + unit + '\'' +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
