package command;

import java.util.Scanner;

import main.GameClient;


public class command {
	final private static GameClient gameClient= new GameClient(); 
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String com = sc.nextLine();
			com = com.toLowerCase();
			System.out.println(com);
			if(com == "buildClient")
			{
				
			}
		}
	}
}