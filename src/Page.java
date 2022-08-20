/**
 * Project 4
 *
 *Page object to represent a webpage.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */
import java.io.Serializable;

public class Page extends Object implements Serializable, Comparable<Page>
{
    public static final long serialVersionUID = -1827677255104766839L;
    String url;         //URL as a String for this page
    private int urlID;      //ID for this specific page

    Page(String url, int urlID)
    {
        this.url = url;
        this.urlID = urlID;
    }

    public int compareTo(Page candidate)
    {
        if(this.urlID < candidate.urlID)
            return -1;
        if(this.urlID == candidate.urlID)
            return 0;
        if(this.urlID > candidate.urlID)
            return 1;
        return 1;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Page) {
            Page otherPg = (Page) obj;
            if (this.url.equals(otherPg.url) || this.urlID == otherPg.urlID) {
                return true;
            }   //end if
        }   //end if

        return false;
    }

    String getURL(){
        return this.url;
    }
    int getURLID(){
        return this.urlID;
    }


}
