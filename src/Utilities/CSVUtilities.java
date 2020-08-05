package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		return fillArrayFromText(headerText, 1 + countCharacters(headerText, ','));
	}
	
	/**
	 * Take a csv file, search for a specific element and return all information on that line
	 *
	 * @param headerSize      Size of array, i.e data points in a given row
	 * @param columnToSearch  Column to look in
	 * @param dataToLookFor   Data point to look for
	 * @param CSVFileLocation Location of file to read
	 * @return An array containing elements from a row matching the columnToSearch and dataToLookFor; Returns an empty
	 * array if no such element is found
	 */
	public static String[] readSpecificRowFromFile(int headerSize, int columnToSearch, String dataToLookFor, String CSVFileLocation)
	{
		String[] data = new String[headerSize];
		Scanner csvToSearch = textDocAsScanner(CSVFileLocation);
		
		while (csvToSearch.hasNext())
		{
			//Read the next line in the csv file
			String rowData = csvToSearch.nextLine();
			
			if (readRowFromCSVFormat(rowData, columnToSearch).equals(dataToLookFor))
			{
				data = fillArrayFromText(rowData, data.length);
				break;
			}
		}
		
		csvToSearch.close();
		return data;
	}
	
	/**
	 * Take a list and search through the array for the element the user is searching for
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
			if (readRowFromCSVFormat(item, columnToSearch).equals(dataToLookFor))
			{
				data = fillArrayFromText(item, data.length);
				break;
			}
		}
		
		return data;
	}
	
	/**
	 * Modify a line in an existing CSV file
	 *
	 * @param lineNumber    Line to replace (Lines start at 0)
	 * @param newData       New data
	 * @param locationOfCSV CSV file to modify
	 */
	public static void replaceLineInCSVFile(int lineNumber, String newData, String locationOfCSV)
	{
		//Read the csv file
		List<String> csv = Utilities.textDocAsList(locationOfCSV);
		csv.set(lineNumber, newData);
		
		try
		{
			Files.write(Paths.get(locationOfCSV), csv);
		} catch (IOException e)
		{
			System.err.println("Could not save to csv location : replaceLineFromList");
		}
	}
	
	/**
	 * Modify a line in a list
	 *
	 * @param lineNumber Line to replace (Lines start at 0)
	 * @param newData    New data
	 */
	public static void replaceLineInList(int lineNumber, String newData, List<String> csv)
	{
		csv.set(lineNumber, newData);
	}
	
	/**
	 * Add a line to an existing CSV file
	 *
	 * @param locationOfCSV Location of file to write to
	 * @param information   Information to append to CSV file
	 */
	public static void appendNewDataToFile(String locationOfCSV, String[] information)
	{
		FileWriter fileToAppendTo = Utilities.textDocAsFileWriter(locationOfCSV);
		
		try
		{
			fileToAppendTo.write("\n" + Utilities.arrayToString(information, ','));
		} catch (IOException e)
		{
			System.err.println("Error writing to file : appendNewData");
		}
		
		try
		{
			fileToAppendTo.close();
		} catch (IOException e)
		{
			System.err.println("Could not close file : appendNewData");
			return;
		}
	}
	
	/**
	 * Add a line to a csv list
	 *
	 * @param information Data to append
	 * @param csv CSV in list format
	 */
	public static void appendNewDataToList(String[] information, List<String> csv)
	{
		csv.add(Utilities.arrayToString(information, ','));
	}
	
	/**
	 * Takes a csv string and returns an array separating the data from the csv string
	 *
	 * @param csvText CSV formatted String
	 * @param size    Size of array, must match size of CSV string
	 * @return An array containing data from csvText
	 */
	private static String[] fillArrayFromText(String csvText, int size)
	{
		return Utilities.fillArrayFromText(csvText, size, ',');
	}
	
	/**
	 * Takes one line of a CSV formatted text and returns the element at the specified column
	 *
	 * @param text         CSV Formatted text string
	 * @param columnNumber Going from 0-n the column to read
	 * @return Text stored in the columnNumber of the given CSVText
	 */
	private static String readRowFromCSVFormat(String text, int columnNumber)
	{
		return Utilities.readRowFromText(text, columnNumber, ',');
	}
	
	/**
	 * Save a csv list into a file (not appending)
	 *
	 * @param csvList List of csv data
	 * @param csvLocation Location to save to
	 */
	public static void saveListToCSVFile(List<String> csvList, String csvLocation)
	{
		try
		{
			Files.write(Paths.get(csvLocation), csvList);
		} catch (IOException e)
		{
			System.err.println("Could not save to csv location : saveListToCSVFile");
		}
	}
}
