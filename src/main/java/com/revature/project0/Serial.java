package com.revature.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Account;

public class Serial<G> {

	public void SerDesObject(G o) {
		try {
	         FileOutputStream fileOut = new FileOutputStream("account.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(o);
	         out.close();
	         fileOut.close();
	         System.out.printf("\nSerialized object is saved in account.txt");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		try {
	         FileInputStream fileIn = new FileInputStream("account.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         o = (G) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("\nAccount class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("\nDeserialized Account:");
	      System.out.println(((Account)o).toString());
	   }
	
}
