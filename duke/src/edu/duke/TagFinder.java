package edu.duke;

public class TagFinder {
	public String findProtein(String dna){
		/*
		String value = "cats and dog";
		String value2 = "dukeprogramming";
		System.out.println("dukeprogramming");
        System.out.println("012345678901234");
      
		// Take substring of first three letters.
		String cat = value.substring(0, 3);
		System.out.println(cat);

		// Take substring of three letters.
		// ... Indexes based on value length.
		String dog = value.substring(value.length() - 4,
			value.length() - 1);
		System.out.println(dog);
		System.out.println("******************");
		System.out.println("length" + value2.length());
	    System.out.println("indexOf" + value2.indexOf("program"));
	    System.out.println("g :" + value2.indexOf("g"));
        System.out.println("f :" + value2.indexOf("f"));
        // search occurrence of "g" after 8 = 14
        System.out.println("g after 8" + value2.indexOf("g", 8));
        System.out.println("startsWith :" + value2.startsWith("duke"));
        System.out.println("endsWith :" + value2.endsWith("king"));
        System.out.println("substring(a,b) : a ~ b-1 or b-a length" + value2.substring(4, 7));
        */
		int start = dna.indexOf("atg");
		if(start == -1){
			return "";  // no start codon found
		}
		// start of "tga" string after start+3  
		int stop = dna.indexOf("tga", start+3);
		if((stop - start) %3 == 0){
			return dna.substring(start, stop+3);
		}
		else {
			return "";
			}
	   }
	   public void testing() {
//		   String a = "cccatggggtttaaataataatgagagagagagagagagagttt";
//		   String a1= "01234567890123456789012345678901234567890123";       
//		   String ap = "atggggtttaaataataatga";
		   String a = "atgcctag";
		   String ap = "";
		   String result = findProtein(a);
		   if (ap.equals(result)){
			   System.out.println("success for " + ap + "length " + ap.length());
		   }
		   else {
			   System.out.println("mistake for input : "+a);
			   System.out.println("got"+ result);
			   System.out.println("not"+ ap);
			   
		   }
	   }

}
