package edu.csupomona.cs480;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ClassScraper {

	private static String url = "http://catalog.cpp.edu/preview_program.php?catoid=4&poid=983&returnto=751";
	
	public Set<String> getClassNames() throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("li > span > a[href]");
		Set<String> classNames = new HashSet<String>();
		for(Element link: links) {
			String title = link.text();
			String number;
			String department = title.substring(0, title.indexOf(" "));
			title = title.substring(title.indexOf(" ")+1);
			if(title.indexOf("/") != -1) {
				number = title.substring(0, Math.min(title.indexOf(" "), title.indexOf("/")));
			} else {
                number = title.substring(0, title.indexOf(" "));
			}
			classNames.add(department + number);
		}
		return classNames;
	}

}
