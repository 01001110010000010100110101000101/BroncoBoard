package edu.csupomona.cs480;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ClassScraper {

	private static String url = "http://catalog.cpp.edu/preview_program.php?catoid=4&poid=983&returnto=751";
	private static ClassScraper instance;
	private static ArrayList<String> classNamesList;
	
	private ClassScraper() {};
	
	public static ClassScraper getInstance() {
		if(instance == null) {
			instance = new ClassScraper();
		}
		return instance;
	}
	
	public ArrayList<String> getClassNames() throws IOException {
        if(classNamesList == null) {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("li > span > a[href]");
            Set<String> classNamesSet = new HashSet<String>();
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
                    classNamesSet.add(department + number);
                }
                classNamesList = new ArrayList(classNamesSet);
                classNamesList.add("CPP");
                Collections.sort(classNamesList);
        }
		return classNamesList;
	}

	public String getURL(){
		return url;
	}

}
