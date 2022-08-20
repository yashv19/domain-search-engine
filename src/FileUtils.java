import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class FileUtils {

    public boolean saveWordTable(List<Word> wordTable, String filePath)
    {
        if(filePath == null || wordTable == null)
            return false;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wordTable);
            oos.close();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean savePageTable(List<Page> pageTable, String filePath)
    {
        if(filePath == null || pageTable == null)
            return false;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pageTable);
            oos.close();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Word> getWordList(String filePath)
    {
        if(filePath == null)
            return null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);

            List<Word> wordList = (ArrayList<Word>) ois.readObject();
            return wordList;

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                ois.close();
                fis.close();
            }catch(IOException e){e.printStackTrace();}
        }

        return null;

    }
    public List<Page> getPageList(String filePath)
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(filePath == null)
            return null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);

            List<Page> pageList = (ArrayList<Page>) ois.readObject();
            return pageList;
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {

                ois.close();
                fis.close();
            }catch(IOException e){e.printStackTrace();}
        }

        return null;
    }
}
