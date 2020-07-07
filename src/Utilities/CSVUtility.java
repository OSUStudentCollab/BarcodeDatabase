package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
			//Get the top-most "header" element from CSV file
			headerText = textReader(CSVFileLocation).nextLine();
		}
		
		//Return header information
		return fillArray(headerText, 1 + countCharacters(headerText, ','));
	}
	
	/**
	 * Take a csv file, search for a specific element and return all information on that line
	 *
	 * @param size            Size of array, i.e data points in a given row
	 * @param columnToSearch  Column to look in
	 * @param dataToLookFor   Data point to look for
	 * @param CSVFileLocation Location of file to read
	 * @return An array containing elements from a row matching the columnToSearch and dataToLookFor; Returns an empty
	 * array if no such element is found
	 */
	public static String[] readSpecificRow(int size, int columnToSearch, String dataToLookFor, String CSVFileLocation)
	{
		String[] data = new String[size];
		Scanner csvToSearch = textReader(CSVFileLocation);
		
		
		while (csvToSearch.hasNext())
		{
			//Read the next line in the csv file
			String rowData = csvToSearch.nextLine();
			
			//Check if element in this row matches search criteria
			String dataFound = readColumnnFromCSVFormat(rowData, columnToSearch);
			if (dataFound.equals(dataToLookFor))
			{
				data = fillArray(rowData, data.length);
				break;
			}
		}
		
		return data;
	}
	
	/**
	 * Look for the first instance of searchTerm in array
	 *
	 * @param array      Array to search
	 * @param searchTerm Term to look for
	 * @return Index of searchTerm in array; -1 if searchTerm is not in array
	 */
	public static int positionOfElementInArray(String[] array, String searchTerm)
	{
		return Arrays.asList(array).indexOf(searchTerm);
	}
	
	/**
	 * Takes a csv string and returns an array separating the data from the csv string
	 *
	 * @param csvText CSV formatted String
	 * @param size    Size of array, must match size of CSV string
	 * @return An array containing data from csvText
	 */
	private static String[] fillArray(String csvText, int size)
	{
		String[] array = new String[size];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = readColumnnFromCSVFormat(csvText, i);
		}
		
		return array;
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
