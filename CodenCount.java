import java.util.*;
import edu.duke.*;
public class CodenCount 
{
    private HashMap<String,Integer> dnaCoden;
    
    private CodenCount()
    {
        dnaCoden = new HashMap<String,Integer>();
    }
    
    
    private void buildCodenMap(int start, String dna)
    {
        dnaCoden.clear();
        for(int i=start;i<dna.length()-2;i+=3)
        {
            String coden=dna.substring(i,i+3);
            //System.out.println(coden);
            if(dnaCoden.containsKey(coden))
            {
                dnaCoden.put(coden,dnaCoden.get(coden)+1);
            }
            else
                dnaCoden.put(coden,1);
            } 
        
    }
    private String getMostCommonCoden()
    {
        String coden= new String();
        int max=0;
        for(String s:dnaCoden.keySet())
        {
            int value=dnaCoden.get(s);
            if(value>max)
            {
                coden=s;
                max=value;
            }
                
        }
        return coden;
    }
    private void printCodenCounts(int start, int end)
    {
        for(String s:dnaCoden.keySet())
        {
            int value=dnaCoden.get(s);
            if(value>=start& value<=end)
                System.out.println(s+"\t"+dnaCoden.get(s));
        }
    }
    private String getContent()
    {
        FileResource resource = new FileResource();
        String content= new String();
        for(String s: resource.lines())
            content+=s.toUpperCase();
        return content;
    }
    public static void main(String args[])
    {
        CodenCount cc = new CodenCount();
        String dna=cc.getContent();
        for(int i=0;i<3;i++)
        {
            cc.buildCodenMap(i,dna);
            String mostCommonCoden = cc.getMostCommonCoden();
            System.out.println("Reading frame starting with " +i+" results in "+cc.dnaCoden.size()+" unique codons and most common codon is "+mostCommonCoden+" with count "+ cc.dnaCoden.get(mostCommonCoden));
            cc.printCodenCounts(1,5);
        }
    }
}
