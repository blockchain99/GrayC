package edu.duke;
import java.io.*;
public class GrayScaleConverter {
 // FileResource : lines() words() asString()
 // GrayScaleConverter : 	
 // URLResource  : lines() words() asString()
 // ImageResource: getWidth() getHeight() pixels() getPixel() draw() save()  setFileName() getFileName() 
 // DirResource  : selectedFiles()
 // File
 // Pixel        : getX() getY() getRed() getBlue() getGreen() setRed() setBlue() setGreen()
	
	//I started with the image I wanted (inImage)
		public ImageResource makeGray(ImageResource inImage){
			// I made a blank image of the same size
			ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
			//for each pixel in outImage
			for(Pixel pixel : outImage.pixels()){
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//compute inPixel's red + inPixel's blue + inPixel's green
			int totalPixel = inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen();
			// divide that sum by 3 (call it average)
			int avgPixel =(int)(totalPixel/3.0);
			// int avgPixel = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			
			// set pixel's red to average
				  pixel.setRed(avgPixel);
			// set pixel's green to average
				  pixel.setGreen(avgPixel);
			// set pixel's blue to average	
				  pixel.setBlue(avgPixel);
			}
		// outImage is your answer
			return outImage;
		}
		/*
		public void selectAndConvert(){
			DirectoryResource dr = new DirectoryResource();
			for(File f : dr.selectedFiles()){
				ImageResource inImage = new ImageResource(f);
				ImageResource gray = makeGray(inImage);
				gray.draw();
			}
			
		} */
	}
