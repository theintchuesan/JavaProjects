package JavaProjects;

import java.util.Scanner;
 
 class Account{
    private String name;
    private double balance;

    public Account(String name , double balance){
        this.name = name;

        if(balance>0.0){
        this.balance=balance;} 
    }

    public void setName(String name){
        this.name = name;
    }
public String getName(){
    return name;
}
public double getBalance(){
    return balance;
}

public void deposit(double depositAmount){
    if(depositAmount>0.0){
        balance = balance +depositAmount;
    }
}
}



public class AccountTest {
   public static void main(String[] args) {
    Account acc1 = new Account("Jhon",50.0);
    Account acc2 = new Account("Max", -7.53);

    System.out.printf("Name: %s   Balance : %.2f ",acc1.getName(), acc1.getBalance() );
    
    System.out.printf("Name: %s   Balance : %f ",acc2.getName(), acc2.getBalance());
    
   @SuppressWarnings("resource")
Scanner input = new Scanner (System.in);

   System.out.println("Enter deposit amount for account 1");
   double depositAmount = input.nextDouble();
   System.out.printf("Adding %.2f to account1 balance\n",depositAmount);
   acc1.deposit(depositAmount);
System.out.printf("Name: %s Balance: %.2f\n",acc1.getName(),acc1.getBalance());
System.out.printf("Name: %s Balance: %.2f\n",acc2.getName(),acc2.getBalance());

System.out.println("Enter deposit amount for account 2");
depositAmount = input.nextDouble();
System.out.printf("Adding %.2f to account2 balance\n",depositAmount);
   acc2.deposit(depositAmount);
   System.out.printf("Name: %s Balance: %.2f\n",acc1.getName(),acc1.getBalance());
System.out.printf("Name: %s Balance: %.2f\n",acc2.getName(),acc2.getBalance());

   }  
}


