
/*
* We must pass both of the conditions in order to have a POJO
* 1. All Instance Variables must have private access
* 2. All Instance Variables must have public getter and setter methods
*/

/** User Class is a POJO (Model Class) that will store the information that will be read from the file.
The User POJO should contain three properties: 1. username,  2. password,  3. name */

public class User
{
	// POJO Condition1: Declaring Instance Variables with private access (Only the User Class can see these variables)
	private String username; private String password; private String name;
	
	// POJO Condition2: Public Getter & Setter methods for all the Privately Specified Instance Variables
	
	//2.1 Public Getter & Setter methods for the Instance variable called username
	public String getUsername() // Getter Method for allowing external classes outside of the User Class to get the state of the Instance Variable 
	{
		return this.username;
	}
	public void setUsername(String username) // Setter Method for allowing external classes outside of the User Class to change the state of the Instance Variable
	{
		this.username = username;
	}
	
	//2.2 Public Getter & Setter methods for the Instance variable called password
	public String getPassword() // Getter Method for allowing external classes outside of the User Class to get the state of the Instance Variable 
	{
		return this.password;
	}
	public void setPassword(String password) // Setter Method for allowing external classes outside of the User Class to change the state of the Instance Variable
	{
		this.password = password;
	}
	
	//2.3 Public Getter & Setter methods for the Instance variable called name
	public String getName()  // Getter Method for allowing external classes outside of the User Class to get the state of the Instance Variable 
	{
		return this.name;
	}
	public void setName(String name) // Setter Method for allowing external classes outside of the User Class to change the state of the Instance Variable
	{
		this.name = name;
	}
	
}