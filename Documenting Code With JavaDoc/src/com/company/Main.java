package com.company;

import java.util.Scanner;

/**
 * The Main class, has user make a choice of customer type and enter appropriate information, then display information and charges to user
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Make your choice: ");
            System.out.println("1. Commercial");
            System.out.println("2. Residential");
            System.out.println("3. Done");
            choice = in.nextInt();
            if (choice != 1 && choice != 2 && choice != 3)
                System.out.println("Incorrect entry, try again!\n");
        } while (choice != 1 && choice != 2 && choice != 3);

        switch (choice) {
            case 1:
                commercial();
                break;
            case 2:
                residential();
                break;
            case 3:
                System.out.println("Have a nice day!");
                break;
        }
    }

    private static void commercial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Commercial Customer");
        System.out.println("Please enter the customer name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the customer phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Please enter the customer address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter the square footage of the property: ");
        String foot = scanner.nextLine();
        double footage = Double.parseDouble(foot);
        System.out.println("Is there a multi-property discount? (t/f): ");
        String discount = scanner.nextLine();
        Commercial dis = new Commercial(name, phone, address, footage);
        double total = 0.00;


        if (discount.substring(0, 1).equals("t") || discount.substring(0, 1).equals("T")) {
            System.out.println("You receive a multi property discount of 10%");
            total = dis.multiDiscount(true);
        } else {
            total = dis.multiDiscount(false);
        }
        System.out.println("Name: " + name + "\n" + "Phone: " + phone + "\n" + "Address: " + address + "\n" + "Square Footage: " + footage + " square ft" + "\n" + "Your total is: $" + (String.format("%.2f", total)) + " per week.");
    }

    private static void residential() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Residential Customer");
        System.out.println("Please enter the customer name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the customer phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Please enter the customer address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter the square footage of the property: ");
        String foot = scanner.nextLine();
        double footage = Double.parseDouble(foot);
        System.out.println("Is there a senior discount? (t/f): ");
        String discount = scanner.nextLine();
        Residential dis = new Residential(name, phone, address, footage);
        double total = 0.00;


        if (discount.substring(0, 1).equals("t") || discount.substring(0, 1).equals("T")) {
            System.out.println("You receive a senior discount of 15%");
            total = dis.seniorDiscount(true);
        } else {
            total = dis.seniorDiscount(false);
        }
        System.out.println("Name: " + name + "\n" + "Phone: " + phone + "\n" + "Address: " + address + "\n" + "Square Footage: " + footage + " square ft" + "\n" + "Your total is: $" + (String.format("%.2f", total)) + " per week.");
    }
}