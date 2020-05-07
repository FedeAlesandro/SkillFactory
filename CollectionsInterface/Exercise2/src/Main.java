import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Marathon marathon = new Marathon(Double.valueOf(42195));
        marathon.add(new Human("Federico"));
        marathon.add(new Dog("Lobito"));
        marathon.add(new Robot("Arturito"));

        marathon.printCompetitorsTime();

    }
}
