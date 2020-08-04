import java.util.Scanner;

public class Bank {

    public static void main( String[] args ) {
        // main application
        BankAccount loggedInAccount = new BankAccount( "Zach Battaglia", "ZB346FT" );
        loggedInAccount.showMenu();

    }

}

// set up the bank account
class BankAccount {

    // variables that each account will track
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    // constructor function to create a bank account
    BankAccount( String name, String ID ) {

        customerName = name;
        customerId = ID;

    }

    // method for making deposits
    // returns nothing, adds the amount to existing balance
    void deposit( int amount ) {

        // if the deposit amount is not zero then add to current balance
        if( amount != 0 ) {

            balance = balance + amount;
            previousTransaction = amount;

        }
    }

    // method to make a withdrawal
    void withdraw( int amount ) {

        if( amount != 0 ) {

            balance = balance - amount;
            previousTransaction = -amount;

        }
    }

    // method to check previous transaction
    // note: this method prints to the terminal, but is still void because it returns nothing
    // math.abs is used to convert a withdrawl amount from showing withdrawn: -xxxx
    void getPreviousTransaction() {

        // print the previous transaction type and amount when called
        if( previousTransaction > 0 ) {
            System.out.println( "Deposited: $" + previousTransaction );
        }
        else if( previousTransaction < 0 ) {
            System.out.println( "Withdrew: $" + Math.abs(previousTransaction) );
        }
        else {
            System.out.println( "This is the first transaction on this account." );
        }
    }

    // method to show a menu for the user to select an action
    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner( System.in );

        System.out.println( "Welcome " + customerName );
        System.out.println( "Your customer ID is: " + customerId );
        System.out.println( "\n" );
        System.out.println( "A) Check Balance." );
        System.out.println( "B) Make A Deposit." );
        System.out.println( "C) Make A Withdrawal." );
        System.out.println( "D) Check Previous Transaction." );
        System.out.println( "E) Log Out." );

        // do-while loop
        // evaluates the expression at the bottom, and until true, executes the body of the do statement
        // this case will ask a user to select an option until the option selected is 'E' (Log Out)
        do {

            System.out.println( "===============================================================" );
            System.out.println( "Select an Option." );
            System.out.println( "===============================================================" );
            
            option = scanner.next().charAt(0);
            System.out.println( "\n" );

            switch( option ) {
                case 'A':
                    System.out.println( "-------------------------------------------------------" );
                    System.out.println( "Balance = " + balance );
                    System.out.println( "-------------------------------------------------------" );
                    System.out.println( "\n" );
                    break;

                case 'B':
                    System.out.println( "-------------------------------------------------------" );
                    System.out.println( "Enter a deposit amount:" );
                    System.out.println( "-------------------------------------------------------" );
                    int depositAmount = scanner.nextInt();
                    deposit( depositAmount );
                    System.out.print( "\n" );
                    break;

                case 'C':
                    System.out.println( "-------------------------------------------------------" );
                    System.out.println( "Enter a withdrawal amount:" );
                    System.out.println( "-------------------------------------------------------" );
                    int withdrawalAmount = scanner.nextInt();
                    withdraw( withdrawalAmount );
                    System.out.println( "\n" );
                    break;

                case 'D':
                    System.out.println( "-------------------------------------------------------" );
                    getPreviousTransaction();
                    System.out.println( "-------------------------------------------------------" );
                    System.out.print( "\n" );
                    break;

                case 'E':
                    break;

                default:
                    System.out.println( "Invalid Option Selected. Please try again." );
                    break;
            }
        }
        while( option != 'E' );
        
        System.out.println( "Thanks you for banking with us!" );
        
        scanner.close();
    }
}