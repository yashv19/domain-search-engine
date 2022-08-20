/**
 * Project 4
 *
 *Word class to represent a word as well as the Id's of the URL's that it is associated with.
 *
 * @author Yashvin Vedanaparti, Riley Turk, section 17
 *
 * @version 3/31/17
 *
 */

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Word implements Serializable
{
    public static final long serialVersionUID = -3696191086353573895L;

    private List<Integer> postings = new ArrayList<Integer>(); //List for URLIDs associated with this Word
    private String word;            //Fields for the String representation of this word.

    Word(String word, int urlID)
    {
        this.word = word;
        addURLID(urlID);
    }


    public void addURLID(int urlID)
    {
        postings.add(urlID);
    }

    public String getWord()
    {
        return this.word;
    }
    public List<Integer> getList()
    {
        return postings;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Word)
        {
            Word otherWord = (Word) obj;
            if(this.word.equals(otherWord.word))
                return true;
        }
        return false;
    }
}
