package parser.svmlight;
public class WordObj implements Comparable <WordObj>{
    Integer id;
    int freq;
    WordObj(Integer id){
        this.id=id;
        freq=1;
    }
    public int compareTo(WordObj w){
        if (this.id<w.id) return -1;
        if (this.id==w.id) return 0;
        return 1;
    }
}