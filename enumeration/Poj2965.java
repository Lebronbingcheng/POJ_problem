package enumeration;

public class Poj2965 {
	char[][] fr;
	public static void main(String[] args) {
		/*char[][] array = new char[4][4];
		array[0][0] = '-';
		array[0][1] = '+';
		array[0][2] = '-';
		array[0][3] = '-';
		array[1][0] = '-';
		array[1][1] = '-';
		array[1][2] = '-';
		array[1][3] = '-';
		array[2][0] = '-';
		array[2][1] = '-';
		array[2][2] = '-';
		array[2][3] = '-';
		array[3][0] = '-';
		array[3][1] = '+';
		array[3][2] = '-';
		array[3][3] = '-';*/
		char[][] array = new char[4][4];
		array[0][0] = '+';
		array[0][1] = '+';
		array[0][2] = '+';
		array[0][3] = '-';
		array[1][0] = '+';
		array[1][1] = '-';
		array[1][2] = '-';
		array[1][3] = '+';
		array[2][0] = '+';
		array[2][1] = '-';
		array[2][2] = '-';
		array[2][3] = '+';
		array[3][0] = '-';
		array[3][1] = '+';
		array[3][2] = '+';
		array[3][3] = '+';
		
		Poj2965 ex = new Poj2965();
		ex.fr = array;
		//display(ex.fr);
		char[] arr = ex.transfer(ex.fr);
		int[] result = new int[16];
		
		int[] x = ex.compute(array, arr, 0, result, 2, 2);
		for(int i = 0; i < result.length; i++) {
			System.out.print(x[i]+" ");
		}

	}
	
	public static void display(char[][] array) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isOpen(char[][] array) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(array[i][j] == '+') return false;
			}
		}
		return true;
	}
	
	public void turn(int i, int j, char[][] array) {
		if(array[i][j] == '+') {
			array[i][j] = '-';
		}else {
			array[i][j] = '+';
		}
	}
	
	public void change(int i, int j, char[][] array) {
		if(i < 0 || i > 3 || j < 0 || j > 3) return;
		for(int a = 0; a < 4; a++) {
			turn(a, j , array);
		}
		for(int b = 0; b < 4; b++) {
			turn(i, b, array);
		}
		turn(i, j , array);
	}
	
	public char[] transfer(char[][] array) {
		char[] arr = new char[16];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i * 4 + j] = array[i][j];
			}
		}
		return arr;
	}
	
	public int[] compute(char[][] arr, char[] array, int start, int[] result, int count, int num) {
		for(int i = start; i < array.length + 1 - count; i++) {
			result[count - 1] = i;
			if(count - 1 == 0) {
				int j = 0;
				for(j = num - 1; j >= 0; j--) {
					change(result[j] / 4, result[j] % 4, arr);
				}
				display(arr);
				System.out.println();
				if(isOpen(arr)) break;
				for(j = num - 1; j >= 0; j--) {
					change(result[j] / 4, result[j] % 4, arr);
				}
			}else{
				compute(arr, transfer(arr), i+1, result, count - 1, num);
			}
		}
		return result;
	}
}
