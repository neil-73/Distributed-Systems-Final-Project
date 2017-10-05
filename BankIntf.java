// BankIntf.java

/*
	Distributed Systems (SOFE4790) - Project Source Code
	By: Neil Ramdath
	ID: 100519195
*/

import java.rmi.*; 
public interface BankIntf extends Remote 
{ 
	int withdraw(int a,int amt)throws RemoteException; 
	int deposit(int b,int amt)throws RemoteException; 
	int balance(int amt)throws RemoteException; 
} 