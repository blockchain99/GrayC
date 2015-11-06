package duke2;
import java.io.File;

import org.apache.commons.csv.*;

import edu.duke.*;
public class FindHighTemp {
	/*
	public void findHigh(CSVParser parser, Double intialTemp){	// 1)
		Double largestSoFar = intialTemp;
		for(CSVRecord record : parser){
		String temp = record.get("TemperatureF");
		Double tempDouble = Double.parseDouble(temp);
		if(tempDouble > largestSoFar ){
			largestSoFar = tempDouble;
		}
		}
		System.out.println("Highest temperature is "+ largestSoFar);
	}
	*/
	//  TODO..incorrect output
	//public void hindHigh(CSVParser parser)   // 2)
	//public double findHigh(CSVParser parser)  // 3)
	public CSVRecord findHigh(CSVParser parser){	
		//start with largesSoFar as nothing
		CSVRecord largestSoFar = null;
		Double doubleLargest= 0.0;
		Double doubleTemp= 0.0;;
		String strTemp= null;
		String strLargest= null;
		//For each row (currentRow) in the CSV File		
		for(CSVRecord record : parser){
			/* If lagestSoFar is nothing  */
			if(largestSoFar == null){
				//Update largesSoFar to be currentRow
				largestSoFar = record;
			}
			//Otherwise
			else{
				strTemp = record.get("TemperatureF");
				doubleTemp = Double.parseDouble(strTemp);
				strLargest =  largestSoFar.get("TemperatureF");
				doubleLargest = Double.parseDouble(strLargest);
				//Check if cucrrentRow's temperature > lagestSoFar's
				if(doubleTemp >doubleLargest){
					/*If so update larestSoFar to currentRow  */
					// doubleLargest = doubleTemp;  //3)
					largestSoFar = record;
				}
			}
	       }
		//System.out.println("Highest temperature is "+ doubleLargest);  //2)
		// return doubleLargest;   // 3)
		  return largestSoFar;
	}
	
	public CSVRecord hottestInManyDays(){
		CSVRecord largestSoFar = null;
		Double doubleLargest= 0.0;
		Double doubleTemp= 0.0;;
		String strTemp= null;
		String strLargest= null;
		// DirectoryResource class provides the blueprint for object "dr",which is created from a class "DirectoryResource"
		DirectoryResource dr = new DirectoryResource();
		//iterate over files
		// for each files which are selected from directory
		for(File f : dr.selectedFiles()){
			//creat fileResource class's object from file "f"
			FileResource fr = new FileResource(f);
			// use method to get larest in file.
//			CSVParser parser = fr.getCSVParser();
//			CSVRecord largest = findHigh(parser);
			CSVRecord recordCSV = findHigh(fr.getCSVParser());  // just 1 line for above 2 lines
			if(largestSoFar == null){
				largestSoFar = recordCSV;
			}
			else {
				strTemp = recordCSV.get("TemperatureF");
				doubleTemp = Double.parseDouble(strTemp);
				strLargest =  largestSoFar.get("TemperatureF");
				doubleLargest = Double.parseDouble(strLargest);
				//Check if cucrrentRow's temperature > lagestSoFar's
				if(doubleTemp >doubleLargest){
					/*If so update larestSoFar to currentRow  */
					// doubleLargest = doubleTemp;  //3)
					largestSoFar = recordCSV;
					}
				}
		   }
			//System.out.println("Highest temperature is "+ doubleLargest);  //2)
			// return doubleLargest;   // 3)
			 return largestSoFar;
		}
	
	public CSVRecord hottesHourInFile(CSVParser parser){
		//start with largestSoFar as nothing
		CSVRecord largestSoFar1 = null;
		//for each row(recordC) in the  CSV File
		for(CSVRecord recordC : parser){
			largestSoFar1 = getLargestOfTwo(recordC, largestSoFar1);	
		}
		//The largestSoFar is the answer
		return largestSoFar1;
	}
	
	public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord largestSoFar){
		//If largestSoFar is  nothing
		if(largestSoFar == null){
			largestSoFar = currentRow;
		}
		else {
			double currentD = Double.parseDouble(currentRow.get("TemperatureF"));
			double largestD     = Double.parseDouble(largestSoFar.get("TemperatureF"));
			if(currentD > largestD){
				largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}
	
	public void whatfindHigh(){
		FileResource fr = new FileResource();
		//make CSV parsed object from file transformed to CSV(by getCSVParser())
		CSVParser parser = fr.getCSVParser();
		//findHigh(parser, 0.0);  //1)
		//findHigh(parser);       //2)
		//System.out.println("Highest temperature is "+findHigh(parser));   //3)
		System.out.println("Highest temperature is "+findHigh(parser).get("TemperatureF"));
	}
	// using return "CSVRecord largestSoFar" 
	public void testHottesInDay(){
		FileResource fr = new FileResource("c:\\data\\2015\\weather-2015-01-01.csv");
//		CSVParser parser = fr.getCSVParser();
//		CSVRecord largest = findHigh(parser);
		CSVRecord largest = findHigh(fr.getCSVParser());   // above 2 lines goes just this one line.
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				" at " + largest.get("TimeEST"));
	}
	public void testHottesInManyDays(){
		CSVRecord largest = hottestInManyDays();  
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				" at " + largest.get("DateUTC"));
	}
	public void testHottesHourInFile(){
		FileResource fr4 = new FileResource();
		CSVParser parser4 = fr4.getCSVParser();
		CSVRecord largest = hottesHourInFile(parser4);   
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				" at " + largest.get("DateUTC"));
	}
}
