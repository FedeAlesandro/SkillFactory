import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void removeEvenLength(List<String> strings){
	    List<String>aux = new ArrayList<>(strings);
        for(String string : aux)
            if(string.length() % 2 == 0)
                strings.remove(string);
    }
	
    public static void main(String[] args) {
        List<String>strings = new ArrayList<>();
        strings.add("Federico");
        strings.add("Javier");
        strings.add("Ernesto");
        strings.add("Jazmin");
        strings.add("Jorge");

        removeEvenLength(strings);
        System.out.println(strings);
    }
}
