package org.example;

import org.example.connection.MyConnection;
import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.math.BigDecimal;

public class App
{
    public static void main( String[] args )
    {
        ProductRepository productRepository = new ProductRepository();

        //INSERTS
        Product product1 = new Product.Builder()
                .name("Chocolate")
                .price(BigDecimal.valueOf(50))
                .brand("Milka")
                .unit("300 gr")
                .quantity(15)
                .discount(0d)
                .build();
        Product product2 = new Product.Builder()
                .name("Banana")
                .price(BigDecimal.valueOf(50))
                .brand("SabroStar")
                .unit("1kg")
                .quantity(15)
                .discount(0.1d)
                .build();
        Product product3 = new Product.Builder()
                .name("Fernet")
                .price(BigDecimal.valueOf(50))
                .brand("Branca")
                .unit("750 cc")
                .quantity(100)
                .discount(0.5d)
                .build();
        productRepository.add(product1);
        productRepository.add(product2);
        productRepository.add(product3);
        // UPDATE
        Product product4 = new Product.Builder()
                .name("Hamburguesa")
                .price(BigDecimal.valueOf(200))
                .brand("Paty")
                .unit("320 gr")
                .quantity(40)
                .discount(0.4d)
                .build();
        productRepository.update(product4, 1);
        // DELETE
        productRepository.delete(3);
        // GET ALL
        System.out.println(productRepository.getAll());
        // GET BY ID
        System.out.println(productRepository.getById(2));

        MyConnection.close();
    }
}
