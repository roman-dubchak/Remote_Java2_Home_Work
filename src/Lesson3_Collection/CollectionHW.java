package Lesson3_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionHW {
    public static void main(String[] args) {
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

        HashMap <String, Integer>  map = new HashMap<>();
        map.put("Tany", 8904);
        map.put("Kany", 8999);
        map.put("Tany", 8888);
        System.out.println(map);

    }
    static void countList (ArrayList<String> list, ArrayList<String> listUnic){
        int count;
        for (int i = 0; i <listUnic.size(); i++) {
            count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (listUnic.get(i).equals(list.get(j))) count++;
            }
            System.out.println("The word " + listUnic.get(i) + " : " + count + " times");
        }
    }

//    static String countList2 (ArrayList<String> list, ArrayList<String> listUnic){
//        int count;
//        String s = "";
//        for (int i = 0; i <listUnic.size(); i++) {
//            count = 0;
//            for (int j = 0; j < list.size(); j++) {
//                if (listUnic.get(i).equals(list.get(j)))
//                    count++;
//            }
//            return ("The word " + listUnic.get(i) + " : " + count + " times");
//        }
//        return
//    }
}

class Phonebook { //} extends HashMap <String, Integer>{
    String name;
    Integer number;
    ArrayList <String> contacts = new ArrayList<>(Arrays.asList("Katy", "Natasha"));
    ArrayList <Integer> telephonNum = new ArrayList<>(Arrays.asList(9999, 88888));

    HashMap <String, Integer> phonebookMap = new HashMap<>();

    Phonebook(String name, Integer number){
        this.name = name;
        this.number = number;
    }


//    @Override
//    public Integer get(Object key) {
//        return super.get(key);
//    }
//
//    @Override
//    public Integer put(String key, Integer value) {
//        return super.put(key, value);
//    }
}