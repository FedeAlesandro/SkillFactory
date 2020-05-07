import java.util.ArrayList;

public class Main {
	
	public static void removeEvenLenght(ArrayList<String> strings){
        for(int i = 0; i<strings.size(); i++){
            int length = strings.get(i).length();
            if(length % 2 == 0)
                strings.remove(strings.get(i));
        }
    }
	
    public static void main(String[] args) {
        ArrayList<String>strings = new ArrayList<>();
        strings.add("Federico");
        strings.add("Ernesto");
        strings.add("Jazmin");
        strings.add("Jorge");
        strings.add("Javier");
        System.out.println(strings);
        removeEvenLenght(strings);
        System.out.println(strings);
    }
}
