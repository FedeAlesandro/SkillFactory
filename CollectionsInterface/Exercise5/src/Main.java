import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void deleteRepeatedCars(ArrayList<Car>cars){
        ArrayList<Car>aux = new ArrayList<>();
        while(!cars.isEmpty()){
            Car value = cars.get(cars.size()-1);
            while(cars.contains(value)){
                value = cars.remove(cars.indexOf(value));
                if(!aux.contains(value)){
                    aux.add(value);
                }
            }
        }
        cars.addAll(aux);
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
        deleteRepeatedCars(cars);
        System.out.println(cars);
    }
}
