package edu.duke;
import edu.duke.*;

public class HelloWorld {
	public void sayHello () {
		URLResource res = new URLResource("http://nytimes.com");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}
}
