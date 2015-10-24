package edu.duke;

import java.io.File;

public class GrayScaleConverterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    GrayScaleConverter gs = new GrayScaleConverter();
    DirectoryResource dr = new DirectoryResource();
	for(File f : dr.selectedFiles()){
		ImageResource inImage = new ImageResource(f);
		ImageResource gray = gs. makeGray(inImage);
		gray.draw();
	   }
	}
}
