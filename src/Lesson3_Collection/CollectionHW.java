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

        Phonebook2 phonebook2 = new Phonebook2();
        phonebook2.addMap(333, "Gavr");
        phonebook2.addMap(111, "Gavr");
        phonebook2.addMap(222, "Hala");
        System.out.println("Maps add " + phonebook2);
        phonebook2.getMap("Gavr");

    }
    // Methods Task 1.1
    public static HashSet<String> listSetMethod(ArrayList<String> list){
        return  new HashSet<String>(list);
    }

    // Methods Task 1.2.1
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
    // Methods Task 1.2.2
    static void countList2 (ArrayList<String> list, ArrayList<String> listUnic){ //var2
        HashMap <String, Integer>  map = new HashMap<>();
        Integer count;
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

    // Methods Task 1.1.2 with Arr String[] words
    private static TreeSet<String> getWords(String[] arr) {
        return new TreeSet<>(Arrays.asList(arr));
    }
    // Methods Task 1.2.3 with Arr String[] words
    private static HashMap<String, Integer> getWordsCount(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}

    // Class Task 2
class Phonebook {
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

class Phonebook2 {
HashMap <Integer, String> telMap = new HashMap<>();

void addMap ( Integer i, String s){
    telMap.put(i, s);
}

void getMap (String s){
    LinkedList<Integer> phone = new LinkedList<>();
    for(Map.Entry<Integer, String> map : telMap.entrySet()){
        if(map.getValue().equals(s))
            phone.add(map.getKey());
    }
    System.out.println("Maps Gavr tel: " + phone);
}

    @Override
    public String toString() {
        return String.format("phoneBook(%s)",telMap);
    }
}



