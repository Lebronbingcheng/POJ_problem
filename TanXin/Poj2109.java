package TanXin;

public class Poj2109 {
	public static void main(String[] args) {
		System.out.println(tran(2,121));
    }
	
	public static int tran(int n, int p) {
		int num = 0;
		int copy = p;
		while(copy != 0) {
			copy = copy / 10;
			num++;
		}
		double c = (double)num / n;
		int wei = (int) Math.ceil(c);
		int start = (int) Math.pow(10, wei - 1);
		int end = (int) (Math.pow(10, wei)) - 1;
		return compute(n, p, start, end);
	}
	
	public static int compute(int n, int p, int start, int end) {
		if(start > end) return -999;
		int mid = (start + end) / 2;
		int result = (int) Math.pow(mid, n);
		if(result == p) return mid;
		else if(result < p) return compute(n, p, mid, end);
		return compute(n, p, start, mid);
	}

}
