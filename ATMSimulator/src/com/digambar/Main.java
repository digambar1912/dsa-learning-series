package com.digambar;

import java.util.Scanner;

public class Main {
    public static final String X = "-----------------------------------------------";
    private static float balance ;
    private static final long minBalance = 500;

    public static void main(String[] args) {
        boolean exitFlag = false;
        boolean continueFlag = true;
        while(!exitFlag && continueFlag){
            System.out.println("Transactions list: ");
            System.out.println("1) Display Balance: Press 1");
            System.out.println("2) Deposit: Press 2");
            System.out.println("3) Withdrew: Press 3");
            System.out.println("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            getOperation(choice);
            System.out.println("Do you want to exit: Press 5");
            System.out.println("Continue with Menu: Press 6");
            Scanner input1 = new Scanner(System.in);
            int choice1 = input1.nextInt();
            if(choice1 == 5){
                exitFlag = true;
            }
            if(choice1 == 6){
                continueFlag = true;
            }
        }

    }

    private static void getOperation(int choice){
        switch (choice) {
            case 1: System.out.println("You have selected: " + choice + " Display Balance");
                    displayBalance();
                    break;
            case 2: System.out.println("You have selected: " + choice + " Deposit");
                    deposit();
                    break;
            case 3: System.out.println("You have selected: " + choice + " Withdrew");
                    displayBalance();
                    withdrow();
                    break;
            default: System.out.println("Please select correct operation");
                    break;
        }


}

    private static void withdrow(){
        System.out.println("Please enter amount to be withdrew :");
        Scanner input1 = new Scanner(System.in);
        int withdrowAmt = input1.nextInt();

        if(minBalance > (balance-withdrowAmt)){
            String s1 = String.format("Not sufficient balance. Please Maintain Minimum Balance of Rs %s.", minBalance);
            System.out.println(s1);
        }else{
            balance = balance-withdrowAmt;
            String s1 = String.format("Amount withdrew : Rs %s  ", withdrowAmt);
            System.out.println(s1);
            String s2 = String.format("Your account balance : Rs %s  ", balance);
            System.out.println(s2);
        }

        System.out.println(X);
     }

    private static void displayBalance(){
        String s = String.format("You have %s Balance in your account.", balance);
        System.out.println(s);
        if(balance<minBalance){
            String s1 = String.format("Please Maintain Minimum Balance of Rs %s.", minBalance);
            System.out.println(s1);
        }
        System.out.println(X);
    }

    private static float deposit(){
        System.out.println("Please enter Deposit amount :");
        Scanner input = new Scanner(System.in);
        int depositAmt = input.nextInt();

        if( (depositAmt%100 != 0) &&  (depositAmt%500 != 0) ){
            System.out.println("Deposit amount should be in Rs. 100 or Rs. 500 denomination");
        }else{
            balance = balance+depositAmt;
            String s1 = String.format("Amount Deposited of Rs. %s.", depositAmt);
            System.out.println(s1);
            String s2 = String.format("Your account balance of Rs. %s.", balance);
            System.out.println(s2);
        }
        System.out.println(X);
        return balance;
    }

}