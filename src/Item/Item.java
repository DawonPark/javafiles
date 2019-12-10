package Item;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import minigame.*;
import Map.*;
import playground.*;

/**������ Ŭ����
 * @author �ڴٿ�
 *
 */
public class Item {
	private int itemId; // ������ id
	private int effect; // ������ ȿ��
	private String name;// ������ �̸�
	private ImageIcon manual;// ������ ����
	private ImageIcon image;// ������ �̹���
	private int prob = 0; // ������ ���߷�

	
	/**������ ������
	 * @param result
	 */
	public Item(int result) {
		
	 if(result ==-3) {
			itemId = -3;
			effect = 5;
			prob = 5;
		} // �⺻ ���� ���
	 else if(result ==-4) {
		 itemId =-4;
		 effect =6;
	 }
		else if (result == 1) {
			itemId = 1;
			name = "M16";
			effect = 7; // ������ ���� 1��
			prob = 6;
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���1.PNG"));
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����1.PNG"));
		} else if (result == 2) {
			itemId = 2;
			name = "AK";
			prob = 6;
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���2.PNG"));
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����2.PNG"));
			effect = 10;// ������ ���� 2��
		} else if (result == 3) {
			itemId = 3;
			name = "M4";
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���3.PNG"));
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����3.PNG"));
			prob = 7;
			effect = 13;// ������ ���� 3��
		} else if (result == 4) {
			itemId = 4;
			name = "Kar-98";
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����4.PNG"));
			prob = 4;
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���4.PNG"));
			effect = 22;// ������ ���� 4��
		} else if (result == 5) {
			itemId = 5;
			name = "AWP";
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���5.PNG"));
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����5.PNG"));
			prob = 6;
			effect = 30;// ������ ���� 5��
		} else if (result == 6) {
			itemId = 6;
			name = "���޻���";
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����.PNG"));
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���6.PNG"));
			effect = 30;// ������ ����
		} else if (result == 7) {
			itemId = 7;
			name = "����ź";
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����ź.PNG"));
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���7.PNG"));
			prob = 5;
			effect = 35; // ������ ����ź
		} else if (result == 8) {
			itemId = 8;
			image = new ImageIcon(getClass().getClassLoader().getResource("image/����ź.PNG"));
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���8.PNG"));
			prob = 5;
			effect = -999; // ������ ����ź
		} else if (result == 9) {
			itemId = 9;
			name = "1�� ��";
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���9.PNG"));
			image = new ImageIcon(getClass().getClassLoader().getResource("image/��1.PNG"));
			effect = 20; // ������ ��
		} else if (result == 10) {
			itemId = 10;
			image = new ImageIcon(getClass().getClassLoader().getResource("image/��2.PNG"));
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���10.PNG"));
			name = "2�� ��";
			effect = 30;// ������ ��
		} else if (result == 11) {
			itemId = 11;
			image = new ImageIcon(getClass().getClassLoader().getResource("image/��3.PNG"));
			manual = new ImageIcon(getClass().getClassLoader().getResource("image/�����ۼ���11.PNG"));
			name = "3�� ��";
			effect = 40;// ������ ��
		}
	}
	
	/** �̹��� getter */
	public ImageIcon getManual() {
		return manual;
	}
	/** �̹��� getter */
	public ImageIcon getImage() {
		return image;
	}
	
	/** ������ ���̵� getter */
	public int getItemId() {
		return itemId; // ������ id getter
	}

	/** ������ȿ�� getter */
	public int getEffect() {
		return effect; // ������ ȿ�� getter
	}
	/** �����۸��߷� getter */
	public int getProb() {
		return prob;
	}
	/** ������ȿ�� setter */
	public void setEffect(int effect) {
		this.effect = effect;
	}

	/** �������̸� getter */
	public String getName() {
		return name;
	}
}