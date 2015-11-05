package duke2;
import org.apache.commons.csv.*;
import edu.duke.*;
public class FirstCSVExamle {
	public void readFood(){
	//	FileResource fr = new FileResource("c:\\srcj\\foods.csv");
		//without "c:\\srcj\\foods.csv" , file selection pop-up dialog appears.
		FileResource fr = new FileResource();
		//returns a CSVParser object for this opened file, 
		//assuming it contains comma separated values with a header row
		CSVParser parser = fr.getCSVParser();
		System.out.println("CSVRecord Name & Favorite Color is as follows.");
		for(CSVRecord record : parser){
//			System.out.println(record.get("Name"));
//			System.out.println(record.get("Favorite Color"));
			System.out.print(record.get("Name")+" : ");
			System.out.println(record.get("Favorite Color"));
		}
		//when duplicated parser1 used , no Favorite Food record result printed. 
		// so initialize CSVParser again as name of  parser1
		CSVParser parser1 = fr.getCSVParser();
		System.out.println("CSVRecord Name & Favorite Food is as follows.");
		for(CSVRecord record : parser1){
			System.out.print(record.get("Name")+" : ");
			System.out.println(record.get("Favorite Food"));
		}
	}
	public void checkExport(){
		FileResource fr = new FileResource();
		//return CSVParser object which contains csv for this opened file
		CSVParser parser2  = fr.getCSVParser();
		System.out.println("The conuntry which exports coffee are as follows. ");
		//for each row in CSV file
		for(CSVRecord record : parser2){
			//look at the "Exports" column of that row & check if it contains "coffee"
			if(record.get("Exports").contains("coffee")){
				//if so, write down the "country" from that row of the record
				System.out.println(record.get("Country"));
			}
		}
	}
	public void listExporters(CSVParser parser, String exportOfInterest){
		System.out.println("The conuntry which exports coffee are as follows(listExporters). ");
		//for each row in CSV file
		for(CSVRecord record : parser){
		//look at the "Exports" column of that row 
			String lookCol = record.get("Exports");
		//check if it contains "coffee"
			if(lookCol.contains(exportOfInterest)){
		//if so, write down the "Country" from that row of the record
				String country = record.get("Country");
			System.out.println(country);	
			}
	   }
     }
	public void countryInfo(CSVParser parser, String country){
		System.out.println("Information of countries is as follow. ");
		//for each row in csv of parser object
		for(CSVRecord record: parser){
			String lookCol = record.get("Country");
			if(lookCol.contains(country)){
				System.out.print(record.get("Country")+ " : ");
				System.out.println(record.get("Exports")+ " : ");
				System.out.println(record.get("Value (dollars)"));
			}
			else
			{
				System.out.println();
				System.out.println("NOT FOUND");
			}
			
		}
	}
	//prints the names of all the countries that have both exportItem1 and exportItem2 as export items
	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItme2){
		System.out.println("Countries export both "+ exportItem1 +" and "+ exportItme2+" are as follows");
		for(CSVRecord record : parser){
			String lookCol = record.get("Exports");
			if(lookCol.contains(exportItem1)&& (lookCol.contains(exportItme2))){
				System.out.println(record.get("Country"));
				
			}
							
		}
		
	}
	//returns the number of countries that export exportItem.
	public void numberOfExporters(CSVParser parser, String exportItem){
		System.out.println("Number of Countries export " + exportItem);
		int numberOfCountry = 0;
		for(CSVRecord record : parser){
			String lookCol = record.get("Exports");
			if(lookCol.contains(exportItem)){
				numberOfCountry++;
			}
		}
		System.out.println("Number of countries export "+ exportItem + " is "+ numberOfCountry );
	}
	// names of countries and their Value amount for all countries 
	// whose Value (dollars) string is longer than the amount string
	public void bigExporters(CSVParser parser, String amount){
		int lengthOfAmount = amount.length();
		System.out.println(" Name of Country's Value (dollars) string is longer than the amount string");
		for(CSVRecord record: parser){
			String lookCol = record.get("Value (dollars)");
			if(lookCol.length() >= lengthOfAmount){
				System.out.print(record.get("Country")+ " : ");
				System.out.println(record.get("Value (dollars)"));
			}
		}
		
	}
	public void whoExports(){
		FileResource fr3 = new FileResource();
		CSVParser parser3 = fr3.getCSVParser();
		listExporters(parser3, "coffee");
	}
	public void whatCountryInfo(){
		FileResource fr4 = new FileResource();
		CSVParser parser4 = fr4.getCSVParser();
		countryInfo(parser4, "Germany");
	}
	public void whatTwoItemCountry(){
		FileResource fr5 = new FileResource();
		CSVParser parser5 = fr5.getCSVParser();
		listExportersTwoProducts(parser5, "gold", "diamonds");		
	}
	public void numberOfCountryItem(){
		FileResource fr6 = new FileResource();
		CSVParser parser6 = fr6.getCSVParser();
		numberOfExporters(parser6, "gold");		
	}
	public void whatBigExporters(){
		FileResource fr7 = new FileResource();
		CSVParser parser7 = fr7.getCSVParser();
		bigExporters(parser7, "$999,999,999");		
	}
 }
