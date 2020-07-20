package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A utility class with a bunch of generally useful methods
 *
 * @author Samiul
 */
public class Utilities
{
	/**
	 * Count instances of characterToCount in text
	 *
	 * @param text             String to search
	 * @param characterToCount Character to count
	 * @return Instances of characterToCount in text
	 */
	public static int countCharacters(String text, char characterToCount)
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
	
	/**
	 * Read text from a file
	 *
	 * @param location File location
	 * @return Scanner containing data from a file
	 */
	public static Scanner textDocAsScanner(String location)
	{
		//Make a scanner
		Scanner scanner = null;
		
		//Initialize scanner
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
	 * Make a FileWriter capable of writing to a file at "location"
	 *
	 * @param location File location
	 * @return A writeable FileWriter
	 */
	public static FileWriter textDocAsFileWriter(String location)
	{
		//Make FileWriter
		FileWriter fw = null;
		
		//Initialize FileWriter
		try
		{
			fw = new FileWriter((new File(location)), true);
		} catch (IOException e)
		{
			System.err.println("File not found");
		}
		
		return fw;
	}
	
	/**
	 * Takes a text document and separates each line and puts it into a list
	 *
	 * @param location File location
	 * @return a List containing every line of a text document
	 */
	public static List<String> textDocAsList(String location)
	{
		Path path = Paths.get(location);
		List<String> lines = null;
		
		try
		{
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e)
		{
			System.err.println("Error reading file");
		}
		
		return lines;
	}
	
	/**
	 * Takes one line of a text document and returns the element at the specified column.
	 * Columns are determined by the specified separator character.
	 *
	 * @param text         String to read from
	 * @param columnNumber Going from 0-n (n being number of "columns" made by separators), the column to read
	 * @param separator    A character that distinguishes 1 column from another
	 * @return Text stored in the columnNumber of the given string
	 */
	public static String readColumnnFromText(String text, int columnNumber, char separator)
	{
		StringBuilder element = new StringBuilder();
		int separatorsFound = 0;
		
		for (int i = 0; i < text.length(); i++)
		{
			//Get next character in line
			char toAppend = text.charAt(i);
			
			//Check if comma
			if (toAppend == separator)
			{
				separatorsFound++;
				
				//Check if we should end
				if (separatorsFound > columnNumber)
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
	 * Takes a string and returns an array with each column in the string being an index in the array
	 *
	 * @param text      String to read from
	 * @param size      Size of array, must match columns in the given string
	 * @param separator A character that distinguishes 1 column from another
	 * @return An array containing column data from the given text
	 */
	public static String[] fillArray(String text, int size, char separator)
	{
		String[] array = new String[size];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = readColumnnFromText(text, i, separator);
		}
		
		return array;
	}
	
	/**
	 * Take an array and return a String representation of the array
	 *
	 * @param array     Array to convert
	 * @param separator Characters to put in-between each index in the array
	 * @return Indices in array as a single string
	 */
	public static String arrayToString(String[] array, String separator)
	{
		StringBuilder stringForm = new StringBuilder();
		
		for (int i = 0; i < array.length; i++)
		{
			stringForm.append(array[i]);
			
			if(i+1 < array.length)
				stringForm.append(separator);
		}
		
		return stringForm.toString();
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
}
