package Item;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemlist = new ArrayList<>(); // inventory�� ��������� ArrayList
	Item temp; // ������ �ӽ�����
	/** �κ��丮 ������ �߰� �޼ҵ� */
	public void pushItem(Item I) {
		if (itemlist.size() <= 9) {
			itemlist.add(I);
		}
	}

	/** �κ��丮 ������ ��� �޼ҵ� */
	public Item itemUse(Item I) {
		int i;
		for (i = 0; i < itemlist.size(); i++) {
			if (itemlist.get(i) == I)
				temp = itemlist.get(i);
			if (I.getItemId() == 6 || I.getItemId() == 7 || I.getItemId() == 8)
				itemlist.remove(i);

		}
		return temp;
	}
	public ArrayList<Item> getItemlist(){
		return itemlist;
	}
}