import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EmojiParserExample {

  public static void main(String[] args) {

	Document doc;
	try {

		// need http protocol
		doc = Jsoup.connect("http://www.i2symbol.com/emoticons/misc").get();

		Elements symbols= doc.select("div[^data-symbols]");
		for (Element s: symbols) {
   			String symbol= s.attr("data-symbols");
   			System.out.println(symbol);
		}
		
		

	} catch (IOException e) {
		e.printStackTrace();
	}

  }

}