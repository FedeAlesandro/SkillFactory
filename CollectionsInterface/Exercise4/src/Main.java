import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void orderAndPrint (List<Integer>list, Integer... numbers){
        list.addAll(Arrays.asList(numbers));
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main(String[] args) {
        orderAndPrint(new ArrayList<Integer>(), 4, 3, 5, 6, 1, 2);
        orderAndPrint(new LinkedList<Integer>(), 4, 3, 5, 6 ,1 ,2);
    }
}
