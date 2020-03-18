package eg.edu.alexu.csd.datastructure.linkedList.cs24_cs28;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
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
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    ps.add(poly1,poly2);
                    break;
                case 4:
                    while(true) {
                        System.out.println("Insert first operand variable name: A, B or C");
                        poly1 = scan.next().charAt(0);
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    ps.subtract(poly1,poly2);
                    break;
                case 5:
                    while(true) {
                        System.out.println("Insert first operand variable name: A, B or C");
                        poly1 = scan.next().charAt(0);
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    while(true) {
                        System.out.println("Insert second operand variable name: A, B or C");
                        poly2 = scan.next().charAt(0);
                        if (ps.chooseList(poly1).size() != 0)
                            break;
                        else
                            System.out.println("Variable not set");
                    }
                    ps.multiply(poly1,poly2);
                    break;
                case 6:
                    System.out.println("Insert the variable name: A, B, C or R");
                    poly1 = scan.next().charAt(0);
                    System.out.println("Insert value of X of the point to be evaluated at :");
                    float value = scan.nextFloat();
                    ps.evaluatePolynomial(poly1,value);
                    break;
                case 7:
                    System.out.println("Insert the variable name: A, B, C or R");
                    poly1 = scan.next().charAt(0);
                    ps.clearPolynomial(poly1);
                    System.out.println("Polynomial "+poly1+" is cleared");
                    break;
                default:

            }
        }while (choice!=-1);

    }
}

