import java.util.*;

public class Homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] arrStr = str.split(" ");

        Map<String, Integer> stringMap = new HashMap<>();

        for (String s : arrStr) {
            if (stringMap.containsKey(s)) {
                stringMap.put(s, stringMap.get(s) + 1);
            } else {
                stringMap.put(s, 1);
            }
            System.out.println(s);
        }

        List<Map.Entry<String, Integer>> stringList = new LinkedList<>(stringMap.entrySet());

        stringList.sort(Map.Entry.comparingByValue());
        System.out.println(stringList);

        System.out.println(stringList.get(stringList.size() - 1).getKey() + " " + stringList.get(stringList.size() - 1).getValue());
    }
}
