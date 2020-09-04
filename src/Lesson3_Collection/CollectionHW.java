package Lesson3_Collection;

import java.util.*;

public class CollectionHW {
    public static void main(String[] args) {
        // Task 1
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Table");
        list.add("Apple");
        list.add("Car");
        list.add("Window");
        list.add("Apple");
        list.add("Window");
        list.add("England");
        list.add("TicTacToe");
        list.add("Things");
        list.add("YouTube");
        list.add("Tea");
        System.out.println(list); // to check

        HashSet<String> listSet = new HashSet<>(list);
        System.out.println(listSet);
        ArrayList<String> listUnic = new ArrayList<>(listSet);
        System.out.println(listUnic);

        countList(list,listUnic);
        countList2(list,listUnic);

        // Task 2
        LinkedList<String> contacts = new LinkedList<>(Arrays.asList("Krilov", "Plotnikov", "Krilov")); // to check
        LinkedList <Integer> telephonNum = new LinkedList<>(Arrays.asList(999, 888, 777)); // to check
        System.out.println(contacts + " : " + telephonNum ); // to check

        Phonebook phonebook = new Phonebook();
        phonebook.add("Rakov", 444);
        System.out.println(phonebook.contacts + " : " + phonebook.telephonNum);

        phonebook.get("Krilov");
    }

    // Methods Task 1
    static void countList (ArrayList<String> list, ArrayList<String> listUnic){ //var1
        int count;
        for (int i = 0; i <listUnic.size(); i++) {
            count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (listUnic.get(i).equals(list.get(j))) count++;
            }
            System.out.println("The word " + listUnic.get(i) + " : " + count + " times"); // console output
        }
    }

    static void countList2 (ArrayList<String> list, ArrayList<String> listUnic){ //var2
        HashMap <String, Integer>  map = new HashMap<>();
        Integer count;
        String s = "";
        for (int i = 0; i <listUnic.size(); i++) {
            count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (listUnic.get(i).equals(list.get(j)))
                    count++;
            }
            map.put(listUnic.get(i),count);
        }
        System.out.println("Method void" + map); // for check
    }
}

    // Class Task 2
class Phonebook {
    String name;
    Integer number;
    LinkedList<String> contacts = new LinkedList<>(Arrays.asList("Krilov", "Plotnikov", "Krilov"));
    LinkedList <Integer> telephonNum = new LinkedList<>(Arrays.asList(999, 888, 777));

    void add (String s, Integer i){
        contacts.add(s);
        telephonNum.add(i);
    }

    void get (String s){
        LinkedList<Integer> phone = new LinkedList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (s.equals(contacts.get(i)))
                phone.add(telephonNum.get(i));
        }
        System.out.println("Krilov's phone number" + phone); // to check
    }
}