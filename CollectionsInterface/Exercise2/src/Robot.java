public class Robot implements ISprintable{

    private String name;
    private double speed;

    public Robot(String name) {
        this.name = name;
        this.speed = Math.random()*70+5;
    }

    @Override
    public Double run(Double distance) {
        return distance/speed;
    }
}
