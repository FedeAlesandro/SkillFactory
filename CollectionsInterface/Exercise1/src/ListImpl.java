import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListImpl {

    private List<Integer> list;

    public ListImpl(){
        this.list = new ArrayList<>();
    }
    public ListImpl(List list){
        this.list = list;
    }

    public void add(Integer number){
        list.add(number);
    }
    public void delete(Integer number){
        while(list.remove(number));
    }
    public int read(int index){
        return list.get(index);
    }
    public List readAll(){
        return list;
    }
    public void print(int index){
        System.out.println(list.get(index));
    }
    public void printAll(){
        System.out.println(list);
    }
    public void printAllForEach(){
        for(Integer number: list){
            System.out.println(number);
        }
    }
    public void printAllFor(){
        for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    public void sort(){
        Collections.sort(list);
    }
    public void reverseSort(){
        Collections.reverse(list);
    }
}
