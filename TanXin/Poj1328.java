package TanXin;

import java.util.ArrayList;
import java.util.List;

public class Poj1328 {
	public static void main(String[] args) {
		Poj1328 test = new Poj1328();
		double[] arr = new double[]{3,2,1,2,-3,1,2,1};
		double[] range = test.getRange(arr, 4);
		int result = test.getMinPoint(range);
		System.out.println(result);
	}
	
	public double[] getRange(double[] array, int d) {
		if(array.length % 2 != 0 || array.length == 0) return null;
		double[] result = new double[array.length];
		for(int i = 0, j = 1; j < array.length; i++, j++) {
			if(array[j] > d) return null;
			result[i] = array[i] - Math.sqrt((d*d - array[j] * array[j]));
			result[j] = array[i] + Math.sqrt((d*d - array[j] * array[j]));
		}
		return result;
	}
	
	public int getMinPoint(double[] range){
		double[] array = sort(range, range.length);
		List<Double> list = new ArrayList<Double>();
		list.add(array[0]);
		list.add(array[1]);
		for(int i = 2; i < array.length - 1; i += 2) {
			double a = list.get(list.size() - 2);
			double b = list.get(list.size() - 1);
			double c = array[i];
			double d = array[i + 1];
			int relation = interType(a, b , c, d);
			if(relation == 1) {
				list.add(c);
				list.add(d);
			}else if(relation == 2) {
				list.remove(a);
				list.remove(b);
				list.add(c);
				list.add(b);
			}else {
				list.remove(a);
				list.remove(b);
				list.add(c);
				list.add(d);
			}
		}
		return list.size() / 2; 
	}
	
	private int interType(double a, double b, double i, double j) {
		if(b < i) return 1;
		if(b > i) return 2;
		return 3;
	}
	
	private static double[] sort(double[] range, int num) {
		if(num == 2) return range; 
		for(int i = 0; i < num - 3; i+=2) {
			if(range[i] > range[i + 2]) {
				double temp1 = range[i];
				double temp2 = range[i + 1];
				range[i] = range[i + 2];
				range[i + 1] = range[i + 3];
				range[i + 2] = temp1;
				range[i + 3] = temp2;
			}
		}
		return sort(range, num - 2);
	}
}