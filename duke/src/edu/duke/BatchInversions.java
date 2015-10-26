package edu.duke;
import edu.duke.*;
import java.io.*;


//makeInversion(ImageResource inImage) { return invertedImage;}
public class BatchInversions {
	
    public ImageResource makeInversion(ImageResource inImage)
    { 
    	// I made a blank image of the same size with inImage's width and height
    	ImageResource invertedImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
    	// for each pixel in invertedImage's pixels
    	for(Pixel pixel : invertedImage.pixels()){
		//look at the corresponding pixel in inImage	
    	Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
    	
    	//In inverting an image, a pixel’s red, blue, and green components are 
    	// modified to be the exact opposite within the 0 to 255 range.
   
    	pixel.setBlue(255- inPixel.getBlue()); 
    	pixel.setGreen(255-inPixel.getGreen());
    	pixel.setRed(255-inPixel.getRed());
    	}
    	return invertedImage;
    }	
    /*
    public void addAndInvert(){
    	
    	DirectoryResource dr = new DirectoryResource();
    	for(File f : dr.selectedFiles()){
    		FileResource fr = new FileResource();
        	ImageResource ir = new ImageResource();
        	BatchInversions bi = new BatchInversions();
        	              = bi.makeInversion(inImage)
        	
    	}
    } */
}
