package Graph;

import java.util.ArrayList;
import java.util.List;

public class POJ1062 {
	public static void main(String[] args) {
		Item i1 = new Item(10000, 1, new int[]{1,2}, new int[]{8000,5000});
		Item i2 = new Item(1000, 2, new int[]{3}, new int[]{200});
		Item i3 = new Item(3000, 2 , new int[]{3}, new int[]{200});
		Item i4 = new Item(50, 2, new int[]{}, new int[]{});
		Item[] arr = {i1, i2, i3, i4};
		int[][] graph = createGraph(1, arr);
		System.out.println(getMin(4,graph));
	}	 
	
	//Create adj_matrix according to the given information
	public static int[][] createGraph(int M, Item[] arr) {
		int MAX = 9999999;
		int target_level = arr[0].level;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].level - target_level > M) {
				arr[i].value = MAX;
			}
		}
		int[][] result = new int[arr.length + 1][arr.length + 1];
		
		//create a node which shows the original price of each item
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				result[i][j] = MAX;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			result[arr.length][i] = arr[i].value;
		}
		
		for(int i = 0; i < arr.length; i++)  {
			for(int j = 0; j < arr[i].sub_num.length; j++) {
				result[arr[i].sub_num[j]][i] = arr[i].sub_price[j];
			}
		}
		return result;
	}
	
	//using the di-algorithm to compute the shortest path from s to each one,and the path 
	//from s to vertice "0" is what i need 
	public static int getMin(int s, int[][] graph) {
		int MAX = 9999999;
		int[] dis = new int[graph.length];
		for(int i = 0; i < dis.length - 1; i++) 
			dis[i] = MAX;
		dis[s] = 0;
		List<Integer> list = new ArrayList();
		for(int i = 0; i < graph.length; i++) {
			list.add(i);
		}
		while(!list.isEmpty()) {
			int min = 0;
			for(int i = 0; i < list.size(); i++) {
				int in = list.get(i);
				if(dis[in] < dis[min]) min = in;
			}
			list.remove((Object)min);
			for(int i = 0; i < list.size(); i++) {
				int index = list.get(i);
				if(dis[index] > dis[min] + graph[min][index]) {
					dis[index] = dis[min] + graph[min][index];
				}
			}
		}
		return dis[0];
	}

}
