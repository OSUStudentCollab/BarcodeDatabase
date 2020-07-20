package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static Utilities.Utilities.countCharacters;
import static Utilities.Utilities.textDocAsScanner;

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
			headerText = textDocAsScanner(CSVFileLocation).nextLine();
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
	public static String[] readSpecificRowFromFile(int size, int columnToSearch, String dataToLookFor, String CSVFileLocation)
	{
		String[] data = new String[size];
		Scanner csvToSearch = textDocAsScanner(CSVFileLocation);
		
		while (csvToSearch.hasNext())
		{
			//Read the next line in the csv file
			String rowData = csvToSearch.nextLine();
			
			if (readColumnnFromCSVFormat(rowData, columnToSearch).equals(dataToLookFor))
			{
				data = fillArray(rowData, data.length);
				break;
			}
		}
		
		csvToSearch.close();
		return data;
	}
	
	/**
	 * Take an list and search through the array for the element the user is searching for
	 *
	 * @param size           Size of array, i.e data points in a given row
	 * @param columnToSearch Column to look in
	 * @param dataToLookFor  Data point to look for
	 * @param csvList        List to check
	 * @return An array containing elements from a row matching the columnToSearch and dataToLookFor; Returns an empty
	 * * array if no such element is found
	 */
	public static String[] readSpecificRowFromList(int size, int columnToSearch, String dataToLookFor, List<String> csvList)
	{
		String[] data = new String[size];
		
		for (String item : csvList)
		{
			if (item.contains(dataToLookFor))
			{
				data = fillArray(item, data.length);
				break;
			}
		}
		
		return data;
	}
	
	/**
	 * @param locationOfCSV Location of file to read
	 * @param information   Information to append to CSV file
	 */
	public static void appendNewData(String locationOfCSV, String[] information)
	{
		FileWriter fileToAppendTo = Utilities.textDocAsFileWriter(locationOfCSV);
		
		try
		{
			fileToAppendTo.write("\n" + Utilities.arrayToString(information,","));
		} catch (IOException e)
		{
			System.err.println("Error writing to file");
		}
		
		try
		{
			fileToAppendTo.close();
		} catch (IOException e)
		{
			System.err.println("Could not close file");
			return;
		}
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
