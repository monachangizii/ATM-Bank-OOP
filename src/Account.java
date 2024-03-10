import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;



public class Account {
    int balance;
    int prevTransaction;
    String customerName;
    String customerID;

    // Class Constructor
    Account(String name, String id) {
        this.customerID = id;
        this.customerName = name;
    }

    void deposit(int amount) {
        if (amount != 0 && amount > 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount <= balance )
        {
            if (amount != 0)
            {
                balance = balance - amount;
                prevTransaction = -amount;
            }
        }
        else
        {
            System.out.println("You don't have enough balance:(");
        }

    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Found!");
        }
    }

    void showDate() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check Your Balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdraw");
        System.out.println("D. View Perv Transaction");
        System.out.println("E. Show today Date");
        System.out.println("F. Exit");


        do {
            System.out.println();
            System.out.println("Please Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                case 'A':
                    System.out.println("=================");
                    System.out.println("Balance = " + balance);
                    System.out.println("=================");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter an amount to Withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;
                case 'D':
                    System.out.println("==============");
                    getPrevTransaction();
                    System.out.println("==============");
                    break;
                case 'E':
                    showDate();
                    break;
                case 'F':
                    System.out.println("=========");
                    break;
                default:
                    System.out.println("Error: Invalid Option. Please Enter A,B,C,D,E or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Have a nice day ;)");
    }
}

