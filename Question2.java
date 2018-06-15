import java.io.*;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;

public class Question2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("./DATA21.txt"));
		String line;
		while((line = in.readLine())!=null) {
			int N = Integer.parseInt(line);
			List<Double> finalValues = new ArrayList<Double>();
			List<Object[]> pairs = new ArrayList<Object[]>();
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int D = Integer.parseInt(st.nextToken());
				double W = Double.parseDouble(st.nextToken());
				pairs.add(new Object[] {D,W});
			}
			Collections.sort(pairs, new Comparator<Object>() {
				@Override
				public int compare(Object arg0, Object arg1) {
					return ((int)((Object[])arg0)[0])-(int)(((Object[])arg1)[0]);
				}				
			});
			for(int i = 0; i<pairs.size(); i++) {
				Object[] pair = pairs.get(i);
				int day = (int)pair[0];
				if(finalValues.size()<day) {
					finalValues.add((double)(pair[1]));
				} else {
					double smallest = Double.MAX_VALUE;
					int index = -1;
					for(int j = 0; j<finalValues.size(); j++) {
						if(finalValues.get(j)<smallest) {
							smallest = finalValues.get(j);
							index = j;
						}
					}
					if((double)pair[1]>smallest) {
						finalValues.set(index, (double)pair[1]);						
					}
				}
				
			}
			double sum = 0;
			for(double a : finalValues) {
				sum += a;
			}
			sum = Math.round(sum*10000d)/10000d;
			DecimalFormat df = new DecimalFormat("#.0000");
			System.out.println(df.format(sum));
			
		}
	}
}
