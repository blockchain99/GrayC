package edu.duke;

public class FindWord {
	FileResource frFW = new FileResource("c:\\srcj\\animals.txt");
	public void findWisdom(){	
		int intFW = 0;
		for(String aline : frFW.lines()){
			if (aline.contains("wisdom")){
				System.out.println(aline);
				intFW += 1;
			}
			if (intFW > 2){
				break;
			}
		}
	}
	public void printAAminals(){
			int ind = 0;
		for(String aWord : frFW.words()){
			if(aWord.startsWith("a")){
				System.out.println(aWord);
				ind += 1;
			}
			if(ind > 3){
				break;
			}
		}
	}

}
