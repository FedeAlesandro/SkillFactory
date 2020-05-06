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
    }
}
