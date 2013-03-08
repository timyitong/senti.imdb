import java.util.*;
import java.io.*;
public class ResultRewriter{
	public static void main(String argv[]){
		try{
		String result=argv[0];
		String data=argv[1];
		BufferedReader br=new BufferedReader(new FileReader(new File(result)));
		BufferedReader br2=new BufferedReader(new FileReader(new File(data)));
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File(argv[2])));
		String line=null;
		while ((line=br.readLine())!=null){
			String l=br2.readLine();
			StringTokenizer st=new StringTokenizer(l);
			l=st.nextToken();
			double tag=Double.parseDouble(line);
			int pre=0;
			if (tag>=0)
				pre=1;
			else
				pre=-1;
			String s=pre+" "+l;
			bw.write(s);
			bw.newLine();
		}
		bw.close();
		}catch(Exception e){
			System.out.println("ResultRewrite result_file test_tile target_file");
		}
	}
}