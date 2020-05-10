import java.util.Objects;

public class Car {
    private String model;
    private BigDecimal prize;

    public Car(String model, Integer prize){
        this.model = model;
        this. prize = prize;
    }

    @Override
    public String toString() {
        return "{Car -> " + "model='" + model + "', prize=" + prize + "}\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car) o;
        return (model.equals(car.model) && prize.equals(car.prize));
    }
    @Override
    public int hashCode() {
        return Objects.hash(model, prize);
    }
}
