import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void ex1() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);
    }

    public static Integer ex2() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        return map.size();
    }

    public static Map<Number, String> ex3() {
        Map<Number, String> map = new HashMap<>();
        Map<Number, String> dstMap = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        dstMap.putAll(map);

        return dstMap;
    }

    public static void ex4() {
        Map<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        map.clear();

        System.out.println(map);
    }

    public static void ex5() {
        Map<Number, String> map = new HashMap<>();
        System.out.println(map);
        System.out.println("Is empty? : " + map.isEmpty());

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);
        System.out.println("Is empty? : " + map.isEmpty());
    }

    public static void ex6() {
        HashMap<Number, String> map = new HashMap<>();
        Map<Number, String> dstMap = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        dstMap = (Map<Number, String>) map.clone();
        System.out.println("Before change");
        System.out.println("Old map " + map);
        System.out.println("New map " + dstMap);
        dstMap.put(1, "Մեկ");
        System.out.println("After change");
        System.out.println("Old map " + map);
        System.out.println("New map " + dstMap);
    }

    public static void ex7() {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);
        System.out.println("Is map contains key 1?\n" + map.containsKey(1));
        System.out.println("Is map contains key 5?\n" + map.containsKey(5));
    }

    public static void ex8() {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);
        System.out.println("Is map contains value \"One\"?\n" + map.containsValue("One"));
        System.out.println("Is map contains value \"Five\"?\n" + map.containsValue("Five"));
    }

    public static void ex9() {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Set set = map.entrySet();
        System.out.println(set);
    }

    public static String ex10(Integer key) {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        return map.get(key);
    }

    public static void ex11() {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Set set = map.keySet();
        System.out.println(set);
    }

    public static void ex12() {
        HashMap<Number, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map.values());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer caseNumber;
        do {
            System.out.println("Enter exercise number");
            caseNumber = in.nextInt();
            switch (caseNumber) {
                case 1:
                    ex1();
                    break;
                case 2:
                    System.out.println(ex2());
                    break;
                case 3:
                    System.out.println(ex3());
                    break;
                case 4:
                    ex4();
                    break;
                case 5:
                    ex5();
                    break;
                case 6:
                    ex6();
                    break;
                case 7:
                    ex7();
                    break;
                case 8:
                    ex8();
                    break;
                case 9:
                    ex9();
                    break;
                case 10:
                    System.out.println(ex10(2));
                    break;
                case 11:
                    ex11();
                    break;
                case 12:
                    ex12();
                    break;
                default:
                    caseNumber = 0;
                    break;
            }
        } while (caseNumber != 0);
    }
}
