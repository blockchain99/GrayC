package edu.duke;
import java.io.*;
import java.net.URL;

public class URLFinder {
	public StorageResource findURLs(String url){
		URLResource page = new URLResource(url);
		String source = page.asString();
		StorageResource stSource = new StorageResource();
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
				//System.out.println(sub);
				stSource.add(sub);
			}
			start = endQuote + 1;
		}
		return stSource;
	}
	public void testURL() {
//		findURLs("https://www.zoho.com/sites/");
//		System.out.println("size of findURLs return value : " + findURLs("https://www.zoho.com/sites/").size());
//		findURLs("http://doctorswithoutborders.org");
		StorageResource ss = findURLs("https://www.zoho.com/sites/");
		StorageResource ss2= findURLs("http://doctorswithoutborders.org");
		
		for(String link : ss.data()){
			System.out.println(link);			
		}
		System.out.println("size site 1 : "+ss.size());
		System.out.println("size site 2 : "+ss2.size());
	}
}  
