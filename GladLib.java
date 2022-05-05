import java.util.*;
import edu.duke.*;
public class GladLib 
{
    private ArrayList<String> adjectiveList;
    private ArrayList<String> animalList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> fruitList;
    private ArrayList<String> nameList;
    private ArrayList<String> nounList;
    private ArrayList<String> verbList;
    private ArrayList<String> timeframeList;
    private ArrayList<String> usedWords;
    private int count;
    private Random random;
    
    public GladLib()
    {
    adjectiveList=new ArrayList<String>();
    animalList=new ArrayList<String>();
    colorList=new ArrayList<String>();
    countryList=new ArrayList<String>();
    fruitList=new ArrayList<String>();
    nameList=new ArrayList<String>();
    nounList=new ArrayList<String>();
    verbList=new ArrayList<String>();
    timeframeList = new ArrayList<String>();
    usedWords = new ArrayList<String>();
    random = new Random();
    count=0;
    initializefromSource();
    }
    private void initializefromSource()
    {
     adjectiveList=readIt("data/adjective.txt");
     animalList=readIt("data/animal.txt");
     colorList=readIt("data/color.txt");
     countryList=readIt("data/country.txt");
     fruitList=readIt("data/fruit.txt");
     nameList = readIt("data/name.txt");
     nounList = readIt("data/noun.txt");
     verbList=readIt("data/verb.txt");
     timeframeList=readIt("data/timeframe.txt");
    }
    private ArrayList<String> readIt(String address)
    {
        FileResource resource = new FileResource(address);    
        ArrayList<String> list = new ArrayList<String>();
        for(String w : resource.words())
            list.add(w);   
        return list;
    }
    private String randomFrom(ArrayList<String> source)
    {
        int idx= random.nextInt(source.size());
        return source.get(idx);
    }
    private String getRandomWord(String label)
    {
        if(label.equals("adjective"))
            return randomFrom(adjectiveList);
        if(label.equals("animal"))
            return randomFrom(animalList);
        if(label.equals("color"))
            return randomFrom(colorList);
        if(label.equals("country"))
            return randomFrom(countryList);
        if(label.equals("fruit"))
            return randomFrom(fruitList);
        if(label.equals("name"))
            return randomFrom(nameList);
        if(label.equals("noun"))
            return randomFrom(nounList);
        if(label.equals("verb"))
            return randomFrom(verbList);
        if(label.equals("timeframe"))
            return randomFrom(timeframeList);
        if(label.equals("number"))
            return ""+random.nextInt(200)+5;
        return "*Unknown*";
    }
    private String processWord(String word)
    {
        int startIndex;
        int endIndex;
        String replaceWord;
        String listName;
        if(word.contains("<") & word.contains(">"))
            {
                startIndex=word.indexOf("<");
                endIndex=word.indexOf(">");
                listName=word.substring(startIndex+1,endIndex);
                do
                {
                    replaceWord=getRandomWord(listName);
                }while(usedWords.contains(replaceWord));
                usedWords.add(replaceWord);
                word=word.replace("<"+listName+">", replaceWord);
                count++;
                return word;

            }
            return word;
    }
    public void  makeStory()
    {
        usedWords.clear();
        FileResource resource = new FileResource("data/madtemplate2.txt");
        StringBuilder story = new StringBuilder();
        for(String line:resource.lines())
        {
            for(String word:line.split(" ")){
                String proceccedWord=processWord(word);
                story.append(proceccedWord+" ");   
            }
         story.append("\n");
        }
        System.out.println(story);
        System.out.println(count);
    } 
}
