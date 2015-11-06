package duke2;
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
	
}
