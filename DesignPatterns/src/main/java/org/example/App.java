package org.example;

import org.example.enums.BookState;
import org.example.enums.EmployeeCategory;
import org.example.interfaces.ITriangle;
import org.example.models.Administration;
import org.example.models.BlueLCDFactory;
import org.example.models.Book;
import org.example.models.BookAlarm;
import org.example.models.ClientTvColor;
import org.example.models.Employee;
import org.example.models.Library;
import org.example.models.Purchases;
import org.example.models.Stock;
import org.example.models.TriangleCreator;
import org.example.models.YellowPlasmaFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Strategy Pattern
        Employee director = new Employee("Federico", EmployeeCategory.director, 45000d);
        Employee administrative = new Employee("Pepe", EmployeeCategory.administrative, 35000d);
        Employee operator = new Employee("Juan", EmployeeCategory.operator, 25000d);

        director.changeSalary();
        administrative.changeSalary();
        operator.changeSalary();

        System.out.println(director);
        System.out.println(administrative);
        System.out.println(operator);

        //Factory Method
        TriangleCreator triangleCreator = new TriangleCreator();

        ITriangle equilateral = triangleCreator.createTringle(10d, 10d, 10d);
        System.out.println(equilateral);

        ITriangle isosceles = triangleCreator.createTringle(10d, 15d, 15d);
        System.out.println(isosceles);
        
        ITriangle scalene = triangleCreator.createTringle(10d, 15d, 20d);
        System.out.println(scalene);

        //Abstract Factory
        ClientTvColor blueLCD = new ClientTvColor(new BlueLCDFactory());
        blueLCD.createColor();
        blueLCD.createTv();

        ClientTvColor yellowPlasma = new ClientTvColor(new YellowPlasmaFactory());
        yellowPlasma.createColor();
        yellowPlasma.createTv();

        System.out.println(blueLCD);
        System.out.println(yellowPlasma);

        //Observer Pattern
        Book book1 = new Book("El sobrino del mago");
        Book book2 = new Book("Fablehaven");
        Book book3 = new Book("Luces del norte");

        Library library = new Library("Biblioteca Leopoldo Lugones");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.lendBook(book2);
        book2.setBookState(BookState.bad);

        library.receiveBook(book2);
    }
}
