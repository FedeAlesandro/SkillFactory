package org.example;

<<<<<<< HEAD
import org.example.exercise2.ClassSupplier;
import org.example.exercise4.IStringFunction;
import org.example.exercise6.IHelloWorld;
import org.example.exercise6.IPrint;
import org.example.exercise6.IPrintCelsiusToFaren;
import org.example.exercise6.ISum;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

=======
>>>>>>> master
/**
 * Hello world!
 *
 */
public class App 
{
<<<<<<< HEAD
    public static String helloWorld(IHelloWorld helloWorld){
        return helloWorld.returnVeryOriginalMessage();
    }
    public static void print(IPrint print){
        print.print();
    }
    public static void printCelToFar(IPrintCelsiusToFaren printCelToFar, Integer celsius){
        printCelToFar.print(celsius);
    }
    public static Integer sum(ISum sum, Integer num1, Integer num2){
        return sum.sum(num1, num2);
    }

    public static void main( String[] args )
    {
        /*1) Crear un Function que devuelva el módulo a elección de un numero entero.*/
        Function<Integer, String> function = number -> number.toString();
        System.out.println(function.apply(4));

        /*2) Utilizar una interfaz Supplier en un método de una clase que tenga como atributo una fecha
        (el Supplier devuelve un timestamp actual). Puede hacerse pasando el objeto Supplier o pasando un lambda a un método*/

        ClassSupplier classSupplier = new ClassSupplier();
        System.out.println(classSupplier.getDate());

        /*3) Utilizar una interfaz Bifunction la cual reciba 2 strings y retorne un entero con los largos de ambos
        strings sumados.*/
        BiFunction<String, String, Integer> sumStrings = (string1, string2) -> string1.length() + string2.length();
        System.out.println(sumStrings.apply("hola", "chau"));

        /*4) Buscar que interfaz se usaria para tirar una excepcion cuando se recibe un String y su largo no es mayor a 1,
            sino, devolver el largo del String */
        IStringFunction<String, Integer> validate = string -> {
            //Esto de adentro modularizarlo en otra funcion
            if(string.length()<1)
                throw new Exception("No puede ingresar strings vacios");
            else
                return string.length();
        };
        try {
            System.out.println(validate.apply("Hola"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*5) Recorrer un HashMap<Integer,String> utilizando un Biconsumer e imprimir sus keys y values , de a 1 entrada
             por vez solo si el largo del value de esa entrada (string) es mayor a 10. Sino imprimir alguna otra cosa*/
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Aguante Boquita");
        map.put(1, "Hola");
        map.put(2, "Hola Ernesto");
        map.forEach((k,v) -> {
            //Esto de adentro modularizarlo en otra funcion
            if(v.length()>10)
                System.out.println("Key: " + k + ", value: " + v);
        });
        /*6) Crear interfaces funcionales propias(que reciban valores o no, que devuelvan algo o no), luego
            instanciarlas en una variable y ejecutar sus métodos.*/

        ISum sumLambda = (number1, number2) -> number1+number2;
        System.out.println(sumLambda.sum(1, 2));

        IPrint print = ()->System.out.println("Goodbye world :(");

        IPrintCelsiusToFaren printCelsiusToFaren = (celsius) -> {
            System.out.println("C° = " + celsius + ", F° = " + ((celsius*9/5)+32));
        };
        printCelsiusToFaren.print(0);

        IHelloWorld hello = () -> "Hello world!";
        System.out.println(hello.returnVeryOriginalMessage());

        /*7) Escribir métodos que reciban las interfaces creadas en el punto anterior y usar lambdas para pasarlas
            como argumento */
        System.out.println(helloWorld(()->"Hello world!"));
        print(()-> System.out.println("Goodbye world!"));
        printCelToFar(celsius -> System.out.println("C° = " + celsius + ", F° = " + ((celsius*9/5)+32)), 30);
        System.out.println(sum((num1, num2) -> num1+num2, 4, 6));
=======
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
>>>>>>> master
    }
}
