package Utilities;

import java.util.Scanner;

import static Utilities.Utilities.countCharacters;
import static Utilities.Utilities.textReader;

/**
 * This is a utility class that helps to read and write to and from a csv file
 *
 * @author Samiul
 */
public class CSVUtilities
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
	 * Takes a csv string and returns an array separating the data from the csv string
	 *
	 * @param csvText CSV formatted String
	 * @param size    Size of array, must match size of CSV string
	 * @return An array containing data from csvText
	 */
	private static String[] fillArray(String csvText, int size)
	{
		return Utilities.fillArray(csvText, size, ',');
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
		return Utilities.readColumnnFromText(text, columnNumber, ',');
	}
}
