package org.example.repository;

import org.example.connection.MyConnection;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDProduct {

    private Connection conn;

    public CRUDProduct(){
        this.conn = MyConnection.getConnection();
    }
    public Boolean addProduct(Product product){
        Boolean executeBoolean = false;
        try {
            String query = "insert into products(name, price, brand, unit, quantity, discount) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getUnit());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setDouble(6, product.getDiscount());
            executeBoolean = preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeBoolean;
    }
    public Integer updateProduct(Product product, Integer idProduct){
        try {
            String query = "update products set name = ?, price = ?, brand = ?, unit = ?, quantity = ?, discount = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getUnit());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setDouble(6, product.getDiscount());
            preparedStatement.setInt(7, idProduct);
            Integer rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Boolean deleteProduct(Integer idProduct){
        Boolean executeBoolean = false;
        try {
            String query = "delete from products where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idProduct);
            executeBoolean = preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeBoolean;
    }
    public List<Product> getProducts(){
        List<Product>products = new ArrayList<>();
        try {
            String query = "select * from products";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                products.add(
                        new Product.Builder()
                                .name(resultSet.getString("name"))
                                .price(resultSet.getBigDecimal("price"))
                                .brand(resultSet.getString("brand"))
                                .unit(resultSet.getString("unit"))
                                .quantity(resultSet.getInt("quantity"))
                                .discount(resultSet.getDouble("discount"))
                                .build()
                );
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductById(Integer idProduct){
        Product product = null;
        try {
            String query = "select * from products where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product = new Product.Builder()
                    .name(resultSet.getString("name"))
                    .price(resultSet.getBigDecimal("price"))
                    .brand(resultSet.getString("brand"))
                    .unit(resultSet.getString("unit"))
                    .quantity(resultSet.getInt("quantity"))
                    .discount(resultSet.getDouble("discount"))
                    .build();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
