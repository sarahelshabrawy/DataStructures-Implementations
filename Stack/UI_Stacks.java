package eg.edu.alexu.csd.datastructure.stack.cs28;

import java.util.Scanner;

public class UI_Stacks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack myStack = new Stack();
        int choice;
        do {
            System.out.println("Choose an operation :\n" +"1: Push\n" +
                    "2: Pop\n" +
                    "3: Peek\n" +
                    "4: Get size\n" +
                    "5: Check if empty\n" +
                    "-1: Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element value you want to push");
                    myStack.push(scan.next());
                    break;
                case 2:
                    System.out.println(myStack.pop());
                    break;
                case 3:
                    System.out.println(myStack.peek());
                    break;
                case 4:
                    System.out.println(myStack.size());
                    break;
                case 5:
                    System.out.println(myStack.isEmpty());
                    break;
                case -1: break;
                default: throw new RuntimeException("Invalid Input!");
            }
        }while (choice!=-1);
    }
}
