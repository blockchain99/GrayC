package edu.duke;

public class AssFAGen {
	/**
	 * To find the first gene, find the start codon ATG.
 	 * Next look immediately past ATG for the first occurrence of each of the three stop codons TAG, TGA, and TAA.
	 * If the length of the substring between ATG and any of these three stop codons is a multiple of three, 
	 * then a candidate for a gene is the start codon through the end of the stop codon.
	 * If there is more than one valid candidate, the smallest such string is the gene.
	 * The gene includes the start and stop codon.
	 * If no start codon was found, then you are done.
	 * If a start codon was found, but no gene was found, 
	 * then start searching for another gene via the next occurrence of a start codon 
	 * starting immediately after the start codon that didn't yield a gene.
	 * If a gene was found, then start searching for the next gene immediately after this found gene.
	 */
	
	String finalReturn = null;
	
	public int findStopIndex2(String dna, int index2){
		int stop1 = 0;
		int stop2 = 0;
		int stop3 = 0;
		int stop11 = dna.indexOf("TAG",(index2));
		System.out.println("TAG index : "+ (index2));
		System.out.println("TAG stop11 : "+ stop11);
		if(stop11 == -1 || (stop11 - (index2)) % 3 != 0 ){
			stop1 = dna.length();
		}
		else {
			stop1 = stop11;
		}
		System.out.println("stop1 : " + stop1);
		
		int stop22 = dna.indexOf("TGA", (index2));
		System.out.println("dna : " + dna);
		System.out.println("TGA index : "+ (index2));
		System.out.println("before if, stop22 : " + stop22);
		System.out.println("(stop22-index)%3 : "+ (stop22 - (index2))%3);
		if(stop22 == -1 || (stop22 - (index2)) % 3 != 0){
			stop2 = dna.length();
		}
		else {
			stop2 = stop22;
		}
		System.out.println("stop2 : " + stop2);
		
		int stop33 = dna.indexOf("TAA", (index2));
		System.out.println("TAA index : "+ stop33);
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
/**
 *  printAll that has one parameter dna, a String of DNA. 
 *  print all the genes it finds in DNA. 
 *  repeatedly look for a gene, and if it finds one, print it 
 *  and then look for another gene. This method should call findStopIndex2.
 **/
//	public String printAll2(String dna) {
	public void printAll2(String dna){	
		  int startFindAll = 0;
		
			while(true){
				    int loc = dna.indexOf("ATG", startFindAll);
				  
				    System.out.println("ATG start at : "+ loc);
				    startFindAll = loc +3;
				    System.out.println("startFindAll before : "+startFindAll);
					int returnFindStopIndex2 = findStopIndex2(dna, startFindAll);
				    System.out.println("returnFindStopIndex : " + returnFindStopIndex2);
				    {
				    if(returnFindStopIndex2 != 12){
				    String resultString = dna.substring(loc,(returnFindStopIndex2+3));
				    System.out.println("findStopINdex2() result : " + resultString); 
				    }
				    else {
				    	System.out.println("no gene found ");
				    }
				    }
				    	
			if(loc == -1){
			break;
		    }   
			    System.out.println("loc " +loc);
			  //  startFindAll = loc +3;
			    System.out.println("startFindAll after : "+startFindAll);
	    }	
	} 
	
	
/**  
 *  testFinder that will use the two small DNA example strings shown below.
 *   For each string, it should print the string, 
 *   and then print the genes found in the string
 **/
	public void testingAssFAGen() {
		   String am2 = "ATGAAATGAAAA";
		   String am33= "012345678901";
		   String apm2 = "ATGAAATGA";
	//	   String result2 = printAll2(a2);
		   /*
		   if (ap2.equalsIgnoreCase(result2)){
			   System.out.println("Success : Gene found ! ");
			   System.out.println("DNA string is: " + a2);
			   System.out.println("Gene found is " + ap2);
		   }
		   else {
			   System.out.println("mistake for input : "+a2);
			   System.out.println("got "+ result2);
			   System.out.println("not "+ ap2);
			   
		   }
		   */
		   printAll2(am2);
		   
	   }
	// If not Captital, error , so changed to Capital letter 
	public void test2(){
		   String ax2 = "ccatgccctaataaatgtctgtaatgtaga";
		   String ax2C= "CCATGCCCTAATAAATGTCTGTAATGTAGA";
		   String ax2CT="012345678901234567890123456789";
		   String apx2 = "atgccctaa";
		   String apx2C= "ATGCCCTAA";
		   String apx2CT="012345678";
		   String apx3 = "atgtctgtaatgtag";
		   String apx3C= "ATGTCTGTAATGTAG";
		   String apx3c= "012345678901234";
		   System.out.println("********************");
		   printAll2(ax2C);
	}
}
