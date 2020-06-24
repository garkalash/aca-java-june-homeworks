package com.aca.narekhakobyan.homework1.tests;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Test cases\n1)Show all list of items\n2)Sell item function\n3)Sold and Stock AMD functions\n" +
                "4)List of items by type\n5)Change price function\n6)Wrong input parameters" +
                "in constructor\n7)Wrong parameters for addItem function\n8)Remove item\n9)exit");
        System.out.print("Please enter test case number: ");
        int testCase;

        br:
        while (true) {
            System.out.print("Please enter test case number: ");
            testCase = in.nextInt();
            switch (testCase) {
                case 1:
                    TestListOfItem testListOfItem = new TestListOfItem();
                    testListOfItem.RunTest();
                    break;
                case 2:
                    TestSellItem testSellItem = new TestSellItem();
                    testSellItem.RunTest();
                    break;
                case 3:
                    TestSoldAndStockAMD testSoldAndStockAMD = new TestSoldAndStockAMD();
                    testSoldAndStockAMD.RunTest();
                    break;
                case 4:
                    TestListOfByType testListOfByType = new TestListOfByType();
                    testListOfByType.RunTest();
                    break;
                case 5:
                    TestChangePrice testChangePrice = new TestChangePrice();
                    testChangePrice.RunTest();
                    break;
                case 6:
                    TestInitWithWrongParams testInitWithWrongParams = new TestInitWithWrongParams();
                    testInitWithWrongParams.RunTest();
                    break;
                case 7:
                    TestWrongInputForAddItem testWrongInputForAddItem = new TestWrongInputForAddItem();
                    testWrongInputForAddItem.RunTest();
                    break;
                case 8:
                    TestRemoveItem testRemoveItem = new TestRemoveItem();
                    testRemoveItem.RunTest();
                    break;
                case 9:
                    break br;
                default:
                    System.out.println("Please enter right test case number");
                    continue br;
            }
        }
    }
}
