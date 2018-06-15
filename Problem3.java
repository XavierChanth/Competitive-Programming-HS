import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("./DATA31.txt"));
		String line;
		while((line = in.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(line);
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());	
			
			List<long[]> nums = formattedFactors(K);
			int n = 0;
			
			for (int i = 0; i < nums.size(); i++) {
				int score = 0; 
				int curNum = 0;
				
				while (score < nums.get(i)[1] * M) {
					curNum += nums.get(i)[0];
					int pow = 1;
					
					for (long j = nums.get(i)[0]; j <= curNum; j = (long) Math.pow(nums.get(i)[0], pow)) {
						pow++;
						if (curNum % j == 0) {
							score++;
						}
					}
				}
				
				if (curNum > n) {
					n = curNum;
				}
			}
			
			System.out.println(n);
		}
		
		
	}
	
	public static List<Long> getFactors(long k){
		List<Long> factors = new ArrayList<Long>();
		for (int i = 2; i <= Math.sqrt(k); i++) {
			if (k % i == 0) {
				List<Long> subFactors = getFactors(k/i);
				factors.addAll(subFactors);
				factors.addAll(getFactors(i));
				break;
			}
		}
		if (factors.size() == 0) {
			factors.add(k);
		}
		return factors;
	}
	
	public static List<long[]> formattedFactors (int k){
		List<Long> factors = getFactors(k);
		List<long[]> list = new ArrayList<long[]>();
		
		for (int i = 0; i < factors.size(); i++) {
			long val = factors.get(i);
			boolean found = false;
			
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j)[0] == val) {
					found = true;
					list.get(j)[1] += 1;		
				}
			}
			if (!found) {
				list.add(new long[] {val, 1});
			}
		}
		return list;
	}
	
	
}
