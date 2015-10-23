package edu.duke;

public class GrayScaleConverterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    GrayScaleConverter gs = new GrayScaleConverter();
    ImageResource ir = new ImageResource();
    ImageResource testIr = gs.makeGray(ir);
   
    testIr.draw();
	}

}
