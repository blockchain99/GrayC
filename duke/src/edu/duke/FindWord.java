package edu.duke;

public class FindWord {
	FileResource frFW = new FileResource("c:\\srcj\\animals.txt");
	//StorageResource class provides methods for storing and accessing a list of strings of any length. 
	//Generally you will start by creating an empty StorageResource, 
	//then adding string values as you find them in a file or web page:
	StorageResource store = new StorageResource("c:\\srcj\\animalsRes.txt");
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
	public StorageResource getWords() {
		for(String w : frFW.words()){
			store.add(w);
		}
		return store;
	}
   public void testGetWords(){
	   for(String item : store.data()){
		   System.out.println("stored StorageResource size : " + store.size());
		   if(item.contains("fear")){
			   System.out.println("found : " + item);
		   }
		   else{
			   System.out.println("There is no word \"fear\" ");
		   }
			   
		   }
	   store.add("fear");
	   store.add("fear");
	   System.out.println("store size after add(): " + store.size());
	   store.clear();
	   System.out.println("store size after clear: " + store.size());
	   }
   }

