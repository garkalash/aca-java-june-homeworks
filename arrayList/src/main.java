import exercises.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNumber;
        do {
            System.out.println("Please enter exercise number(1-22) or any key to close");
            caseNumber = in.nextInt();

            switch (caseNumber) {
                case 1:
                    Exercise1 ex1 = new Exercise1();
                    ex1.setColor("Blue");
                    ex1.setColor("Red");
                    ex1.print();
                    break;

                case 2:
                    Exercise2 ex2 = new Exercise2();
                    ex2.setColor("Blue");
                    ex2.setColor("Red");
                    ex2.print();
                    break;

                case 3:
                    Exercise3<String> ex3 = new Exercise3();
                    ex3.pushFront("Blue");
                    ex3.pushFront("Red");
                    ex3.print();
                    ex3.pushFront("Yellow");
                    ex3.print();
                    break;

                case 4:
                    Exercise4<String> ex4 = new Exercise4();
                    ex4.pushFront("Blue");
                    ex4.pushFront("Red");
                    ex4.pushFront("Yellow");
                    ex4.print();
                    ex4.popByIndex(1);
                    ex4.popByIndex(8);
                    ex4.print();
                    break;

                case 5:
                    Exercise5<String> ex5 = new Exercise5();
                    ex5.pushFront("Blue");
                    ex5.pushFront("Red");
                    ex5.pushFront("Yellow");
                    ex5.print();
                    ex5.updateListElement("Red", "Green");
                    ex5.print();
                    break;

                case 6:
                    Exercise6<String> ex6 = new Exercise6();
                    ex6.pushFront("Blue");
                    ex6.pushFront("Red");
                    ex6.pushFront("Yellow");
                    ex6.pushFront("Pink");
                    ex6.print();
                    ex6.popThirdElement();
                    ex6.print();
                    break;

                case 7:
                    Exercise7<String> ex7 = new Exercise7();
                    ex7.pushFront("Blue");
                    ex7.pushFront("Red");
                    ex7.pushFront("Yellow");
                    ex7.pushFront("Pink");
                    ex7.print();
                    System.out.printf("Is %s exist?\n%b\n", "Red", ex7.find("Red"));
                    System.out.printf("Is %s exist?\n%b\n", "Black", ex7.find("Black"));
                    break;

                case 8:
                    Exercise8 ex8 = new Exercise8();
                    ex8.pushFront(2);
                    ex8.pushFront(1);
                    ex8.pushFront(5);
                    ex8.pushFront(4);
                    ex8.print();
                    ex8.sortList();
                    ex8.print();
                    break;

                case 9:
                    Exercise9 ex9 = new Exercise9();
                    ex9.pushFront(2);
                    ex9.pushFront(1);
                    ex9.pushFront(5);
                    ex9.pushFront(4);
                    ex9.print();
                    ArrayList<Integer> copiedList = (ArrayList<Integer>) ex9.copy();
                    System.out.println(copiedList);
                    break;

                case 10:
                    Exercise10 ex10 = new Exercise10();
                    ex10.pushFront(2);
                    ex10.pushFront(1);
                    ex10.pushFront(5);
                    ex10.pushFront(4);
                    ex10.print();
                    ex10.shuffle();
                    ex10.print();
                    break;

                case 11:
                    Exercise11 ex11 = new Exercise11();
                    ex11.pushFront(2);
                    ex11.pushFront(1);
                    ex11.pushFront(5);
                    ex11.pushFront(4);
                    ex11.print();
                    ex11.reverseList();
                    ex11.print();
                    break;

                case 12:
                    Exercise12<Number> ex12 = new Exercise12();
                    ex12.pushFront(2);
                    ex12.pushFront(1);
                    ex12.pushFront(5);
                    ex12.pushFront(4);
                    ex12.print();
                    List<Number> dst = new ArrayList<>();
                    dst = ex12.subList(2);
                    System.out.println(dst);
                    break;

                case 13:
                    Exercise13<Number> ex13 = new Exercise13();
                    ex13.pushFront(2);
                    ex13.pushFront(1);
                    ex13.pushFront(5);
                    ex13.pushFront(4);
                    ex13.print();
                    List<Number> dst1 = new ArrayList<>();
                    dst1.add(4);
                    dst1.add(5);
                    dst1.add(1);
                    dst1.add(2);
                    System.out.println(dst1);
                    System.out.println(ex13.compareList(dst1));
                    dst1.add(3);
                    ex13.print();
                    System.out.println(dst1);
                    System.out.println(ex13.compareList(dst1));
                    break;

                case 14:
                    Exercise14<Number> ex14 = new Exercise14();
                    ex14.pushFront(2);
                    ex14.pushFront(1);
                    ex14.pushFront(5);
                    ex14.pushFront(4);
                    ex14.print();
                    ex14.swapListElements(1, 3);
                    ex14.print();
                    break;

                case 15:
                    Exercise15<Number> ex15 = new Exercise15();
                    ex15.pushFront(2);
                    ex15.pushFront(1);
                    ex15.pushFront(5);
                    ex15.pushFront(4);
                    ex15.print();
                    List<Number> lst = new ArrayList<>();
                    lst.add(9);
                    lst.add(12);
                    lst.add(1);
                    lst.add(20);
                    ex15.joinLists(lst);
                    ex15.print();
                    break;
                case 16:
                    Exercise16<Integer> ex16 = new Exercise16();
                    ex16.pushFront(12);
                    ex16.pushFront(11);
                    ex16.pushFront(15);
                    ex16.pushFront(14);
                    ex16.print();
                    List<Number> lst1 = (List<Number>) ex16.cloneList();
                    System.out.println(lst1);
                    break;
                case 17:
                    Exercise17<Integer> ex17 = new Exercise17();
                    ex17.pushFront(12);
                    ex17.pushFront(11);
                    ex17.pushFront(15);
                    ex17.pushFront(14);
                    ex17.print();
                    ex17.emptyList();
                    ex17.print();
                    break;
                case 18:
                    Exercise18<Integer> ex18 = new Exercise18();
                    ex18.print();
                    System.out.println(ex18.isListEmpty());
                    ex18.pushFront(12);
                    ex18.pushFront(11);
                    ex18.pushFront(15);
                    ex18.pushFront(14);
                    ex18.print();
                    System.out.println(ex18.isListEmpty());
                    break;
                case 19:
                    System.out.println("I do not know how to show that capacity trimmed");
                    break;
                case 20:
                    System.out.println("I do not know how to show that capacity trimmed");
                    break;
                case 21:
                    Exercise21<Integer> ex21 = new Exercise21();
                    ex21.pushFront(12);
                    ex21.pushFront(11);
                    ex21.pushFront(15);
                    ex21.pushFront(14);
                    ex21.print();
                    ex21.updateSecondElement(666);
                    ex21.print();
                case 22:
                    Exercise22<Integer> ex22 = new Exercise22();
                    ex22.pushFront(12);
                    ex22.pushFront(11);
                    ex22.pushFront(15);
                    ex22.pushFront(14);
                    ex22.print();
                default:
                    System.out.println("Thank you for review! Have a nice day)");
                    caseNumber = 0;
                    break;
            }

        } while (caseNumber != 0);

    }
}
