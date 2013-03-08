package parser.svmlight;
import java.util.*;
public class Mapper{
    public static Hashtable <Integer,Integer> count_map=new Hashtable <Integer,Integer>();
    public static Hashtable <String,Integer> id_map=new Hashtable <String,Integer>();
    public static Integer index=1;
    public static Integer getID(String word){
        Integer i=id_map.get(word);
        if (i==null) {
           id_map.put(word,index);
           count_map.put(index,new Integer(1));
           return index++; 
        }
        return i;
    }
    public static Integer getCount(Integer id){
        Integer count=count_map.get(id);
        if (count==null)
            return 0;
        else
            return count;
    }
    private ArrayList <WordObj> list=new ArrayList < WordObj > ();
    private Hashtable <Integer,Integer> temp=new Hashtable <Integer,Integer>();
    private Integer i=0;
    public void add(Integer id){
        Integer index=temp.get(id);
        if (index==null){
            WordObj w=new WordObj(id);
            temp.put(id,i);
            i++;
            list.add(w);
        }else{
            WordObj w=list.get(index);
            w.freq++;
        }
    }

    public Iterator<WordObj> iterator(){
        Collections.sort(list); 
        return list.iterator();
    }
}

