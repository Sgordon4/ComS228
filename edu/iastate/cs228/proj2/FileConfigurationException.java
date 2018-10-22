package edu.iastate.cs228.proj2;


/**
*
* @author Sean Gordon
*
*/

public class FileConfigurationException extends Exception {
	public static final long serialVersionUID = 1L;
	
	public FileConfigurationException()
	{
		this("The file is not configured correctly");
	}
	public FileConfigurationException(String message)
	{
		super(message);
	}
}