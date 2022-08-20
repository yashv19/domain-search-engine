/**
 * Project 4
 *
 * The parser class fetches web page from given url, extracts and returns content.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.Serializable;


public class Parser implements Serializable
{

    public Document getDocument (String url) throws ParseException {
        try {
            if(url == null)
            {
                throw new ParseException("getDocument() failed. String url is null.");
            }
            if(url.equals(""))
            {
                throw new IOException("getDocument() failed. String url is empty.");
            }

            Document doc = Jsoup.connect(url).timeout(3000).get();


            if (doc == null) {
                throw new ParseException("getDocument() failed. String url is null.");
            }

            return doc;
        } catch (ParseException e) {
            throw new ParseException("getDocument() failed. String url is null.");
        } catch (IOException e) {
            throw new ParseException("getDocument() failed. String url is empty.");
        } catch (Exception e) {
            throw new ParseException("getDocument() failed. Connection failed.");
        }
    }

    public Elements getLinks (Document doc) throws ParseException {
        if (doc == null) {
            throw new ParseException("getLinks() failed. Document parameter is null.");
        }

        /* Get all link (<a>) tags as an Elements object */
        Elements links = doc.select("a[href]");

        /* Elements is an ArrayList of Element objects. You can enumerate over them like this; */
        for(Element link : links) {
            System.out.println(link.text());

        }

        return links;
    }

    public String getBody (Document doc) throws ParseException {
        if (doc == null) {
            throw new ParseException("getBody() failed. Document parameter is null.");
        }

        /* Get the entire contents of the body tag */
        Element body = doc.body();

        return body.text();
    }
}
