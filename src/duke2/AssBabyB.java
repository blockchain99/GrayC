
package duke2;

import java.io.File;

import org.apache.commons.csv.*;

import edu.duke.*;

public class AssBabyB {
	int totalNumOfRec =0;
	int totalSex1 = 0;
	int totalSex2 = 0;
	public void totalBirths(FileResource fr){
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for(CSVRecord rec : fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(rec.get(2));
			if(numBorn < 100){
				totalBirths += numBorn;
				if(rec.get(1).equals("M")){
					totalBoys += numBorn;
				}
			else {
				totalGirls += numBorn;
				}
		   }
		
	}
		System.out.println("total unique births = "+ totalBirths);
		System.out.println("total unique girls birth = "+ totalGirls);
		System.out.println("total unique boys birth =" + totalBoys);
  }
	//returns the rank of the name in the file for the given gender
	/**
	 * method named getRank that has three parameters: an integer named year, 
	 * a string named name, and a string named gender (F for female and M for male)
	 * This method returns the rank of the name in the file for the given gender, 
	 * where rank 1 is the name with the largest number of births. 
	 * If the name is not in the file, then -1 is returned. 
	 */
	public int getRank( int year, String name, String gender){
		String fname = "c:\\data\\BabyBirthsdata\\yob" + year + ".csv";
		FileResource fr = new FileResource(fname);
		String nameRec = null;
		String genderRec = null;
	//	FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);
		int rankN = 0;
//		int recordNumber = 0;
//		for(CSVRecord recT: parser){
//			recordNumber++;			
//		}
//		System.out.println("total record number " + recordNumber);
	//	while(true){
			for(CSVRecord rec : parser){
				nameRec = rec.get(0);
				genderRec = rec.get(1);
				rankN++;
				System.out.println(nameRec+" "+name+ " : "+genderRec+" "+gender);		
				
				// number returned is -1 as Mason does not appear with an F in that file : // TODO
				//	if((nameRec == name) && (genderRec == gender)){			// if(StringVar1 == StringVar2) : wrong expression	
				    if(nameRec.equals(name) && genderRec.equals(gender)){
						System.out.printf("The rank in %d , %s is %d . ", year, name , rankN);
						System.out.println();
						break;
					}
				    
				}// return shd be within while loop
					// if rankN == total record number ? if so, return -1 
//			     if(rankN ==  recordNumber)	{
//			    	return -1;
//			     }
//			     else {
//			    	 return rankN;
//			     }
			  return rankN;
	//	}
		}
	/**
	 *  This method returns the name of the person in the file at this rank, 
	 *  for the given gender, where rank 1 is the name with the largest number of births
	 *  If the rank does not exist in the file, then “NO NAME” is returned.
	 * @param year
	 * @param rank
	 * @param gender
	 * @return
	 */
	
	public String getName(int year, int rank, String gender){
		String fname = "c:\\data\\BabyBirthsdata\\yob" + year + ".csv";
		FileResource fr = new FileResource(fname);
		CSVParser parser = fr.getCSVParser(false);
		int recRank = 0;
		String recName = null;
		String recGender = null;
		while(true){
			for(CSVRecord rec : parser){
				recName = rec.get(0);
				recGender = rec.get(1);
				recRank++;
				// number returned is -1 as Mason does not appear with an F in that file : // TODO
				//	if((nameRec == name) && (genderRec == gender)){			// if(StringVar1 == StringVar2) : wrong expression	
				    if((recRank == rank)&&(recGender.equals(gender))){
						System.out.printf("The rank in %d ,  %d is %s . ", year,rank,recName);
						System.out.println();
						break;
					}
				    
				}// return shd be within while loop
					// if rankN == total record number ? if so, return -1 
//			     if(rankN ==  recordNumber)	{
//			    	return -1;
//			     }
//			     else {
//			    	 return rankN;
//			     }
			  return recName;
			}
	}
	
	/**
	 * Program determine what name would have been named if they were born in a different year,
	 * based on the same popularity. 
	 * @param name
	 * @param year
	 * @param newYear
	 * @param gender
	 * @return
	 */
	public String whatIsNameInYear(String  name, int year, int newYear, String gender){
		String newNameReturned = null;
		String newGender = null;
		String fnameOld = "c:\\data\\BabyBirthsdata\\yob" + year + ".csv";
		FileResource frOld = new FileResource(fnameOld);
		CSVParser parserOld = frOld.getCSVParser(false);
		int rank = 0;
		//determine the rank of name in the year they were born
		
			for(CSVRecord rec : parserOld){
				rank++;
				String nameRec = rec.get(0);
				String genderRec = rec.get(1);
				if((nameRec.equals(name))&& (genderRec.equals(gender))){
					System.out.println("Rank for " + nameRec + " in year " + year + " is " + rank);
					break;
				}
		    }
			   newNameReturned = nameNewYear(newYear, rank, gender);
			   System.out.println(name + "born in " + year +" would be " + newNameReturned + ", if she was born in " + newYear);
		return newNameReturned;
	}
	
