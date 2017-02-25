package DataStruture;

public class POJ2388 {
	public static void main(String[] args) {
		int[] array = {2,4,1,3,5};
		System.out.println(getMid(array));
	}
	
	public static int getMid(int[] array) {
		return quickSort(array, 0 , array.length - 1)[(array.length - 1) / 2];
	}
	
	private static int partition(int[] array, int start, int end) {
		int p = array[end];
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if(array[j] < p) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[end] = array[i + 1];
		array[i + 1] = p;
		return i + 1;
	}
	
	public static int[] quickSort(int[] array, int start, int end) {
		if(start >= end) return array;
		else {
			int q = partition(array, start, end);
			quickSort(array, start, q - 1);
			quickSort(array, q, end);
		}
		return array;
	}

}
