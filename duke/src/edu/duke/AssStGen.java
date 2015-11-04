package edu.duke;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class AssStGen {
String finalReturn = null;
FileResource fiSource = new FileResource("c:\\srcj\\brca1line.fa");
String source = fiSource.asString();
StorageResource stSource = new StorageResource("c:\\srcj\\brca1line.fa");	


	public int findStopIndex3(String dna, int index2){
		int stop1 = 0;
		int stop2 = 0;
		int stop3 = 0;
	//	String filePath = "c:\\srcj\\out.txt";
		int stop11 = dna.indexOf("tag",(index2));
		System.out.println("TAG index2 : "+ (index2));
		System.out.println("TAG stop11 : "+ stop11);
		System.out.println("(stop11-index2)%3 : "+ (stop11 - (index2))%3);
		if(stop11 == -1 || (stop11 - (index2)) % 3 != 0 ){
			stop1 = dna.length();
		}
		else {
			stop1 = stop11;
		}
		System.out.println("stop1 : " + stop1);
		
		int stop22 = dna.indexOf("tga", (index2));
		//System.out.println("dna : " + dna);
		System.out.println("TGA index2 : "+ (index2));
		System.out.println("before if, stop22 : " + stop22);
		System.out.println("(stop22-index2)%3 : "+ (stop22 - (index2))%3);
		if(stop22 == -1 || (stop22 - (index2)) % 3 != 0){
			stop2 = dna.length();
		}
		else {
			stop2 = stop22;
		}
		System.out.println("stop2 : " + stop2);
		
		int stop33 = dna.indexOf("taa", (index2));
		System.out.println("TAA index2 : "+ stop33);
		System.out.println("(stop33-index2)%3 : "+ (stop33 - (index2))%3);
		if(stop33 ==-1 || (stop33 - (index2)) % 3 != 0){
			stop3 = dna.length();
		}
		else {
			stop3 = stop33;
		}
		System.out.println("stop3 : "+ stop3);
		System.out.println("findStopIndex2() return value : "+Math.min(stop1, Math.min(stop2,stop3)));
		return Math.min(stop1, Math.min(stop2,stop3));
		
	}
/**find all the genes in a DNA string and then store them using the StorageResource class
 *  printAll that has one parameter dna, a String of DNA. 
 *  storing all the genes it finds in DNA. 
 *  repeatedly look for a gene, and if it finds one, store it 
 *  and then look for another gene. This method should call findStopIndex2.
 **/
//create and return a StorageResource containing the genes found.
	public StorageResource storeAll(){	
		  int startFindAll = 0;
		
		  
			while(true){
				    int loc = source.indexOf("atg", startFindAll);
				    System.out.println("size of file ************ " + source.length() );  //TODO
				    System.out.println("ATG start at : "+ loc);
				    if(loc == -1){
						break;
		    }  
				    startFindAll = loc +3;
				    System.out.println("startFindAll before : "+startFindAll);
					int returnFindStopIndex2 = findStopIndex3(source, startFindAll);
				    System.out.println("returnFindStopIndex : " + returnFindStopIndex2);
				    {
				    if(returnFindStopIndex2 != source.length()){
				    String resultString = source.substring(loc,(returnFindStopIndex2+3));  
				    System.out.println(resultString);
				    stSource.add(resultString);
				    }
				    else {
				    	System.out.println("no gene found ");
				    }
				    }
				    	
		 
			 //  System.out.println("break ************" );
			  
	    }	
		//	System.out.println(stSource);
			return stSource;
	}
	/*
	 * Write a big list of Strings to a file - Use a BufferedWriter
	 */
	
	public static void useBufferedFileWriter(Iterable<String> iterable, String filepath){
		File file = new File(filepath);
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			// Write the lines on by one
			for (String line : iterable) {
				line += System.getProperty("line.separator");
				bufferedWriter.write(line);
			}
		} catch (IOException e){
			System.err.println("Error writing the file : ");
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null && fileWriter != null){
				try {
					bufferedWriter.close();
					fileWriter.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		
		
	}

	// reads in the file brca1line.fa, which is a large string of DNA 
	//and calls storeAll to find and store all the genes in this large strand of DNA. 
	//It then prints the number of genes found. 
	public void testStorageFinder(){
		AssStGen asstg = new AssStGen();	
		StorageResource stores = asstg.storeAll();
		asstg.useBufferedFileWriter(stores.data(), "c:\\srcj\\out.txt");
	    
		System.out.println("The found gen is as follows *******************");
		for(String str : stores.data()){
			System.out.println(str);
		}
		
		System.out.println("Stored size : " + stores.size());
	}
}
