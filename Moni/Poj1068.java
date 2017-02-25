package Moni;
import java.util.LinkedList;
import java.util.List;

public class Poj1068 {
	public static void main(String[] args) {
		int[] array = new int[]{4,5,6,6,6,6};
		List<Character> list = tran(array);
		List<Integer> l = new LinkedList<>();
		l = compute(list);
		for(int a : l) {
			System.out.print(a + " ");
		}
	}
	
	public static List<Character> tran(int[] array) {
		List<Character> list = new LinkedList<>();
		int a = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i] - a; j++) {
				list.add('(');
			}
			list.add(')');
			a = array[i];
		}
		return list;
	}
	
	public static List<Integer> compute(List<Character> list) {
		List<Integer> l = new LinkedList<Integer>();
		List<Character> copy = list;
		for(int i = 0; i < copy.size(); i++) {
			char c = copy.get(i);
			if(c == ')') {
				int num = 0;
				int j = i - 1;
				while(j >= 0) {
					if(copy.get(j) == 'a') {
						num++;
					}
					if(copy.get(j) == '(') {
						l.add(num + 1);
						copy.set(i, 'a');
						copy.set(j, 'b');
						break; 
					}
					j--;
				}
			}
		}
		return l;
	}
}
