package W5_Practice;

import java.util.*;

public class MadeUPInterfaces {

    public static void main(String[] args) {

    // Java List
        List<String> names = new LinkedList<String>();
        names.add("Haris");

        // Java Set
        Set<String> set = new HashSet<String>();
        set.add("Becir");
        set.add("Amila");
        System.out.println("Set: \n" + set);

        // Java Collection

        Map<String, String> translations = new HashMap<>();
        translations.put("FirstKey","FirstValue");
        translations.put("SecondKey","SecondValue");
        // Keys
        Set<String> allKeys = translations.keySet();
        System.out.println("Keys after using keySet(): \n" + allKeys);
        Collection<String> keySet = allKeys;  // bukvalno sluzi samo da prosirimo nas Interface, isto sadrzi kao allKeys tipa Set
        System.out.println("Same thing with Collections, just expanding our interface: \n" + keySet + "\n");

        if (keySet.contains("FirstValue")) {
            System.out.println("It contains FirstValue! ");
        } else
            System.out.println("It only contains keys!");

        System.out.println("Keys: ");
        for (String keys : allKeys) {
            System.out.println(keys);
        }

        // Values
        System.out.println("\n" + "Values: " );
        Collection<String> allValues = translations.values();
        // System.out.println(allValues);

        for (String values : allValues) {
            System.out.println(values);
        }








    }





}
