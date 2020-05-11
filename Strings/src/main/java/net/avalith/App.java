package net.avalith;

public class App
{
    public static void main( String[] args )
    {
        StringsMethods stringsMethods = new StringsMethods();
        System.out.println(stringsMethods.isPalindrome("Arriba la birra"));
        System.out.println(stringsMethods.romanNumberToInteger("XXI"));
        System.out.println(stringsMethods.reorderWords("Aguante Boca Juniors papá"));
        System.out.println(stringsMethods.countDiferentCaracters("Soy Independiente, aunque no gano la libertadores\n" + "desde 1985, sigo siendo el máximo campeón con 7 copas"));
    }
}
