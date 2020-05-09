import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Car> deleteRepeatedCars(ArrayList<Car>cars){
        List<Car>aux = new ArrayList<>();
        for (Car car: cars) {
            if(!aux.contains(car)){
                aux.add(car);
            }
        }
		return aux;
    }
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Corsa", 60000));
        cars.add(new Car("Bugatti", 300000));
        cars.add(new Car("Siena", 55000));
        cars.add(new Car("Corsa", 60000));
        cars.add(new Car("Corsa", 60000));
        cars.add(new Car("Bugatti", 300000));
        cars.add(new Car("Bugatti", 300000));
        cars.add(new Car("Bugatti", 300000));
        cars.add(new Car("Corsa", 60000));
        cars.add(new Car("Corsa", 60000));
        cars.add(new Car("306", 70000));
        cars.add(new Car("Fiesta", 50000));

        System.out.println(cars);
		cars = deleteRepeatedCars(cars);
        System.out.println(cars);
);
    }
}
