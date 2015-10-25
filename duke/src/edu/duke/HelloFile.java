package edu.duke;
import java.io.*;

import edu.duke.*;
public class HelloFile {
	public void sayHelloFile(){
		FileResource fr = new FileResource("c:\\srcj\\animals.txt");
		for(String f : fr.lines()){
		System.out.println(f);
	   }
    }
}
