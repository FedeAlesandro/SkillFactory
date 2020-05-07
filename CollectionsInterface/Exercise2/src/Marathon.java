import java.util.TreeSet;

public class Marathon <T extends ISprintable>{
    TreeSet <T> competitors;

    public Marathon() {
        this.competitors = new TreeSet<>();
    }

    public void add(T competitor){
        competitors.add(competitor);
    }
    public TreeSet getCompetitors(){
        return competitors;
    }

    @Override
    public String toString() {
        return "Competitors: " + competitors;
    }
}
