package edu.duke;
import java.io.*;
import edu.duke.*;
public class DirReader {
	public void checkDir(){
	DirectoryResource dr = new DirectoryResource();
	  for(File f : dr.selectedFiles()){
		System.out.println(f);
	  }
    }
}
