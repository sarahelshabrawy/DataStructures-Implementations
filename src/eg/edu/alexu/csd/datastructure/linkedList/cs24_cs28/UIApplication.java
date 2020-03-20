package eg.edu.alexu.csd.datastructure.linkedList.cs24_cs28;

import java.util.Scanner;
import java.util.regex.*;
public class UIApplication {
    public static void main(String[] args) {
        int choice;
        char poly1;
        char poly2;
        PolynomialSolver ps = new PolynomialSolver();
        do {
            System.out.println("Please choose an action");
            System.out.println("-----------------------");
            System.out.println("1- Set a polynomial variable\n"
                    + "2- Print the value of a polynomial variable\n"
                    + "3- Add two polynomials\n"
                    + "4- Subtract two polynomials\n"
                    + "5- Multiply two polynomials\n"
                    + "6- Evaluate a polynomial at some point\n"
                    + "7- Clear a polynomial variable");
            System.out.println("============================================================================");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            choice = Character.toUpperCase(choice);
            switch (choice) {
                case 1:
                    System.out.println("Insert the variable name: A, B or C");
                    poly1 = scan.next().charAt(0);
                    if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                        throw new RuntimeException("Invalid Variable Name !");
                    else {
                        SinglyLinkedList list = new SinglyLinkedList();
                        System.out.println("Insert the polynomial terms in the form:\n" +
                                "(coeff1, exponent1), (coeff2, exponent2), ..");
                        scan.nextLine();
                        String line = scan.nextLine();
                        Matcher m = Pattern.compile("-?\\d+").matcher(line);
                        while (m.find())
                            list.add(Integer.parseInt(m.group()));
                        //System.out.println(m.group());
                        ps.setPolynomial(poly1, ps.listtoarray(list));
                        System.out.println(ps.print(poly1));
                        System.out.println("Polynomial " + Character.toUpperCase(poly1) +" is set");
                    }
                    break;
                case 2:
                    System.out.println("Insert the variable name: A, B, C or R");
                    poly1 = scan.next().charAt(0);
                    if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C'&& Character.toUpperCase(poly1) != 'R')
                        throw new RuntimeException("Invalid Variable Name !");
                    else {
                        System.out.print(Character.toUpperCase(poly1) + " Value in " + Character.toUpperCase(poly1) + ": ");
                        System.out.println(ps.print(poly1));
                    }
                    break;
                case 3:
                    while(true) {
                        System.out.println("Insert first operand variable name: A, B or C");
                        poly1 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly1).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly2).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    ps.add(poly1,poly2);
                    //////////////////////////////////////////////////
                    System.out.println("Result set in R:");
                    for(int i =0 ; i<ps.R.size();i+=2) {
                        System.out.print("(" + ps.R.get(i) + "," + ps.R.get(i + 1) + ")");
                        if(i+1!=ps.R.size()-1) {
                            System.out.print(",");
                        }
                    }
                    System.out.println();
                    //////////////////////////////////////////////////
                    break;
                case 4:
                    while(true) {
                        System.out.println("Insert first operand variable name: A, B or C");
                        poly1 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly1).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly2).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    ps.subtract(poly1,poly2);
                    //////////////////////////////////////////////////
                    System.out.println("Result set in R:");
                    for(int i =0 ; i<ps.R.size();i+=2) {
                        System.out.print("(" + ps.R.get(i) + "," + ps.R.get(i + 1) + ")");
                        if(i+1!=ps.R.size()-1) {
                            System.out.print(",");
                        }
                    }
                    System.out.println();
                    //////////////////////////////////////////////////
                    break;
                case 5:
                    while(true) {
                        System.out.println("Insert first operand variable name: A, B or C");
                        poly1 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly1).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                            throw new RuntimeException("Invalid Variable Name !");
                        else {
                            if (ps.chooseList(poly2).size() != 0)
                                break;
                            else
                                System.out.println("Variable not set");
                        }
                    }
                    ps.multiply(poly1,poly2);
                    //////////////////////////////////////////////////
                    System.out.println("Result set in R:");
                    for(int i =0 ; i<ps.R.size();i+=2) {
                        System.out.print("(" + ps.R.get(i) + "," + ps.R.get(i + 1) + ")");
                        if(i+1!=ps.R.size()-1) {
                            System.out.print(",");
                        }
                    }
                    System.out.println();
                    //////////////////////////////////////////////////
                    break;
                case 6:
                    System.out.println("Insert the variable name: A, B, C or R");
                    poly1 = scan.next().charAt(0);
                    if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                        throw new RuntimeException("Invalid Variable Name !");
                    else {
                        System.out.println("Insert value of X of the point to be evaluated at :");
                        float value = scan.nextFloat();
                        System.out.println("F("+value+") = " + ps.evaluatePolynomial(poly1, value));
                    }
                    break;
                case 7:

                    System.out.println("Insert the variable name: A, B, C or R");
                    poly1 = scan.next().charAt(0);
                    if (Character.toUpperCase(poly1) != 'A' && Character.toUpperCase(poly1) != 'B' && Character.toUpperCase(poly1) != 'C')
                        throw new RuntimeException("Invalid Variable Name !");
                    else {
                        ps.clearPolynomial(poly1);
                        System.out.println("Polynomial " + poly1 + " is cleared");
                    }
                    break;
                case -1:
                    break;
                default:
                    throw new RuntimeException("Invalid Input!");
            }
        }while (choice!=-1);

    }
}