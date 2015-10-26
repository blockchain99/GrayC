package edu.duke;
//import edu.duke.*;
import java.io.File;

public class ImageSaver {
	public void doSave(){
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()){
			ImageResource image = new ImageResource(f);
			image.draw();
			image.setFileName("copy-"+image.getFileName());
			image.save();
		// String fName = image.getFileName();
		// String newName = "copy-" + fName;
		// image.setFileName(newName);
		// image.draw();
		// image.save();	
		}
	}
}
