package edu.duke;

public class FindAll {
	private int startFindAll;
/*
	public int printAllStarts(String dna){
		startFindAll = 0;
		while(true){
			int loc = dna.indexOf("atg", startFindAll);
			if(loc == -1){
			break;
		    }
		startFindAll = loc +3;
	    }
		return startFindAll;
	}
	public void testFindAll(){
		String a = "cccatggggtttaaataataataggagagagagagagagagttt";
		int aNumber = 3 + 3;
		int resultFindAll = printAllStarts(a);
		if(aNumber == resultFindAll){
			System.out.println("Find success !");
			System.out.println("atg starts at " + (resultFindAll - 3) );
			System.out.println("next dna search starts at " + resultFindAll);	
		}
		else{
		System.out.println("As for DNA : " + a);
		System.out.println("The start position of dna :" + aNumber);
		System.out.println("is different with PrintAllStarts() result "+ resultFindAll);
	   }
    }
	*/
	public void printAllStarts(String dna){
		startFindAll = 0;
		while(true){
			int loc = dna.indexOf("atg", startFindAll);
			if(loc == -1){
			break;
		    }
		System.out.println("starts at " + loc);
		startFindAll = loc +3;
	    }
	}
	/**
	 * Find a valid stop codon in dna that occurs after index.
	 * If no vlaid stop codon found, return dna.length()
	 * @param dna is String being searched
	 * @param index is index where search starts (such as start codon position)
	 * @return index of beginning of a valid stop codon,
	 * or dna.length() if no valid codon
	 */
	public int findStopIndex(String dna, int index){
		int stop1 = dna.indexOf("ATG", index);
		if(stop1 == -1 || (stop1 - index) % 3 != 0 ){
			stop1 = dna.length();
		}
		int stop2 = dna.indexOf("TAA", index);
		if(stop2 == -1 || (stop2 - index) % 3 != 0){
			stop2 = dna.length();
		}
		int stop3 = dna.indexOf("TAG", index);
		if(stop3 ==-1 || (stop3 - index) % 3 != 0){
			stop3 = dna.length();
		}
		return Math.min(stop1, Math.min(stop2,stop3));
	}
	public void testFindAll(){
		String a = "cccatgcccatgcccatgccccatgccccatgatg";
		String b = "01234567890123456789012345678901234";
		String c = "AAAATGCTAGTTTAAATCTGAataaactatgttttaaatgt";
		int indexSet = c.indexOf("ATG");
		System.out.println("Sring dna length : " + a.length());
		FindAll fda1 = new FindAll();
			System.out.println("Find success ! starting dna positions are as follows");
			fda1.printAllStarts(a);
			if( fda1.startFindAll <= (a.length()-4)){
			System.out.println("next start dna : " + fda1.startFindAll);
			}
			else {
			System.out.println("All dna string was checked.");
			}
			System.out.println("first DNA stop codon position is " + fda1.findStopIndex(c, indexSet));
				
	}
}
