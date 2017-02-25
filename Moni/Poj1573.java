package Moni;

public class Poj1573 {
	public static void main(String[] args) {
		Node[][] array = generate(3,6);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = new Node();
			}
		}
		array[0][0].setN();
		array[0][1].setE();
		array[0][2].setE();
		array[0][3].setS();
		array[0][4].setW();
		array[0][5].setE();
		array[1][0].setW();
		array[1][1].setW();
		array[1][2].setW();
		array[1][3].setE();
		array[1][4].setS();
		array[1][5].setS();
		array[2][0].setS();
		array[2][1].setN();
		array[2][2].setW();
		array[2][3].setW();
		array[2][4].setW();
		array[2][5].setW();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j].direct + " ");
			}
			System.out.println();
		}
	}
	
	public static Node[][] generate(int row, int col) {
		Node[][] array = new Node[row][col];
		return array;
	}
	
	public static void compute(Node[][] array, int start) {
		if(start < 0 || start > array[0].length - 1) return;
		int i = 0;
		while(i > 0 && start > 0) {
			if(array[i][start].direct == 'W') start--;
			if(array[i][start].direct == 'E') start++;
			if(array[i][start].direct == 'S') i++;
			if(array[i][start].direct == 'N') i--;
		}
	}
	

}
