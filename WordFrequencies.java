
import edu.duke.*;
import java.util.ArrayList;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s: resource.words())
        {
            String word = s.toLowerCase();
            if(!myWords.contains(word))
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else
            {
                int idx = myWords.indexOf(word);
                int value= myFreqs.get(idx);
                myFreqs.set(idx,value+1);
            }
        }
        
    }
    
    private int findIndexOfMax()
    {
        int max =0;
        for(int val: myFreqs)
        {
            if(val>max)
                max=val;
        }
        return myFreqs.indexOf(max);
    }
    public void tester()
    {
        findUnique();
        for(int i=0; i<myWords.size();i++)
            System.out.println(myWords.get(i)+" --> "+myFreqs.get(i));
        int maxDex= findIndexOfMax();
        String word = myWords.get(maxDex);
        int value = myFreqs.get(maxDex);
        System.out.println("The word that occurs most often and its count are: " +word+" "+value);
        //System.out.println(myWords.size());
    }
}
