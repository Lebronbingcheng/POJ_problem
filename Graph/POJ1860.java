package Graph;

public class POJ1860 {
	public static void main(String[] args) {
		double[][] arr1 = {{0, 1, 0},
		{1,0,1.1},
		{0,1.1,0},
		};
		
		double[][] arr2 = {{0, 1.0, 0},
				{1,0,1.0},
				{0,1.0,0},
				};
		System.out.println(compute(0,3,20,arr1,arr2));
	}
	
	public static boolean compute(int start, int n, double v, double[][] R, double [][] C) {
		double[] dist = new double[n];
		dist[start] = v;
		for(int i = 0; i < n; i++) {
			boolean fal = false;
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					if(R[a][b] != 0) {
						if(dist[b] < (dist[a] - C[a][b]) * R[a][b]) {
							fal = true;
							dist[b] = (dist[a] - C[a][b]) * R[a][b];
						}
					}
				}
			}
			if(!fal) return false;
		}
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < n; b++) {
				if(R[a][b] != 0) {
					if(dist[b] < (dist[a] - C[a][b]) * R[a][b]) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
