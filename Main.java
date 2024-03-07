import gd_collections.GbList;
import gd_collections.lists.GbArrayList;
import gd_collections.lists.GbLinkedList;

public class Main {
    public static void main(String[] args) {
        GbList<Integer> list = new GbArrayList<>();
        GbLinkedList<Integer> list2 = new GbLinkedList<>();
       
        // list.add(5);
        // list.add(8);
        // list.add(10);
        // list.get(1);
        // System.out.println(list.get(0));

        list2.add(1);
        list2.add(5);
        list2.add(8);
        list2.remove(8);
        list2.removeByIndex(0);
     
        System.out.println(list2);

    }
}
