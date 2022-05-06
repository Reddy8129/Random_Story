import java.util.*;
import java.io.File;
import edu.duke.*;
public class WordsInFiles {

    private HashMap<String,ArrayList> wordFilenames;
    
    public WordsInFiles()
    {
        wordFilenames=new HashMap<String,ArrayList>();
    }
    private void addWordsFromFile(File f)
    {
        FileResource resource = new FileResource(f);
        for(String word: resource.words())
        {
            if(wordFilenames.containsKey(word))
            {
                ArrayList<String> arrList= wordFilenames.get(word);
                arrList.add(f.getName());
            }
            else
            {
                ArrayList<String> arrList = new ArrayList();
                arrList.add(f.getName());
                wordFilenames.put(word,arrList);
            }
        }
    }
    
    private void buildWordFileMap()
    {
        wordFilenames.clear();
        File folder = new File("data/files");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                addWordsFromFile(file);
            }
        }
    }
    private String maxNumber()
    {
        String maxNumberWord= new String();
        int size,max=0;
        ArrayList<String> filename;
        for(String word:wordFilenames.keySet())
        {
            filename=wordFilenames.get(word);
            size=filename.size();
            if(size>max)
            {
                maxNumberWord=word;
                max=size;
            }
        }
        return maxNumberWord;
    }
    
    private ArrayList wordInNumFiles(int num)
    {
        ArrayList<String> words = new ArrayList<String>();
        for(String word:wordFilenames.keySet())
        {
            if(wordFilenames.get(word).size()==num)
            {
                words.add(word);
            }
        }
        return words;
    }
    private void printFilesIn(String word)
    {
        ArrayList<String> filename=wordFilenames.get(word);
        for(String s: filename)
        {
            System.out.println(s);
        }
    }
    
    public void tester()
    {
        buildWordFileMap();
        /*
        for(String word:wordFilenames.keySet())
        {
            ArrayList<String> arrList=wordFilenames.get(word);
            String filenames="";
            for(String name:arrList)
                filenames+=name+" ";
            System.out.println(word+" appears in the files " +filenames); 
        }*/
        //printFilesIn("funny");
        //System.out.println(maxNumber());
        ArrayList<String> words=wordInNumFiles(3);
        for(String word:words)
        {
            System.out.println(word+"\t"+wordFilenames.get(word).size());
        }
    }
    
}
