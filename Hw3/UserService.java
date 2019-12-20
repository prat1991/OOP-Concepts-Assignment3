import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** UserService (Controller Class) handles all the business logic of creating users, storing
username and password info into an array and checking the entered values
against the array containing the stored user and password data. */

public class UserService
{

	User[] UserDatabaseStorage = new User[4];

	/**method that creates a user 
	 and returns a user object  */
	
	public User createUser(String username, String password, String name)
	{
		User user = new User(); // object creation
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		return user;
	}

	/**method that reads the login data from a text file,
	 * stores the login data into a Users Array and returns 
	 * that Users Array */
	public User[] readFromTextFileAndStoreDataIntoAnArray()
	{
		UserService userService = new UserService(); //object creation

		BufferedReader bufferedReader = null;
		
		try // code that throws exception goes here
		{
			// Specified a relative file path for the data.txt file because the data.txt
			// is present in the root of the Hw3 Folder
			bufferedReader = new BufferedReader(new FileReader("data.txt")); // object creation
			
			//Local Variables 
			String fileLines = ""; int i = 0;

			while ((fileLines = bufferedReader.readLine()) != null)
			{
				String[] Attributes = fileLines.split(",");
				String username = Attributes[0];
				String password = Attributes[1];
				String name = Attributes[2];
				
				UserDatabaseStorage[i] = userService.createUser(username, password, name);
				// System.out.println("Database contains the following stored userlogin data: " + UserDatabaseStorage);
				i++;
			}
			System.out.println("....Successfully completed storing the login info(text file data) into the database (Array)");
		} 
		catch (FileNotFoundException e) // code that handles exception goes here
		{
			System.out.println("File Not Found Exception Occured during runtime.");
			e.printStackTrace();
		} 
		catch (IOException error)  // code that handles exception goes here
		{
			System.out.println("IO Exception Occured during runtime");
			error.printStackTrace();
		} 
		finally 
		{
			try
			{
				System.out.println(".....Successfully completed closing of the file reader as we are done with reading the text file data \n\n");
				bufferedReader.close();
			} catch (IOException error)
			{
				error.printStackTrace();
			}
		}
		return UserDatabaseStorage;
		}
	
	
	/**method that asks the user for login information and checks the entered
	 * into against a database. THis method does not have a return type */ 
	
	public void requestingAndValidatingUsersLoginData()
	{
		// Local Variables (Method Scope)
		String usernameLoginPageInput; String passwordLoginPageInput;
		int userLoginAttempts = 0; boolean isLoginMatchingTheDatabase = false;

		Scanner userInputCollector = new Scanner(System.in);		// Object Creation
		
		//--------------Design Consideration (For Loop Vs While Loop)-----------------------
		//outer for loop kept on giving me a Index out of Bound error
		// so decided to wrap the entire logic inside of a while loop
		// i dont fully understand how this solved the issue but i found it on stack overflow
		// so it must be right!
		
		//While loop handles updating the view in the User Login Console App
		while (userLoginAttempts < 5)
		{
			// skips the while loop if we find a matching login
			if (isLoginMatchingTheDatabase == true)
			{
				break;
			}
			
			//Prompting the user for login
			System.out.print("\nEnter your email to login --------> ");
			usernameLoginPageInput = userInputCollector.next();
			System.out.print("Enter your password to login ----------> ");
			passwordLoginPageInput = userInputCollector.next();

			//Checking to see if the users entered info matches the database
			for (int i = 0; i < UserDatabaseStorage.length; i++)
			{
				if (usernameLoginPageInput.equalsIgnoreCase(UserDatabaseStorage[i].getUsername()) && passwordLoginPageInput.equals(UserDatabaseStorage[i].getPassword()))
				{
					System.out.println("Welcome: " + UserDatabaseStorage[i].getName());
					isLoginMatchingTheDatabase = true;
					break; // gets out of while loop when the user enter info that matches the database
				}
			}
			//Prompting the user to login again
			if (isLoginMatchingTheDatabase == false && userLoginAttempts != 5)
			{
				System.out.println("\nInvalid login, please try again");
				userLoginAttempts++; // updating user attempts
			}
			
			// Erroring out after 5 failed attempts
			if (userLoginAttempts == 5)
			{
				System.out.println("Too many failed login attempts you are now locked out.");
			}
		}
		// closing the scanner to prevent memory leaks
		userInputCollector.close();
	}

	
	
	
}
	
