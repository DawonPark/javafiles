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
	public void itemUse(Item I) {
		int i;
		int id=I.getItemId();
		for (i = 0; i < itemlist.size(); i++) {
			if ((id==6&&itemlist.get(i)== I)||(id==7&&itemlist.get(i)== I)&&(id==8&&itemlist.get(i)== I))
				itemlist.remove(i);
		}
		
	}
	public ArrayList<Item> getItemlist(){
		return itemlist;
	}
}