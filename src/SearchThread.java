import java.util.ArrayList;
import java.util.List;

public class SearchThread implements Runnable
{
    public int start;
    public int finish;
    public String[] terms;

    public SearchThread(int start, int finish, String[] terms)
    {
        this.start = start;
        this.finish = finish;
        this.terms = terms;
    }
    public void run()
    {
        for(String term : terms) {
            Word word = findTerm(term);
            if (word != null)
            {
                List<Integer> urlIDs = word.getList();
                for(Integer id : urlIDs)
                {
                    int i;
                    for(i = 0; i < Search.resultSet.size(); i++)
                    {
                        if(Search.resultSet.get(i).getURLID() == id) {
                            Search.resultSet.get(i).incrementScore();
                            break;
                        }
                    }
                    if(i == Search.resultSet.size()) {
                        String url = "";
                        for (Page p : Search.pageList) {
                            if (p.getURLID() == id) {
                                url = p.getURL();
                                break;
                            }
                        }
                        Search.resultSet.add(new Result(url, id));
                    }

                }


            }
        }

    }
    public Word findTerm(String term)
    {
        int i;
        for(i = start; i < finish; i++)
        {
            Word word = Search.wordList.get(i);
            if(term.equals(word.getWord()))
                return word;
        }
        return null;
    }
}
