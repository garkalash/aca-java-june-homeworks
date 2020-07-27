import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Homework2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] arrStr = str.split(" ");

        Set<String> stringSet = new HashSet<>();

        for (String s : arrStr) {
            stringSet.add(s);
        }

        System.out.println(stringSet);
    }
}
