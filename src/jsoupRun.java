package demo;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.DataNode;
public class demorun2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Document doc =Jsoup.connect("https://www.instagram.com/p/BY07aH0F2r1/?taken-by=earthpix").timeout(6000).get();

		Elements script = doc.select("script");
		//Pattern p = Pattern.compile("xmlhttp.open\\(\"GET\", \"(.*)\", false\\)")		                                                    //  ^^ is the capturing group 
		
		
		String pattern1 = "\"text\":";
	    String pattern2 = ",";
			  
		Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
		
		String url = "";
		 
		for (Element element : script) {
		    Matcher m = p.matcher(element.data());
		   /* if (m.find()){
		        url = m.group(1);
		        //System.out.println(url);
//				   System.out.println(m.group(1));

		    }*/
		    while (m.find()) {
				   System.out.println(m.group(1));
				 } 
		} 
		System.out.println(url);

	}

}