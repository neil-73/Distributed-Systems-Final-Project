// BankClient.java

/*
	Distributed Systems (SOFE4790) - Project Source Code
	By: Neil Ramdath
	ID: 100519195
*/

import java.io.*; 
import java.rmi.*; 

public class BankClient 
{ 
	public static void main(String args[]) 
	{ 
		int ch; 
		try 
		{ 
			String bankserverURL = "rmi://" + args[0] + "/BankServer"; 
			BankIntf bankintf = (BankIntf)Naming.lookup(bankserverURL); 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("\nWelcome to the Distributed Banking System!\n");
			System.out.println("\nPlease enter your username:"); 
			String s = br.readLine(); 
			System.out.println("\nPlease enter your account number:"); 
			int ac = Integer.parseInt(br.readLine()); 
			System.out.println("\nPlease enter the initial amount of money you have in your back account (in dollars):"); 
			System.out.print("$");
			int amt = Integer.parseInt(br.readLine());
			System.out.println(""); 
			do 
			{ 
				System.out.println("Please select one of the following 4 options:");
				System.out.println("\n\t1. Withdraw\n\t2. Deposit\n\t3. Balance\n\t4. Exit");	
				System.out.println("\nPlease enter your desired option number: "); 
				ch = Integer.parseInt(br.readLine()); 

				switch(ch) 
				{ 
					case 1: 
						System.out.println("\nPlease enter the amount you would like to withdraw (in dollars):");
						System.out.print("$"); 
						int wd = Integer.parseInt(br.readLine()); 
						System.out.println("\nUsername: \t\t" + s); 
						System.out.println("Account Number: \t" + ac);
						if(wd>amt) 
							System.out.println("\n--> Insufficient funds detected - unable to process withdrawal.");
						else 
						{ 
							amt = bankintf.withdraw(wd,amt); 
							System.out.println("\n--> New account balance: $" + amt); 
						} 
						System.out.println("");
						break; 

					case 2: 
						System.out.println("\nPlease enter the amount you would like to deposit (in dollars)"); 
						System.out.print("$");
						int dp = Integer.parseInt(br.readLine()); 
						System.out.println("\nUsername: \t\t" + s); 
						System.out.println("Account Number: \t" + ac); 
						amt = bankintf.deposit(dp,amt); 
						System.out.println("\n--> New account balance: $" + amt); 
						System.out.println("");
						break; 

					case 3: 
						System.out.println("\nUsername: \t\t" + s); 
						System.out.println("Account Number: \t" + ac); 
						amt = bankintf.balance(amt); 
						System.out.println("\n--> Your current balance is: $" + amt); 
						System.out.println("");
						break; 

					case 4:
						System.out.println("\nThank you for using the Distributed Banking System.");
						System.out.println("We hope you enjoyed your banking experience. Enjoy your day!");
						System.exit(0);
						break;						
				} 
			}
			while(ch<4); 
		}
		catch(Exception e) 
		{ 
			System.out.println("Exception : " + e); 
		} 
	} 
} 