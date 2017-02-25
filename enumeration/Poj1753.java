package enumeration;

public class Poj1753 {
	public static void main(String[] args) {
		char[] array = new char[16];
		array[0] = 'b';
		array[1] = 'w';
		array[2] = 'w';
		array[3] = 'b';
		
		array[4] = 'b';
		array[5] = 'b';
		array[6] = 'w';
		array[7] = 'b';
		
		array[8] = 'b';
		array[9] = 'w';
		array[10] = 'w';
		array[11] = 'b';
		
		array[12] = 'b';
		array[13] = 'w';
		array[14] = 'w';
		array[15] = 'w';
		
		int ans = -1;
		char[] chess = array;
		for(int i = 1; i < array.length + 1; i++) {
			int[] result = new int[i];
			compute(chess, 0, result,i,i);
			if(isWhiteorBlack(chess)) {
				ans = i;
				break;
			}
			else {
				chess = array;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean isWhiteorBlack(char[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != array[0]) return false;
		}
		return true;
	}
	
	private static void turn(int i, char[] chess) {
		if(i < 0 || i > 15) return;
		if(chess[i] == 'b') chess[i] = 'w';
		else chess[i] = 'b';
	}
	
	public static void file(int i, char[] chess) {
		turn(i, chess);
		if(i > 3) turn(i - 4, chess);
		if(i < 12) turn(i + 4, chess);
		if(i % 4 != 0) turn(i - 1, chess);
		if((i + 1) % 4 != 0 ) turn(i + 1, chess);
	}
	
	public static void compute(char[] chess, int start, int[] result, int count, int num) {
		for(int i = start; i < chess.length + 1 - count; i++) {
			result[count - 1] = i;
			if(count - 1 == 0) {
				int j = 0;
				for(j = num - 1; j >= 0; j--) {
					file(result[j], chess);
				}
				if(isWhiteorBlack(chess)) {
					return;
				}else {
					for(j = num - 1; j >= 0; j--) {
						file(result[j], chess);
					}
				}
			}else{
				compute(chess, i+1, result, count - 1, num);
			}
		}
	}
}
