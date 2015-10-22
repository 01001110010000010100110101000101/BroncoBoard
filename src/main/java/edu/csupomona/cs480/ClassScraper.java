package edu.csupomona.cs480;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ClassScraper {

	private static String url = "http://catalog.cpp.edu/preview_program.php?catoid=4&poid=983&returnto=751";
	
	public ArrayList<String> getClassNames() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("li > span > a[href]");
		ArrayList<String> classNames = new ArrayList<String>();
		for(Element link: links) {
			String title = link.text();
			String department = title.substring(0, title.indexOf(" "));
			title = title.substring(title.indexOf(" ")+1);
			String number = title.substring(0, title.indexOf(" "));
			classNames.add(department + number);
		}
		return classNames;
	}
	
	public static void main(String[] args) {
		ClassScraper scrape = new ClassScraper();
		try {
            ArrayList<String> classNames = scrape.getClassNames();
            System.out.print(classNames);
		} catch (IOException e) {
			System.out.println("Caught IOException");
		}
	}

}
