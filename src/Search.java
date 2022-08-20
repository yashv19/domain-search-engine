import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search {

    public static List<Page> pageList;
    public static List<Word> wordList;
    public static List<Result> resultSet = Collections.synchronizedList(new ArrayList<>());
    private String wordListFile;
    private String pageListFile;


    public Search (String wordListFile, String pageListFile) {
        this.wordListFile = wordListFile;
        this.pageListFile = pageListFile;
    }

    public void setup (String wordListFile, String pageListFile) throws Exception {
        FileUtils fu = new FileUtils();

        wordList = fu.getWordList(wordListFile);
        pageList = fu.getPageList(pageListFile);

    }

    public List<Result> executeQuery (String query) {
        resultSet.clear();
        query = query.toLowerCase();

        String[] terms = query.split(" ");


        // Create 5 Threads using the SearchThread class
        Thread[] threads = new Thread[5];
        try {
            nullCheck();
        }catch(Exception e){e.printStackTrace();}


        int range = wordList.size()/5;

        for(int i = 0; i < threads.length; i++) {
            if(i == 4) {
                threads[i] = new Thread(new SearchThread(i * range, wordList.size() - 1, terms));
            }
            else {
                threads[i] = new Thread(new SearchThread(i * range, (i + 1) * range - 1, terms));
            }
        }

        try {
            // Start the threads
            for (Thread t : threads) {
                t.start();
            }

            // Join the threads
            for (Thread t : threads) {
                t.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sort the list by score
        sort();
        return resultSet;
    }

    public void nullCheck() throws Exception{
        if (wordList == null || pageList == null) {
            setup(wordListFile, pageListFile);
        }
    }

    public void sort() {
        try {
            Collections.sort(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}