	/**  // The File Name.PDF extract 
	 * String fullPath = "c:\\data\\BabyBirthsdata\\yob" + year + ".csv";
	 * int index = fullPath.lastIndexOf("\\");
	 * String year = fullPath.substring((index + 3),(index + 7));
	 * 
	 */
	
	/**
	 * whatIsNameInYear() call this method to print the name born in newYear 
	 * that is at the same rank and same gender.
	 */
	public String nameNewYear(int newYear, int rank, String gender){
		String fnameNew = "c:\\data\\BabyBirthsdata\\yob" + newYear + ".csv";
		FileResource frNew = new FileResource(fnameNew);
		CSVParser parserNew = frNew.getCSVParser(false);
		String newName = null;
		String genderNew = null;
		int rankNew = 0;
		for(CSVRecord recNew : parserNew){
			rankNew++;
			genderNew = recNew.get(1);
			if((rankNew == rank)&&(genderNew.equals(gender))){
				newName = recNew.get(0);					
			}
		}
		return newName;
	}
	
	/**
	 * selects a range of files to process and returns an integer,
	 * the year with the highest rank for the name and gender
	 *  name and gender are not in any of the selected files, it should return -1
	 * @param name
	 * @param gender
	 * @return
	 */
	public int[] yearOfHighestRank(String name , String gender){
		int yearHigh = 0;
		int returnvalue = 0;
		int smallestRankNumSoFar = 0; 	
		int yearInt = 0;
		/** whien this location return array values are 0 : failure ! so move below.
		int[] smallestRankNumSoFarArray = new int[2];
		smallestRankNumSoFarArray[0] = yearInt;
		smallestRankNumSoFarArray[1] = smallestRankNumSoFar;
		*/
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);	
			//yob1950.csv -> extract "1950"
			System.out.println("File path "+ f.getName());
			String nameStr = f.getName();
			String yearStr = nameStr.substring(3, 7);
			yearInt = Integer.parseInt(yearStr);
			System.out.println("yearStr "+ yearStr);
			CSVParser parser = fr.getCSVParser(false);
			int returnHighRank = whatRank(parser, name, gender, yearInt);
			//System.out.println("****field value : totalNumOfRec "+ totalNumOfRec );
			
			//check if smallestRankNunSoFar, At first 0, it is assigned to current File's rank by
			//total number of record("totalNumOfRec")
		
				if(smallestRankNumSoFar ==  0  ){
					smallestRankNumSoFar = returnHighRank;	
				//	System.out.println("1) : " + smallestRankNumSoFar);
				}
				// smallestRankNumSoFar !=0, i.e, from second File, 
				// check if current File's returnHighRank is less than smallestRankNumSoFar
				else {
				if(returnHighRank < smallestRankNumSoFar){
					smallestRankNumSoFar = returnHighRank;	
				//	System.out.println("2) : "+smallestRankNumSoFar);
				  }
			    } 
		}//end of for
		int[] smallestRankNumSoFarArray = new int[2];
		smallestRankNumSoFarArray[0] = yearInt;
		smallestRankNumSoFarArray[1] = smallestRankNumSoFar;
		return smallestRankNumSoFarArray;
	}
	/* Refrence : return two value
	 * public class Example
      {
    	public String name;
    	public String location;

    	public String[] getExample()
    	{
        String ar[] = new String[2];
        ar[0]= name;
        ar[1] =  location;
        return ar; //returning two values at once
    	}
			}
	 * 
	 */
	
	// return rank for record of selected File(in terms of name, gender).
	public int whatRank(CSVParser parser, String name, String gender,int yearInt){
		String nameRec = null;
		String genderRec = null;
		int rankW = 0;
	//	int totalNumOfRec = 0;  // declared as field to use in yearOfHighestRank()
	//	int totalSex1 = 0;
	//	int totalSex2 = 0;
		int returnRank = 0;	
		System.out.println("transferred name : "+name);
		System.out.println("transferred gender : "+gender);
		   
	/*  for each record of CSV parsed object calculate total record number,
	 *  each number of record with female & record with male
	 */  
		for(CSVRecord rec : parser){
			nameRec = rec.get(0);
			genderRec = rec.get(1);
			totalNumOfRec++;
			//if the value of record's gender column equals with given gender
			//if(rec.get(1).equals(gender)){
			if(genderRec.equals("M")){
				totalSex1++;
			}
			else {
				totalSex2++;
			}

		//   while(true){
			rankW++;
			
		    if(nameRec.equals(name)&& genderRec.equals(gender)){
		    	System.out.println("rankW out for loop : "+ rankW);
		    	System.out.printf("when %s %s is equal to %s %s  : ", name, gender,nameRec,genderRec ); 
		    	System.out.println();
		    	   	break;
		      }
		//   }
		 }//end of for loop
		 System.out.println("totalSex1(M) : "+ totalSex1);
		 System.out.println("totalSex2(F) : "+ totalSex2);
		 System.out.println("totalNumOfRec : " + totalNumOfRec);
		
		if(genderRec.equals("M")){
			returnRank = totalSex1;
			System.out.println("(1) male return : "+returnRank);
		}
		else{
			returnRank = totalSex2;
			System.out.println("(2) male return : "+returnRank);
		}
		
//		if(totalSex1 == rankW){ // total number of male's name == end of male name's sequence number. //NOT implemented //TODO
//			returnRank = -1;
//		}
//		else {
//			returnRank = rankW;
//		}
	
		System.out.println(" returnRank *** " + returnRank);
//		System.out.println("year is " +yearStr);
		return returnRank;      //TODO
	}
	
	double getAverageRank(String name, String gender){
		DirectoryResource dr = new DirectoryResource();
		double sumNum = 0.0;
		int count = 0;
		double avgNum = 0.0;
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser();
			double rankNum = rankForAvgRank(parser, name, gender);
			sumNum += rankNum;
			count++;
		}
		avgNum = sumNum/(double)count; 
		return avgNum; //TODO
	}
