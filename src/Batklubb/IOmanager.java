package Batklubb;

import java.util.Scanner;

public class IOmanager {
	
	public String getNameInput(){
		return readInput();
	}
	
	public String getSocNumInput(){
		return readInput();
	}
	
	public String readInput()
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		return input;
	}
}
