package edu.duke;
import java.io.*;
import java.net.URL;

public class URLFinder {
	public void findURLs(String url){
		URLResource page = new URLResource(url);
		String source = page.asString();
		int start = 0;
		while(true){
			int index = source.indexOf("href=",start);
			if(index == -1){
				break;
			}
			int firstQuote = index + 6; // after href="
			int endQuote = source.indexOf("\"", firstQuote);
			String sub = source.substring(firstQuote, endQuote);
			if (sub.startsWith("http")){
				System.out.println(sub);
			}
			start = endQuote + 1;
		}
	}
	public void testURL() {
		findURLs("https://www.zoho.com/sites/");
		findURLs("http://doctorswithoutborders.org");
	}
}  
