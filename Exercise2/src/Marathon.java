import java.util.ArrayList;
import java.util.List;

public class Marathon <T extends ISprintable>{
    private Double distance;
    private List <T> competitors; //Uso List porque con TreeSet tenia que comparar y en este caso es innecesario, iba a terminar recorriendo todos los valores igual

    public Marathon(Double distance) {
        this.distance = distance;
        this.competitors = new ArrayList<>();
    }

    private Double getDistance(){
        return this.distance;
    }
    public void add(T competitor){
        competitors.add(competitor);
    }
    public void printCompetitorsTime(){
        for(T competitor : competitors){
            Double time = competitor.run(this.getDistance());
            time = Math.round(time * 100.00)/100.00;
            System.out.println("Competitor: " + competitor.toString() + ". Time realized: " + time);
        }
    }
    @Override
    public String toString() {
        return "Competitors: " + competitors;
    }
}
