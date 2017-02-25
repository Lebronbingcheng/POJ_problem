package Graph;

public class Item {
	int value;
	int level;
	int[] sub_num;
	int[] sub_price;
	
	public Item(int value, int level, int[] sub_num, int[] sun_price) {
		this.value = value;
		this.level = level;
		this.sub_num = sub_num;
		this.sub_price = sun_price;
	}
}
