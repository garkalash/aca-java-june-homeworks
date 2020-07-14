import exercises.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListExercises {
    public static void main(String[] args) {
        final int exit = 0;
        Scanner in = new Scanner(System.in);
        int caseNumber;
        do {
            System.out.println("Please enter which exercise yo want to check(1-26). Press any other number to close");
            caseNumber = in.nextInt();
            switch (caseNumber) {
                case 1:
                    Exercise1<Number> ex1 = new Exercise1<>();
                    ex1.appendToList(2);
                    ex1.appendToList(2);
                    ex1.appendToList(5);
                    ex1.print();
                    break;
                case 2:
                    Exercise2<Number> ex2 = new Exercise2<>();
                    ex2.appendToList(2);
                    ex2.appendToList(2);
                    ex2.appendToList(5);
                    ex2.print();
                    break;
                case 3:
                    Exercise3<Number> ex3 = new Exercise3<>();
                    ex3.appendToList(2);
                    ex3.appendToList(2);
                    ex3.appendToList(5);
                    ex3.appendToList(15);
                    ex3.appendToList(9);
                    ex3.print();
                    ex3.iterateFromIndex(2);
                    break;
                case 4:
                    Exercise4<Number> ex4 = new Exercise4<>();
                    ex4.appendToList(2);
                    ex4.appendToList(2);
                    ex4.appendToList(5);
                    ex4.appendToList(15);
                    ex4.appendToList(9);
                    ex4.print();
                    ex4.iterateReverse();
                    break;
                case 5:
                    Exercise5<Number> ex5 = new Exercise5<>();
                    ex5.appendToList(2);
                    ex5.appendToList(2);
                    ex5.appendToList(5);
                    ex5.appendToList(15);
                    ex5.appendToList(9);
                    ex5.print();
                    ex5.addByIndex(2, 777);
                    ex5.print();
                    break;
                case 6:
                    Exercise6<Number> ex6 = new Exercise6<>();
                    ex6.appendToList(2);
                    ex6.appendToList(2);
                    ex6.appendToList(5);
                    ex6.appendToList(15);
                    ex6.appendToList(9);
                    ex6.print();
                    ex6.addElementToFirstPosition(999);
                    ex6.print();
                    ex6.addElementToLastPosition(666);
                    ex6.print();
                    break;
                case 7:
                    Exercise7<Number> ex7 = new Exercise7<>();
                    ex7.appendToList(2);
                    ex7.appendToList(2);
                    ex7.appendToList(5);
                    ex7.appendToList(15);
                    ex7.appendToList(9);
                    ex7.print();
                    if(ex7.pushFront(11)) {
                        ex7.print();
                    } else {
                        System.out.println("Insertion failed");
                    }
                    break;
                case 8:
                    Exercise8<Number> ex8 = new Exercise8<>();
                    ex8.appendToList(2);
                    ex8.appendToList(2);
                    ex8.appendToList(5);
                    ex8.appendToList(15);
                    ex8.appendToList(9);
                    ex8.print();
                    if(ex8.insertFromEnd(11)) {
                        ex8.print();
                    } else {
                        System.out.println("Insertion failed");
                    }
                    break;
                case 9:
                    Exercise9<Number> ex9 = new Exercise9<>();
                    ex9.appendToList(2);
                    ex9.appendToList(2);
                    ex9.appendToList(5);
                    ex9.appendToList(15);
                    ex9.appendToList(9);
                    ex9.print();
                    LinkedList<Integer> sourceList = new LinkedList<>();
                    sourceList.add(555);
                    sourceList.add(666);
                    sourceList.add(777);
                    ex9.addListFromIndex(sourceList,2);
                    ex9.print();
                    break;
                case 10:
                    Exercise10<Number> ex10 = new Exercise10<>();
                    ex10.appendToList(1);
                    ex10.appendToList(2);
                    ex10.appendToList(5);
                    ex10.appendToList(15);
                    ex10.appendToList(9);
                    ex10.print();
                    System.out.println("First is: " + ex10.getFirst());
                    System.out.println("Last is: " + ex10.getLast());
                    break;
                case 11:
                    Exercise11<Number> ex11 = new Exercise11<>();
                    ex11.appendToList(1);
                    ex11.appendToList(2);
                    ex11.appendToList(5);
                    ex11.appendToList(15);
                    ex11.appendToList(9);
                    ex11.print();
                    break;
                case 12:
                    Exercise12<Number> ex12 = new Exercise12<>();
                    ex12.appendToList(1);
                    ex12.appendToList(2);
                    ex12.appendToList(5);
                    ex12.appendToList(15);
                    ex12.appendToList(9);
                    ex12.print();
                    if(ex12.removeElement(15)) {
                        ex12.print();
                    } else {
                        System.out.println("There is no this element");
                    }
                    break;
                case 13:
                    Exercise13<Number> ex13 = new Exercise13<>();
                    ex13.appendToList(1);
                    ex13.appendToList(2);
                    ex13.appendToList(5);
                    ex13.appendToList(15);
                    ex13.appendToList(9);
                    ex13.print();
                    ex13.removeFirst();
                    ex13.print();
                    ex13.removeLast();
                    ex13.print();
                    break;
                case 14:
                    Exercise14<Number> ex14 = new Exercise14<>();
                    ex14.appendToList(1);
                    ex14.appendToList(2);
                    ex14.appendToList(5);
                    ex14.appendToList(15);
                    ex14.appendToList(9);
                    ex14.print();
                    ex14.removeAll();
                    ex14.print();
                    break;
                case 15:
                    Exercise15<Number> ex15 = new Exercise15<>();
                    ex15.appendToList(1);
                    ex15.appendToList(2);
                    ex15.appendToList(5);
                    ex15.appendToList(15);
                    ex15.appendToList(9);
                    ex15.print();
                    ex15.swapElements(1,3);
                    ex15.print();
                    break;
                case 16:
                    Exercise16<Number> ex16 = new Exercise16<>();
                    ex16.appendToList(1);
                    ex16.appendToList(2);
                    ex16.appendToList(5);
                    ex16.appendToList(15);
                    ex16.appendToList(9);
                    ex16.print();
                    ex16.shuffleList();
                    ex16.print();
                    break;
                case 17:
                    Exercise17<Number> ex17 = new Exercise17<>();
                    ex17.appendToList(1);
                    ex17.appendToList(2);
                    ex17.appendToList(5);
                    ex17.appendToList(15);
                    ex17.appendToList(9);
                    ex17.print();
                    LinkedList<Integer> sourceList1 = new LinkedList<>();
                    sourceList1.add(555);
                    sourceList1.add(666);
                    sourceList1.add(777);
                    if(ex17.joinLists(sourceList1)) {
                        ex17.print();
                    } else {
                        System.out.println("List join function fails");
                    }
                    break;
                case 18:
                    Exercise18<Number> ex18 = new Exercise18<>();
                    ex18.appendToList(1);
                    ex18.appendToList(2);
                    ex18.appendToList(5);
                    ex18.appendToList(15);
                    ex18.appendToList(9);
                    ex18.print();
                    LinkedList<Integer> dstList = new LinkedList<>();
                    dstList = (LinkedList<Integer>) ex18.cloneList();
                    System.out.println(dstList);
                    break;
                case 19:
                    Exercise19<Number> ex19 = new Exercise19<>();
                    ex19.appendToList(1);
                    ex19.appendToList(2);
                    ex19.appendToList(5);
                    ex19.appendToList(15);
                    ex19.appendToList(9);
                    ex19.print();
                    System.out.println(ex19.popFirst());
                    break;
                case 20:
                    Exercise20<Number> ex20 = new Exercise20<>();
                    ex20.appendToList(1);
                    ex20.appendToList(2);
                    ex20.appendToList(5);
                    ex20.appendToList(15);
                    ex20.appendToList(9);
                    ex20.print();
                    System.out.println((ex20.retrieveFirst() == null) ? "Array is empty " : ex20.retrieveFirst());
                    break;
                case 21:
                    Exercise21<Number> ex21 = new Exercise21<>();
                    ex21.appendToList(1);
                    ex21.appendToList(2);
                    ex21.appendToList(5);
                    ex21.appendToList(15);
                    ex21.appendToList(9);
                    ex21.print();
                    System.out.println((ex21.retrieveLast() == null) ? "Array is empty " : ex21.retrieveLast());
                    break;
                case 22:
                    Exercise22<Number> ex22 = new Exercise22<>();
                    ex22.appendToList(1);
                    ex22.appendToList(2);
                    ex22.appendToList(5);
                    ex22.appendToList(15);
                    ex22.appendToList(9);
                    ex22.print();
                    System.out.printf("Is the element %d exist in list?\n%b\n", 15, ex22.isExist(15));
                    System.out.printf("Is the element %d exist in list?\n%b\n", 22, ex22.isExist(22));
                    break;
                case 23:
                    Exercise23<Number> ex23 = new Exercise23<>();
                    ex23.appendToList(1);
                    ex23.appendToList(2);
                    ex23.appendToList(5);
                    ex23.appendToList(15);
                    ex23.appendToList(9);
                    ex23.print();
                    ArrayList<Number> arrayList = ex23.convertToArrayList();
                    System.out.println(arrayList);
                    break;
                case 24:
                    Exercise24<Number> ex24 = new Exercise24<>();
                    ex24.appendToList(1);
                    ex24.appendToList(2);
                    ex24.appendToList(5);
                    ex24.appendToList(15);
                    ex24.appendToList(9);
                    ex24.print();
                    LinkedList<Number> listSecond = new LinkedList<>();
                    listSecond.add(1);
                    listSecond.add(2);
                    listSecond.add(5);
                    listSecond.add(15);
                    listSecond.add(9);
                    System.out.println(ex24.compare(listSecond));
                    listSecond.add(91);
                    System.out.println(ex24.compare(listSecond));
                    break;
                case 25:
                    Exercise25<Number> ex25 = new Exercise25<>();
                    ex25.print();
                    System.out.println(ex25.isEmpty());
                    ex25.appendToList(1);
                    ex25.appendToList(2);
                    ex25.appendToList(5);
                    ex25.appendToList(15);
                    ex25.appendToList(9);
                    ex25.print();
                    System.out.println(ex25.isEmpty());
                    break;
                case 26:
                    Exercise26<Number> ex26 = new Exercise26<>();
                    ex26.appendToList(1);
                    ex26.appendToList(2);
                    ex26.appendToList(5);
                    ex26.appendToList(15);
                    ex26.appendToList(9);
                    ex26.print();
                    ex26.replaceElement(2, 222);
                    ex26.print();
                    break;
                default:
                    caseNumber = exit;
                    break;
            }
        } while (caseNumber != exit);
    }
}
