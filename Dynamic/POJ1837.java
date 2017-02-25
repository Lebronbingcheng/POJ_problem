package Dynamic;

public class POJ1837 {

	public static void main(String[] args) {
		int nums_hook = 2;
		int nums_w = 4;
		int[] pos_hook = {-2, 3};
		int[] wight = {3,4,5,8};
		System.out.println(count(nums_hook, nums_w, pos_hook, wight));

	}
	
	public static int count(int nums_hook, int nums_w, int[] pos_hook, int[] wight) {
		int[][] dp = new int[nums_w + 1][15001];
		dp[0][7500] = 1;   // means when attack 0 weight, it must be balance
		
		for(int i = 1; i <= nums_hook; i++) {
			for(int j  = 0; j <= 15000; j++) {
				if(dp[i - 1][j] != 0){
					for(int k = 0; k < nums_hook; k++) {
						dp[i][j + wight[i]* pos_hook[k]] += dp[i - 1][j];   
					}
				}
			}
		}
		//count the number of method
		return dp[4][7500];
	}

}
