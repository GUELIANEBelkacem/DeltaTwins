import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MyDataGenerator {

	public static void main(String [] args) {
		int n = 50;
		int m = 10000;
		int tau = 5000;
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i<m;i++) {
			int t = r.nextInt(tau);
			int u = r.nextInt(n);
			int v = u;
			while(u == v) v = r.nextInt(n);
			sb.append(u+" "+v+" "+t+"\n");
		}
		try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter("data/mydata/mydata.txt"));
			writer.write(sb.toString());
			writer.close();
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
