package edu.duke;

public class TagFinderMain {
	static String dnaEx ="atgsisgjkskdlditga";
	public static void main(String[] args){
TagFinder tf = new TagFinder();
System.out.println(tf.findProtein(dnaEx));
tf.testing();
tf.realTesting();
//tf.inputTesting();
	}
}
