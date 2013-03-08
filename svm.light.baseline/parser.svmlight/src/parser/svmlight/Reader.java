package parser.svmlight;
import java.util.*;
import java.io.*;
public class Reader{
    public static String pos_url;
    public static String neg_url;
    public static String data_url;
    public Reader(String path){
        try{
            BufferedReader br=new BufferedReader(new FileReader(new File(path)));
            String line=br.readLine();
            pos_url=line.substring(4,line.length());
            line=br.readLine();
            neg_url=line.substring(4,line.length());
            
            line=br.readLine();
            data_url=line.substring(5,line.length());
        }catch(Exception e){e.printStackTrace();
        }
    }
    public void shuffle(){
        try{
        LinkedList <String> list=new LinkedList <String> ();
        BufferedReader br=new BufferedReader(new FileReader(new File(data_url+"_pos.txt")));
        String line=null;
        int length=0;
        while ( (line=br.readLine())!=null){
            list.add(line);
            length++;
        }
        br=new BufferedReader(new FileReader(new File(data_url+"_neg.txt")));
        while ( (line=br.readLine())!=null){
            list.add(line);
            length++;
        }
        Collections.shuffle(list);
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("train.txt")));
        BufferedWriter bw2=new BufferedWriter(new FileWriter(new File("test.txt")));
        int cut=length/10;
        for (String l : list){
            if (length<=cut){
                bw2.write(l);
                bw2.newLine();
            }else{
                bw.write(l);
                bw.newLine();
            }
            length--;
        }
        bw.close();
        bw2.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public void generate(){
        handle(pos_url,data_url+"_pos.txt",1);
        handle(neg_url,data_url+"_neg.txt",-1);
    }

    public void handle(String url,String data_url,int tag){
        String message="";
        try{
            BufferedWriter bw=new BufferedWriter( new FileWriter(new File(data_url)));  
            File files=new File(url);
            File [] fs=files.listFiles();
            for (int i=0;i<fs.length;i++){
                if (fs[i].toString().matches(".*\\.txt$")){
                    message=fs[i].toString();
                    Mapper map=new Mapper();
                    BufferedReader br=new BufferedReader(new FileReader(fs[i]) );
                    String line=null;
                    while ( (line=br.readLine())!=null ){
                        StringTokenizer st=new StringTokenizer(line);
                        while (st.hasMoreTokens()){
                            String word=st.nextToken();
                            Integer id= Mapper.getID(word);
                            map.add(id);
                        }
                    }
                    //here we finish read an entire document
                    bw.write(tag+" ");
                    Iterator <WordObj> it=map.iterator();
                    while (it.hasNext()){
                        WordObj ob=it.next();
                        bw.write(ob.id.toString()+":"+ob.freq+" ");
                    }
                    bw.newLine();
                }
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(message);
        }
    }
}

