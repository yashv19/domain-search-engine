import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import java.io.Serializable;
import java.util.ArrayList;
/////////////////////////////////////////////////////////
public class Crawler implements Serializable
{
    static int currentID;
    static String domain;
    static int limit;
    static ArrayList<Page> parsed = new ArrayList<Page>();
    static Parser parser = new Parser();
    MyQueue toParse = new MyQueue();
    static int totalURLs;
    static ArrayList<String> visited = new ArrayList<String>();
    static ArrayList<Word> words = new ArrayList<Word>();

    Crawler(String seed, String domain, int limit)
    {
        Crawler.domain = domain;
        Crawler.limit = limit;
        currentID = 0;
        totalURLs = 0;
        if (seed != null) {
            toParse.add(seed);
        }
    }

    public void crawl()
    {
        while(!toParse.isEmpty() && currentID < limit)
        {
            String url = (String) toParse.remove().getData();
            try {
                if(!visited.contains(url)) {
                    parse(parser.getDocument(url), currentID);
                    addPageToList(new Page(url, currentID));
                    visited.add(url);
                    currentID++;
                }
            } catch(ParseException e){}
        }

    }

    public void parse(Document doc, int id)
    {
        if(doc != null) {
            parseLinks(doc);

            parseText(doc, id);

        }
    }

    public void parseLinks(Document doc)
    {
        Elements links;
        try{
            links = parser.getLinks(doc);
            for(Element link : links)
            {
                String url = link.attr("abs:href");
                if(isInDomain(url) && isValidURL(url)) {
                    addToQueue(url);

                }
            }
        } catch(ParseException e){ e.printStackTrace();};
    }

    public void parseText(Document doc, int id) {
        String body = "";
        try {
            body = parser.getBody(doc);
        } catch (ParseException e) {
        } catch (NullPointerException ae) {
            ae.printStackTrace();
        }
        String[] wordArr = body.split(" ");
        for (int i = 0; i < wordArr.length; i++)
        {
            addWordToList(wordArr[i], id);
        }
    }

    public void addWordToList(String word, int id)
    {
        word = word.toLowerCase();
        Word wordObj = new Word(word, id);
        for(Word currentWord : words)
        {
            if(currentWord.equals(wordObj))
            {
                currentWord.addURLID(id);
                return;
            }
        }
        words.add(wordObj);

    }

    public void addToQueue(String url)
    {
        if(!visited.contains(url)) {
            toParse.add(url);
            totalURLs++;
        }
    }

    public void addPageToList(Page p)
    {
        if(!parsed.contains(p)) {
            parsed.add(p);


        }
    }

    public boolean isInDomain(String url)
    {
        if(url == null)
            return false;

        return url.contains(domain);
    }

    public boolean isValidURL(String url)
    {
        if(url == null)
            return false;

        if(url.substring(0,7).equals("http://") || url.substring(0,8).equals("https://"))
            return true;
        else
            return false;
    }
}