package org.example;

import org.example.connection.MyConnection;
import org.example.model.Product;
import org.example.repository.CRUDProduct;

import java.math.BigDecimal;

public class App
{
    public static void main( String[] args )
    {
        CRUDProduct crud = new CRUDProduct();

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
        crud.addProduct(product1);
        crud.addProduct(product2);
        crud.addProduct(product3);
        // UPDATE
        Product product4 = new Product.Builder()
                .name("Hamburguesa")
                .price(BigDecimal.valueOf(200))
                .brand("Paty")
                .unit("320 gr")
                .quantity(40)
                .discount(0.4d)
                .build();
        crud.updateProduct(product4, 1);
        // DELETE
        crud.deleteProduct(3);
        // GET ALL
        System.out.println(crud.getProducts());
        // GET BY ID
        System.out.println(crud.getProductById(2));

        MyConnection.close();
    }
}
