public class Human implements  ISprintable{

    private String name;
    private Double speed;

    public Human(String name) {
        this.name = name;
        this.speed = Math.random()*30+15;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public Double run(Double distance) {
        return distance/speed;
    }
}
