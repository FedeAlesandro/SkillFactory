import java.util.*;

public class SetImpl {

    private Set<Integer> set;

    public SetImpl(){
        this.set = new HashSet<>();
    }
    public SetImpl(Set set){
        this.set = set;
    }

    public void add(Integer number){
        set.add(number);
    }
    public void delete(Integer number){
        set.remove(number);
    }
    public boolean ifContains (Integer number){
        return set.contains(number);
    }
    public Integer read(Integer number){
        if (set.contains(number))
            return number;
        else
            return null;
    }
    public Set readAll(){
        return set;
    }
    public void print(Integer number){
        if(set.contains(number)){
            System.out.println(number);
        }else
            System.out.println("El valor pasado por parámetro no está");
    }
    public void printAll(){
        System.out.println(set);
    }
    public void printAllIterator(){
        Iterator <Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public void printAllForEach(){
        for(Integer number : set){
            System.out.println(number);
        }
    }
    public void reverseOrder(){
        if(set instanceof TreeSet){
            set=((TreeSet) set).descendingSet();
        }
    }

    @Override
    public String toString() {
        return this.set.toString();
    }
}
