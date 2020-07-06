package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a utility class that helps to read and write to and from a csv file
 *
 * @author Samiul
 */
public class CSVUtility
{
	
	/**
	 * Read a CSV formatted text file and return the top row header information
	 *
	 * @param CSVFileLocation Location of file to read
	 * @return An array with the header information of the csv file
	 */
	public static String[] readHeader(String CSVFileLocation)
	{
		//Header Information
		String headerText;
		
		{
			headerText = textReader(CSVFileLocation).nextLine();
		}
		
		String[] header = new String[1 + countCharacters(headerText, ',')];
		
		for (int i = 0; i < header.length; i++)
		{
			header[i] = readColumnnFromCSVFormat(headerText, i);
		}
		
		return header;
	}
	
	/**
	 * Takes one line of a CSV formatted text and returns the element at the specified column
	 *
	 * @param text         CSV Formatted text string
	 * @param columnNumber Going from 0-n the column to read
	 * @return Text stored in the columnNumber of the given CSVText
	 */
	private static String readColumnnFromCSVFormat(String text, int columnNumber)
	{
		StringBuilder element = new StringBuilder();
		int commasFound = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			//Get next character in line
			char toAppend = text.charAt(i);
			
			//Check if comma
			if (toAppend == ',')
			{
				commasFound++;
				
				//Check if we should end
				if (commasFound > columnNumber)
				{
					break;
				}
				//Erase element if wrong column
				else
				{
					element.delete(0, element.length());
				}
			}
			//Append to element if not comma
			else
			{
				element.append(toAppend);
			}
		}
		
		return element.toString();
	}
	
	/**
	 * Read text from a file
	 *
	 * @param location File location
	 * @return Text in file
	 */
	private static Scanner textReader(String location)
	{
		//Make a scanner
		Scanner scanner = null;
		
		//Read file
		try
		{
			scanner = new Scanner(new File(location));
		} catch (FileNotFoundException e)
		{
			System.err.println("File not found");
		}
		
		//Return text
		return scanner;
	}
	
	/**
	 * Count instances of characterToCount in text
	 *
	 * @param text             String to count search
	 * @param characterToCount Character to count
	 * @return Instances of characterToCount in text
	 */
	private static int countCharacters(String text, char characterToCount)
	{
		int charCount = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == characterToCount)
			{
				charCount++;
			}
		}
		
		return charCount;
	}
	
	
}
