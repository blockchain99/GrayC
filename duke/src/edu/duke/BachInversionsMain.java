package edu.duke;
import edu.duke.*;
import java.io.*;

public class BachInversionsMain {

	public static void main(String[] args) {
//		FileResource fr = new FileResource();
    	
    	DirectoryResource dr = new DirectoryResource();
    	// for each file in directory as a selected file 
    	for(File f : dr.selectedFiles()){
    	//I built a new ImageResource "inputImage" from ImageResource of file "f" 	
    		ImageResource inputImage = new ImageResource(f);
    	// I built new object from BatchInversions class	
    		BatchInversions bi = new BatchInversions();	
    	    ImageResource inverted = bi.makeInversion(inputImage); 	
    		inverted.draw();
    		String resultName = "inveted-" + inputImage.getFileName();
    		inverted.setFileName(resultName);
    		inverted.save();
    		System.out.println(resultName);
    	}
		
	}

}
