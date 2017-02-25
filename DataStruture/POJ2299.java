package DataStruture;

public class POJ2299 {
	static int ans = 0;
	public static void main(String[] args) {
		int[] array = {9,1,0,5,4};
		for(int i : mergeSort(array, 0, array.length - 1))
			System.out.print(i + " ");
		System.out.println();
		System.out.println(ans);
	}
	
	public static int[] mergeSort(int[] array, int s, int e) {
		if(s < e) {
			int mid = (e + s) / 2;
			mergeSort(array, s, mid);
			mergeSort(array, mid + 1, e);
			merge(array, s, mid, e);
		}
		return array;
	}
	
	public static int[] merge(int[] array, int s, int mid, int e) {
		int n1 = mid - s + 1;
		int n2 = e - mid;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		for(int i = 0; i < n1; i++) {
			left[i] = array[s + i];
		}
		for(int a = 0; a < n2; a++) {
			right[a] = array[mid + a + 1];
		}
		left[n1] = 9999;
		right[n2] = 9999;
		
		int i = 0;
		int j = 0;
		for(int k = s; k < e + 1; k++) {
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}else {
				array[k] = right[j];
				j++;
				ans += (n1 - i);
			}
		}
		return array;
	}
}
