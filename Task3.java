package Internship.projects;


import java.util.Scanner;

class Bank_Acc{
    private double Balance;
    Scanner in=new Scanner(System.in);
    public Bank_Acc(double Initial_Balance){
        this.Balance=Initial_Balance;
    }

    public void Deposit(double Amount){
        if(Amount>0) {
            Balance += Amount;
            System.out.println("Transaction Successful");
            System.out.println("Present balance of your account: -   "+(Balance));
        }
        else{
            System.out.println("Enter a valid amount to deposit.");
        }
    }

    public void Withdraw(double Amount){
        if(Amount>Balance){
            System.out.println("Insufficient Balance to do the transaction");

        }
        else{
            Balance-=Amount;
            System.out.println("Transaction successful.");
            System.out.println("Present balance of your account: -   "+(Balance));
        }
    }

    public void Check_Balance(){
        System.out.println("The Balance of your Account:  "+Balance);
    }
    public double getBalance(){
        return Balance;
    }
}
class ATM_Interface{
    private Bank_Acc B_A;
    public ATM_Interface(Bank_Acc B_A){
        this.B_A=B_A;
    }

    public void start(){
        Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("\t\t-----------Welcome to the ATM---------\n");
            System.out.println("1. Deposit..");
            System.out.println("2. Withdraw..");
            System.out.println("3. Check Balance of Account..");
            System.out.println("4. Exit..");
            System.out.print("Choose any option from Above to continue:--  ");
            int option=in.nextInt();
            switch (option){
                case 1:
                    System.out.print("Enter the amount to be deposited: -   ");
                    double Amt=in.nextDouble();
                    B_A.Deposit(Amt);
                    break;
                case 2:
                    System.out.print("Enter the amount to be withdrawn: -   ");
                    double Amt1=in.nextDouble();
                    B_A.Withdraw(Amt1);
                    break;
                case 3:
                    B_A.Check_Balance();
                    break;
                case 4:
                    System.out.println("Thanks for Using the ATM. Visit Again!");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid Choice entered, Please Enter a valid choice!");
            }
        }
    }
}
public class Task3 {
    public static void main(String[] args) {
        Bank_Acc User=new Bank_Acc(1_00_000);
        ATM_Interface ATM=new ATM_Interface(User);
        ATM.start();

    }
}
