package edu.duke;

import java.io.File;

public class GrayScaleConverterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BachGrayScaleAss1 gs = new BachGrayScaleAss1();
    DirectoryResource dr = new DirectoryResource();
	for(File f : dr.selectedFiles()){
		ImageResource inImage = new ImageResource(f);
		ImageResource gray = gs. makeGray(inImage);
		gray.draw();
		
	   }
	}
}
