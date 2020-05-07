package net.avalith;

public class App
{
    public static void main( String[] args )
    {
       /* Stack<String>stack = new Stack<>();
        stack.push("Hello");
        stack.push("Yes");
        stack.push("No");
        stack.push("Bye");
        System.out.println(stack); */
        System.out.println(StringsMethods.isPalindrome("Arriba la birra"));
        System.out.println(StringsMethods.romanNumberToInteger("XXI"));
        System.out.println(StringsMethods.reorderWords("Aguante Boca Juniors papá"));
    }
}
