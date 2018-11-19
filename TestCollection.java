import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args){
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Madison");
        collection1.add("Atlanta");
        System.out.println(collection1);
        System.out.println("\nIs Dallas in collection1?");
        System.out.println(collection1.contains("Dallas"));
        System.out.println("\nIs Atlanta in collection1?");
        System.out.println(collection1.contains("Atlanta"));
        collection1.remove("Atlanta");
        System.out.println("\nIs Atlanta in collection1?");
        System.out.println(collection1.contains("Atlanta"));
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Atlanta");
        collection2.add("New York");
        System.out.println("cities in collection2:");
        System.out.println(collection2);
        ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
        c1.addAll(collection2);
        System.out.println(c1);
        System.out.println();

        c1 = (ArrayList<String>)(collection1.clone());
        c1.retainAll(collection2);
        System.out.println(c1);

        c1 = (ArrayList<String>)(collection1.clone());
        c1.removeAll(collection2);
        System.out.println(c1);



    }
}
