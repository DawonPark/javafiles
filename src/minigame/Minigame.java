/*
 * 
 */
package minigame;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/** �̴ϰ����� ��Ƶδ� class. Ŭ���ؼ� Ǫ�� ������ �̹����� ���� ���� �����ϴ� ���� 2����
 * @author Chungheon Yi
 *
 */
public class Minigame {
		
	/**  ���� �̹���. */
	private ImageIcon image;

	/**  ���� ��. */
	private String str;

	/**  �̴ϰ��� pause üũ �ϴµ� ���� boolean ��. */
	private boolean isStop = false;
	
	/**  ���ӿ� ���� ������ ��Ƴ��� ���ڿ� �迭, String[0]�� �� �̴ϰ����� �̸�. */
	private String[] list = new String[4];
	
	/**  ���� ���� ��. */
	private int timer =30;
	
	
		/** The x. */
		private int x;
		
		/** The y. */
		private int y;
		
		/** ��ǥ 4���� */
		private int Point[];
	
	/**
	 * set the image, answer, and description of game.
	 *
	 * @param ima image
	 * @param strings answer 
	 * @param howtoplay description of game
	 * 	 */
	public Minigame(ImageIcon ima, String strings,String[] howtoplay) // ���� ����
	{
		this.image = ima;

		str = new String(strings);
		setList(howtoplay);
		
	}
	
	/**
	 * �� ������ ����� ������ �����Ѵ�.Ŭ���� (��ǥO)
	 *
	 * @param ima image of quiz
	 * @param XY thexy
	 * @param howtoplay ���ӿ� ���� ������ ��Ƴ��� ���ڿ� �迭, String[0] name of game 
	 * @Param XY 4 (x,y) for answer
	 */
	public Minigame(ImageIcon ima,int XY[], String[] howtoplay) // ���� ����
	{
		this.image = ima;
		setList(howtoplay);
		
		Point = new int[4];
		setPoint(XY);
		
	}
	
	/**
	 * Sets the x.
	 *
	 * @param num the new x
	 */
	void setX(int num) {
		x = num;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param num the new y
	 */
	void setY(int num) {
		y = num;
	}
	
	/**
	 * Sets X and Y.
	 * @param num1 get x
	 * @param num2 get y
	 */
	void setXY(int num1,int num2) {
		x = num1;
		y=  num2;
		
		if(Point !=null) // �̴ϰ����� Ŭ���̶�� �̰� ����
		{  //(x�ּ�,x�ִ�,y�ּ�,y�ִ�)
			if(Point[0]<=x && Point[1]>=x && Point[2]<=y && Point[3]>=y)
			{
				str = "Ŭ���� ���� ������"; //���� ��ǥ�� �� �簢�� ���̶�� ����� true
			}
			else
				str = "you are wrong"; //�׿� 
		}
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
	 * @param arr the new point
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
	 * @param index the index
	 * @return the point of index
	 */
	int getPoint(int index)
	{
		return Point[index];
	}
	
	/**
	 * return game image.
	 * @return image gameimage
	 */
	public ImageIcon getImage() {
		return image;
	}
	
	/**
	 * Sets the image.
	 * @param ima the new image
	 */
	public void setImage(ImageIcon ima) {
		 image = ima;
	}
	
	
	/**
	 * Gets the timer.
	 * @return timer
	 */
	public int getTimer() {
		return timer;
	}
	
	/**
	 * Sets the timer.
	 * @param timer the new timer
	 */
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	/**
	 * return answer.
	 *
	 * @return str return answer
	 */
	public String getAnswer() {
		return str;
	}

	/**
	 * Sets the answer.
	 *
	 * @param strings the new answer
	 */
	public void setAnswer(String strings) {
		this.str = new String(strings);
	}
	
	/**
	 * return pause check.
	 *
	 * @return isstop pause check
	 */
	public boolean getisStop() {
		return isStop;
	}

	
	/**
	 * 	to check it is paused or not .
	 *
	 * @param bool the new checks if is stop
	 */
	public void setisStop(boolean bool) {
		isStop = bool;
	}
	
	/**
	 * Sets the list.
	 * @param getstring the new list list[0] is the name of minigame
	 */
	public void setList(String[] getstring) // ���� ������ ������´�.
	{
		try{
			for(int i=0; i<4; i++) list[i] = getstring[i]; 
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();  //�Ǽ�����
		}
	}
	
	/**
	 * Gets the list. list[0] is the name of minigame
	 * @param i number of index
	 * @return the list
	 */
	public String getList(int i)
	{
		return list[i];
	}
	
}
