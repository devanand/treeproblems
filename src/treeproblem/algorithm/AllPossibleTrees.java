package treeproblem.algorithm;

public class AllPossibleTrees {

	static long allPossibleTrees(int n, long memo[]) {
		if(memo[n]!=0) return memo[n];
		long sum = 0;
		for(int i=1;i<=n;i++) {
			sum = sum + allPossibleTrees(i-1, memo)*allPossibleTrees(n-i, memo);
		}
		return memo[n] = sum;
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		long memo[] = new long[n+1];
		memo[0] = memo[1] = 1;
		
		for(int i=0;i<=n;i++) {
			allPossibleTrees(i, memo);
		}
		
		System.out.println(memo[n]);
	}
}
