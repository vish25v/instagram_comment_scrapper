package demo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
  import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

  public class jsoupRun {

      public static void main(String[] args) {

          String htmlString = "<html><head><title>My title</title></head>"
                  + "<body>Body content</body></html>";

          Document doc = Jsoup.parse(htmlString);
          String title = doc.title();
          String body = doc.body().text();

          System.out.printf("Title: %s%n", title);
          System.out.printf("Body: %s", body);
          Document doc =Jsoup.connect("https://www.instagram.com/p/BY6gh6Pl6Fk/?hl=en&taken-by=earthpix").timeout(6000).get();


 		 Element script = doc.select("script").first(); // Get the script part
 				   
 				   
 				  Pattern p = Pattern.compile("(?is)key=\"(.+?)\""); // Regex for the value of the key
 				  Matcher m = p.matcher(script.html()); // you have to use html here and NOT text! Text will drop the 'key' part
 				   
 				   
 				  while( m.find() )
 				  { 
 				      System.out.println(m.group()); // the whole key ('key = value')
 				      System.out.println(m.group(1)); // value only
 				  }
 		  
      
  }
}