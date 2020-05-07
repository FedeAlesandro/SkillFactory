import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        marathon.add(new Human("Federico"));
        marathon.add(new Dog("Lobito"));
        marathon.add(new Robot("Arturito"));

        System.out.println(marathon.getCompetitors());

    }
}
