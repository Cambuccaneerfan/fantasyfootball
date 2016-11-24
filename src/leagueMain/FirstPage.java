package leagueMain;
import java.util.Scanner;

public class FirstPage {
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		
		do{
			System.out.println("");
			System.out.println("~~~Fantasy Football~~~");
			System.out.println("");
			System.out.println("---Main Menu---");
			System.out.println("");
			System.out.println("1 - Create a new League");
			System.out.println("2 - Continue saved League");
			System.out.println("3 - Exit");
			
			while(!keyboard.hasNextInt()) // ask again if anything other than an integer is entered
		    {
				keyboard.next();
		        System.out.println("");
		        System.out.println("~~~Fantasy Football~~~");
		        System.out.println("");
		        System.out.println("---Main Menu---");
		        System.out.println("");
		        System.out.println("1 - Create a new League");
		        System.out.println("2 - Continue saved League");
		        System.out.println("3 - Exit");
		    }
			
			choice = keyboard.nextInt();
		} while (choice < 1 || choice > 3); 
		
		if (choice == 1)
		{
			CreateLeague.main(args);
		}
		if (choice == 2)
		{
			ManageTeam.main(args);
		}
		if (choice == 3)
		{
			System.exit(0);
		}
		
		if(keyboard != null) 
	    {
			keyboard.close();
	    }
	}
}