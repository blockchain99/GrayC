package edu.duke;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class BachGrayScaleAss1Main {

	public static void main(String[] args) {
  //  BachGrayScaleAss1 bs = new BachGrayScaleAss1();
    DirectoryResource dr = new DirectoryResource();
    // for each file in directory
	for(File f : dr.selectedFiles()){
		// create the new object "bs" out of class BachGrayScaleAss1 
		BachGrayScaleAss1 bs = new BachGrayScaleAss1();
		// create new ImageResource "inImage" object from ImageResource of File f
		ImageResource inImage = new ImageResource(f);
		// assign the return value of method "makeGray" of "bs" instance as gray(ImageResource type)  
		ImageResource gray = bs.makeGray(inImage);

		gray.draw();
		gray.setFileName("gray-"+inImage.getFileName());	
		//File newF = new File(gray.getFileName());
		// gray.getName() - not correct one, don't use gray instance !
		 System.out.println("changed image is saved as attached prefixed name : ");
		 System.out.println("gray-"+inImage.getFileName());
	    
	//	System.out.println("changed image is saved as original file name : "+gray.getFileName());
    	
    	gray.save();
		
		String dirname ="c:\\srcj\\";
		File result = new File(dirname, gray.getFileName());
		// add common-io-1.3.2 jar installed in properties/java build path/ in eclipse , so FileUtils class works
		System.out.println("Write succeed ? " + result.getAbsolutePath());
		
	   }
	} 
}