/** logic error : total rank(M + F) is shown. - need just M RANK ! 	
	private int rankForAvgRank(CSVParser parser, String name, String gender) {
		String nameRec = null;
		String genderRec = null;
	    int rankN =0;
		for(CSVRecord rec : parser){
			nameRec = rec.get(0);
			genderRec = rec.get(1);
			rankN++;
		//	System.out.println(nameRec+" "+name+ " : "+genderRec+" "+gender);		
			    if(nameRec.equals(name) && genderRec.equals(gender)){
					System.out.printf("The rank in  %s is %d . ", name , rankN);
					System.out.println();
					break;
				}
			}
		return rankN;
	}
*/	
	// return male, female-wise total rank calculation.
	// still, not implement -1 return for no name found in file.  //TODO
	private double rankForAvgRank(CSVParser parser, String name, String gender) {
		String nameRec = null;
		String genderRec = null;
		int totalNumOfRecAvg = 0;
		int totalSex1Avg = 0;
		int totalSex2Avg = 0;
	    int rankN =0;
	    int returnRankAvg =0;
	for(CSVRecord rec : parser){
		nameRec = rec.get(0);
		genderRec = rec.get(1);
		totalNumOfRecAvg++;
		if(genderRec.equals("M")){
			totalSex1Avg++;
		}
		else {
			totalSex2Avg++;
		}
	    if(nameRec.equals(name)&& genderRec.equals(gender)){
	    	System.out.printf("when %s %s is equal to %s %s  : ", name, gender,nameRec,genderRec ); 
	    	System.out.println();
	    	   	break;
	      }
	 }//end of for loop
	 System.out.println("totalSex1(M) : "+ totalSex1Avg);
	 System.out.println("totalSex2(F) : "+ totalSex2Avg);
	 System.out.println("totalNumOfRec : " + totalNumOfRecAvg);
	
	if(genderRec.equals("M")){
		returnRankAvg = totalSex1Avg;
		System.out.println("(1) male return : "+returnRankAvg);
	}
	else{
		returnRankAvg = totalSex2Avg;
		System.out.println("(2) male return : "+returnRankAvg);
	}
	
	System.out.println(" returnRank *** " + returnRankAvg);
	return returnRankAvg;    //TODO
}
	
	public void testTotalBirths(){
		FileResource fr = new FileResource();
		totalBirths(fr);
	}
	public void testGetRank(){
		System.out.println("Return value from getRank() is : rank : " + getRank(2000,"Gloria","F"));
	}
	
	public void testGetName(){
		System.out.println("Return value from getName() is : name : "+ getName(1964,4,"F" ));
	}
	public void testWhatIsNameInYear(){
		System.out.println("Return value from whatIsNameInYear() : name :" + whatIsNameInYear("Emma", 2000, 1964, "F"));
	}
	public void testYearOfHighestRank(){
		int[] result = yearOfHighestRank("Mason","M");
		System.out.println("Anser : return value from yearOfHighestRank() : year : "+ result[0]);
		System.out.println("Anser : return value from yearOfHighestRank() : rank : "+ result[1]);
	}
	public void testGetAverageRank(){
		System.out.printf("Answer : average rank for selected file is : %4.2f", getAverageRank("Jacob", "M") );
	}
}
