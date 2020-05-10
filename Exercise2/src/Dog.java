public class Dog implements ISprintable{

    private String name;
    private double speed;

    public Dog(String name) {
        this.name = name;
        this.speed = Math.random()*41+20;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
    @Override
    public Double run(Double distance) {
        return distance/speed;
    }
}
