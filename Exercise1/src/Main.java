import java.util.*;

public class Main {

    public static void main(String[] args) {

        ListImpl list = new ListImpl(new ArrayList());
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(2);

        System.out.println("List[0]: ");
        list.print(0);

        System.out.println("List: ");
        list.printAll();

        list.delete(2);
        System.out.println("List with number 2 deleted, printed with a for: ");
        list.printAllFor();

        int num = list.read(0);
        System.out.println("Number in index 0: ");
        System.out.println(num);

        List list1 = list.readAll();
        System.out.println("list1, copy of list: ");
        System.out.println(list1);

        list.sort();
        System.out.println("List sorted, printed with a for each: ");
        list.printAllForEach();

        list.reverseSort();
        System.out.println("List reverse sorted: ");
        list.printAll();

        SetImpl set = new SetImpl(new HashSet());
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println("Si contiene el valor 4 pasado por parámetro");
        System.out.println(set.ifContains(4));
        System.out.println("Si contiene el valor 5 pasado por parámetro");
        System.out.println(set.ifContains(5));

        System.out.println("Imprime todo el set");
        set.printAll();

        System.out.println("Print de un valor pasado por parámetro");
        set.print(2);

        System.out.println("Valor eliminado del set, impreso cada valor del set con un foreach");
        set.delete(2);
        set.printAllForEach();

        System.out.println("Leo un valor y lo retorno si es que está, sino retorno null");
        int numb = set.read(4);
        System.out.println(numb);

        System.out.println("Leo todo el set y lo retorno");
        Set set1 = set.readAll();
        System.out.println(set1);

        System.out.println("Creo un SetImpl y el set retornado lo paso a TreeSet en el parametro del constructor para poder ordenarlo en orden reverso");
        SetImpl treeSet = new SetImpl(new TreeSet(set1));
        treeSet.printAll();
        treeSet.reverseOrder();
        System.out.println("Ordenado en forma reversa e impreso con un iterator");
        treeSet.printAllIterator();

        MapImpl map = new MapImpl(new HashMap());
        map.add(1, "Fede");
        map.add(2, "Pepe");
        map.add(3, "Edu");

        System.out.println("Todo el mapa impreso");
        map.printAll();

        System.out.println("Elimino el valor con key 2");
        map.delete(2);

        System.out.println("Imprimo el valor con key 3");
        map.print(3);

        System.out.println("Leo el valor que retorna la key 1");
        String value = map.read(1);
        System.out.println(value);

        System.out.println("Retorno todo el mapa e imprimo la copia con un iterator");
        Map map1 = map.readAll();
        map.printAllIterator();

        System.out.println("Imprimo el mapa original con un foreach");
        map.printAllForEach();
    }
}
