package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Book[] bookInventory = {
                new Book(1,"9780061120084","To Kill a Mockingbird",false,""),
                new Book(2,"9780451524935","1984",false,""),
                new Book(3,"9780743273565","The Great Gatsby",false,""),
                new Book(4,"9781503290563","Pride and Prejudice",false,""),
                new Book(5,"9780316769488","The Catcher in the Rye",false,""),
                new Book(6,"9780544003415","The Lord of the Rings",false,""),
                new Book(7,"9780590353427","Harry Potter and the Sorcerer’s Stone",false,""),
                new Book(8,"9780547928227","The Hobbit",false,""),
                new Book(9,"9781451673319","Fahrenheit 451",false,""),
                new Book(10,"9780061122415","The Alchemist",false,""),
                new Book(11,"9780141441146","Jane Eyre",false,""),
                new Book(12,"9780451526342","Animal Farm",false,""),
                new Book(13,"9780060850524","Brave New World",false,""),
                new Book(14,"9780141439556","Wuthering Heights",false,""),
                new Book(15,"9780143058144","Crime and Punishment",false,""),
                new Book(16,"9780307474278","The Da Vinci Code",false,""),
                new Book(17,"9780439023528","The Hunger Games",false,""),
                new Book(18,"9781594631931","The Kite Runner",false,""),
                new Book(19,"9780156027328","Life of Pi",false,""),
                new Book(20,"9780375842207","The Book Thief",false,""),
        };

        System.out.println("=====[Neighborhood Library]=====");
        System.out.println("");

        while(true) {
            System.out.println("Please select a menu option");
            System.out.println("(1) Show available books");
            System.out.println("(2) Show checked out books");
            System.out.println("(3) Exit");

            System.out.print("Enter a number for the menu option: ");
            int selection = scan.nextInt();
            scan.nextLine();

            switch(selection) {
                case 1:
                    System.out.println("=====[Currently Available Books]=====");
                    listAvailableBooks(bookInventory);
                    System.out.println("Select one of the options below:");
                    System.out.println("(1) Select a book to check out");
                    System.out.println("(2) Return to main menu");

                    System.out.print("Enter a number for the menu option: ");
                    int selectAvailable = scan.nextInt();
                    scan.nextLine();

                    switch(selectAvailable) {
                        case 1:
                            System.out.print("Enter the id of the book you would like to check out: ");
                            int bookCheckOutSelect = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Enter your first and last name: ");
                            String name = scan.nextLine();


                            for (int i = 0; i < bookInventory.length; i++) {
                                if (bookInventory[i].getId() == bookCheckOutSelect) {
                                    bookInventory[i].checkOut(name);
                                }
                            }
                        case 2:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("=====[Currently Checked Out Books]=====");
                    checkedOutBooks(bookInventory);
                    System.out.println("Select one of the options below:");
                    System.out.println("(C) Check in a book");
                    System.out.println("(X) Return to main menu");

                    System.out.print("Enter a character for the menu option: ");
                    String bookCheckInSelect = scan.next();

                    if (bookCheckInSelect.equals("C")) {
                        System.out.print("Enter the id of the book you would like to check in: ");
                        int checkedInBook = scan.nextInt();
                        scan.nextLine();

                        for (int i = 0; i < bookInventory.length; i++) {
                            if (bookInventory[i].getId() == checkedInBook) {
                                bookInventory[i].checkIn();
                            }
                        }
                    } else if (bookCheckInSelect.equals("X")) {
                        return;
                    } else {
                        System.out.print("Please enter the correct character!");
                        return;
                    }

                    break;
                case 3:
                    System.exit(0);
                    scan.close();
            }
        }
    }

    public static void listAvailableBooks(Book[] bookInventory) {
        for (int i = 0; i < bookInventory.length; i++) {
            if (bookInventory[i].isCheckedOut() == false) {
                System.out.println(bookInventory[i]);
                }
            }
        }

    public static void checkedOutBooks(Book[] bookInventory) {
        for (int i = 0; i < bookInventory.length; i++) {
            if (bookInventory[i].isCheckedOut() == true) {
                System.out.println(bookInventory[i]);
            }
        }
    }
    }


