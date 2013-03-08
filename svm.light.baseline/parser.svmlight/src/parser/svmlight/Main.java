package parser.svmlight;
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String argv[]){
       //test();
       //run();
       preprocess_job();
    }
    public static void test(){}
    public static void run(){}
    public static void preprocess_job(){
        Reader r=new Reader("path.txt");       
        r.shuffle();
    }
}
