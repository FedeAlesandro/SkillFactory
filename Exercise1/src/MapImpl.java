import java.util.*;

public class MapImpl {

    private Map<Integer, String> map;

    public MapImpl(Map map){
        this.map = map;
    }
    public  MapImpl(){
        this.map = new HashMap<>();
    }

    public void add(Integer key, String value){
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

    @Override
    public String toString() {
        return this.map.toString();
    }
}
