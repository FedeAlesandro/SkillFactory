package org.example;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        StringsMethods stringsMethods = new StringsMethods();

        // 1) Escribir un método removeEvenLength() que reciba un ArrayList de String y elimine todos los String de longitud par.
        List<String> strings = new ArrayList<>();
        strings.add("Federico");
        strings.add("Javier");
        strings.add("Ernesto");
        strings.add("Jazmin");
        strings.add("Jorge");
        strings = stringsMethods.removeEvenLength(strings);
        System.out.println(strings);

        // 2) Escribir un método, que dado un String cuente diferentes tipos de caracteres. Deberá imprimir el número de letras, dígitos y espacios en blanco de la cadena.
        stringsMethods.countDifferentCharacters("Soy Independiente, aunque no gano la libertadores\n" + "desde 1985, sigo siendo el máximo campeón con 7 copas");

        // 3)Realizar un método, el cual reciba un String y realice el cifrado Caesar. Se debe cambiar cada letra por la siguiente.
        System.out.println(stringsMethods.caesarCipher("adegnzxi"));

        // 4) Escribir un método, que dado un String reordena las palabras de atrás hacia adelante
        System.out.println(stringsMethods.reorderWords("Aguante Boca Juniors papá"));
    }
}
