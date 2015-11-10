package duke2;

import org.apache.commons.csv.*;
/**
 * find the most popular baby name in given year in U.S.A
 * 
 * @author Gloria
 * @version Nov 8 2015
 * 
 */

import edu.duke.*;

public class BabyBirths {
	public void printNames(){
		FileResource fr = new FileResource();
		for(CSVRecord rec : fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(rec.get(2));
			if(numBorn <= 100){		
			System.out.println(" Name " + rec.get(0)+ 
								" Gender " + rec.get(1)+
								" Num Born " + rec.get(2));
			}
		}
	}
	public void totalBirths(FileResource fr){
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for(CSVRecord rec : fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if(rec.get(1).equals("M")){
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = "+totalBirths);
		System.out.println("total girls = "+ totalGirls);
		System.out.println("total boys  =" + totalBoys);
	}
	public void readOneFile(int year){
		String fname = "data/yob" + year + ".txt";
		FileResource fr = new FileResource(fname);
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord rec : parser){
			String name = rec.get(0);
			String gender = rec.get(1);
		}
	}

}
