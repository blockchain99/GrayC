package edu.duke;

import java.io.File;
import java.util.Scanner;

public class AssFindGen {
	
	
	private String returnStop;
	private String stopCodon;
	//	public AssFindGen(){}
	public String findProtein2(String dna2) {	
	
	int start2 = dna2.indexOf("ATG");
	if(start2 == -1){
		return "";  // no start codon found
	}
	int stopTAG = dna2.indexOf("TAG", start2+3);
	int stopTGA = dna2.indexOf("TGA", start2+3);
	int stopTAA = dna2.indexOf("TAA", start2+3);
	
	if((stopTAG  - start2) %3 == 0){
		stopCodon = "TAG";
		returnStop = dna2.substring(start2, stopTAG +3);
	   }
	else if((stopTGA - start2) %3 == 0){
		stopCodon = "TGA";
		returnStop = dna2.substring(start2, stopTGA+3);
		  }
	else if((stopTAA - start2) %3 == 0){
		stopCodon = "TAA";
		returnStop = dna2.substring(start2, stopTAA+3);
		 }
	else {
	    returnStop = "";
	    }
	return returnStop;
    }
	
	public void stopCodon(){		
		System.out.println("stop codon is " + stopCodon);
	}
   
   public void testing21() {
	   String a2 = "AATGCTAGTTTAAATCTGA";
   //  String a12= "01234567890123456789012345678901234567890123";       
       String ap12 = "ATGCTAGTTTAAATCTGA";
	   
	   String result2 = findProtein2(a2);
	 
	   if (ap12.equalsIgnoreCase(result2)){
		   System.out.println("success for " + ap12 + " length:" + ap12.length());
		   stopCodon();
	   }
	   else {
		   System.out.println("mistake for input : "+a2);
		   System.out.println("got "+ result2);
		   System.out.println("not "+ ap12);   
	   }
   }
   
   public void testing22() {
	   String a2 = "ataaactatgttttaaatgt";
	   String ap2 = "atgttttaa";
	   String result2 = findProtein2(a2);
	   if (ap2.equalsIgnoreCase(result2)){
		   System.out.println("success for " + ap2 + " length:" + ap2.length());
	       stopCodon();
	   }
	   else {
		   System.out.println("mistake for input : "+a2);
		   System.out.println("got "+ result2);
		   System.out.println("not "+ ap2);
		   
	   }
   }
   
   public void testing23() {
	   String a2 = "acatgataacctaag";
	   String ap2 = "";
	   String result2 = findProtein2(a2);
	   if (ap2.equalsIgnoreCase(result2)){
		   System.out.println("success for " + ap2 + " length:" + ap2.length());
	       stopCodon();
	   }
	   else {
		   System.out.println("mistake for input : "+a2);
		   System.out.println("got " + result2);
		   System.out.println("not " + ap2);
		   
	   }
   }
   
   
   
   public void realTesting2(){
	   //FileResource words() lines() asString()
	   //DirectoryResource selectedFiles()
	   DirectoryResource dr2 = new DirectoryResource();
	   for(File f2 : dr2.selectedFiles()){
		   FileResource fr2 = new FileResource(f2);
		   String s2 = fr2.asString();
		   System.out.println("read" + s2.length() + "characters");
		   System.out.println("Genetic codon findout result is : " + findProtein2(s2));
		  
	   }
   }
   public void inputTesting2(){
	   Scanner input2 = new Scanner(System.in);
	   System.out.println("Input dna string : ");
	   String inputDna2 = input2.nextLine();
	   System.out.println("Genetic codon findout result is : " + findProtein2(inputDna2));
	   
   }
}
