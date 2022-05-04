
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCount;
    
    public CharactersInPlay()
    {
        characterNames = new ArrayList<String>();
        characterCount = new ArrayList<Integer>();
    }
    
    private void update(String person){
        if(!characterNames.contains(person))
        {
            characterNames.add(person);
            characterCount.add(1);
        }
        else
        {
            int idx= characterNames.indexOf(person);
            int value = characterCount.get(idx);
            characterCount.set(idx,value+1);
        }
    }
    
    private void findAllCharacters()
    {
        characterNames.clear();
        characterCount.clear();
        FileResource resource = new FileResource();
        for(String line:resource.lines())
        {
            String name;
            if(line.contains("."))
            {
                name=line.substring(0,line.indexOf("."));
                update(name.trim());
            }
        }
    }
    private void charactersWithNumParts(int num1, int num2)
    {
        String name;
        int freq;
        for(int i=0;i<characterCount.size();i++)
        {   
            name=characterNames.get(i);
            freq=characterCount.get(i);
            if(freq>=num1& freq<=num2)
                System.out.println(name +"\t"+freq);
        }
    }
    public void tester()
    {
        findAllCharacters();
        charactersWithNumParts(10,15);
        /*String name;
        int freq;
        for(int i=0;i<characterCount.size();i++)
        {   
            name=characterNames.get(i);
            freq=characterCount.get(i);
            if(freq>=50)
            {
                System.out.println(name +"\t"+freq);
            }
        }*/
    }
    
}
