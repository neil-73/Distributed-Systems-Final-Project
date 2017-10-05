// BankServer.java

/*
	Distributed Systems (SOFE4790) - Project Source Code
	By: Neil Ramdath
	ID: 100519195
*/
	
import java.rmi.*; 
public class BankServer 
{ 
	public static void main(String args[]) 
	{ 
		try 
		{ 
			BankImpl bankimpl=new BankImpl(); 
			Naming.rebind("BankServer",bankimpl); 
			System.out.println("The server is ready..."); 
		} 
		catch(Exception e) 
		{ 
			System.out.println("Exception :"+e); 
		} 
	} 
} 

