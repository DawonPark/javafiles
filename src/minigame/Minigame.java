package minigame;

import javax.swing.ImageIcon;

/** �̴ϰ����� ��Ƶδ� class. ���� Ŭ���� �ʿ��� ���� �� �ʿ��� ��츦 �����ϱ� ���Ͽ�(�� Ŭ������ ��ġ�� �ʹ� ���ž�����) ����Ͽ���.
 * @author Chungheon Yi
 *
 */
public class Minigame extends SuperClassMinigame {

		/** The x. */
		private int x;
		
		/** The y. */
		private int y;
		
		/** ��ǥ�� 4�� ��Ƴ��� �ڽ�(Ŭ���ؼ� �� ��ǥ���� ���� �簢�� �ȿ� ���Ե��ִٸ� ����) */
		private int Point[];
		
		//private boolean reqClick;

	/**
		 * Instantiates a new minigame.
		 * @param ima �̹���
		 * @param strings ���� ����
		 * @param howtoplay �̴ϰ��� ���� 
		 */
		Minigame(ImageIcon ima, String strings,String[] howtoplay) // ���� ����
	{
		super(ima,strings,howtoplay);
		Point = new int[4];
	}
	
	/**
	 * Sets the x.
	 *
	 * @param num x�� ����
	 */
	void setX(int num) {
		x = num;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param num y�� ����
	 */
	void setY(int num) {
		y = num;
	}
	
	/**
	 * Sets X and Y.
	 *
	 * @param num1 x�� ���ڷ� ����
	 * @param num2 y�� ���ڷ� ����
	 */
	void setXY(int num1,int num2) {
		x = num1;
		y=  num2;
	}
	
	/**
	 * Gets the x.
	 * @return the x
	 */
	int getX() {
		return x;
	}
	
	/**
	 * Gets the y.
	 * @return the y
	 */
	int getY() {
		return y;
	}
	
	/**
	 * Sets the point.
	 * @param arr 4���� ��ǥ
	 */
	void setPoint(int[] arr)
	{
		try {
			for(int i=0; i<4; i++)
			{
				Point[i]=arr[i];
			}
		}
		catch(ArrayIndexOutOfBoundsException e) //�Ǽ� ������
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the point.
	 *
	 * @param index �ް���� Point �ε��� ��
	 * @return the point[index]
	 */
	int getPoint(int index)
	{
		return Point[index];
	}
	
	/*
	
	 * Ŭ���� �ʿ����� �� �ʿ������� ���Ͽ� ��ȯ 
	 * 
	 * @return reqClick ��ȯ
	 
	public boolean getreqclick() {
		return reqClick;
	}

	
	/**	reqClick�� Ŭ���� �ʿ����� ���ʿ����� setting
	 * @param bool = setting�� boolean��
	 
	public void setreqClick(boolean bool) {
		reqClick = bool;
	}
	*/
}
