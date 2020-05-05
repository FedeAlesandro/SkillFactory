import java.util.*;

public class MapImpl {

    private Map<Integer, String> map;

    public MapImpl(Map map){
        this.map = map;
    }
    public  MapImpl(){
        this.map = new HashMap<>();
    }


    public void add(Integer key, String value){ //No estoy seguro si se refiere a add con el obtener
        map.put(key, value);
    }
    public void delete(Integer key){
        map.remove(key);
    }
    public String read(Integer key){
        return map.get(key);
    }
    public Map readAll(){
        return map;
    }
    public void print(Integer key){
        System.out.println(map.get(key));
    }
    public void printAll(){
        System.out.println(map);
    }
    public void printAllIterator(){
        Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<Integer, String> entry = entries.next();
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
    public void printAllForEach(){
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
    public void reverseOrder(Set set){
        if(set instanceof TreeSet){
            set=((TreeSet) set).descendingSet();
        }
    }
    /* realizar las operaciones básicas en cada una (obtener, eliminar, leer e imprimir, iterar sobre la colección  e imprimir todos sus
        elementos uno a uno (iterar de 2 formas diferentes al menos)). También ordenar e invertir el orden de los elementos en la/s colección/es que sea posible.
     */
}
