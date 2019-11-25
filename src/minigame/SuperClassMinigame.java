package minigame;

import java.util.List;

import javax.swing.ImageIcon;

/**
 * �̴ϰ����� ��Ƶδ� Ŭ������ super class (Ŭ���� �ʿ���� �̴ϰ��ӿ��� �̿�)
 * 
 * @author Chungheon Yi
 *
 */

public class SuperClassMinigame {

	/** ���� �̹��� */
	private ImageIcon image;

	/** ���� �� */
	private String str;

	/** �̴ϰ��� pause üũ �ϴµ� ���� boolean �� */
	private boolean isStop = false;
	
	/** ���ӿ� ���� ������ ��Ƴ��� ���ڿ� �迭, String[0]�� �� �̴ϰ����� �̸� */
	private String[] list = new String[4];
	
	/**
	 * �� ������ ����� ������ �����Ѵ�.
	 * 
	 * @param ima ������ �̹���
	 * @param strings ������ ����
	 * @param howtoplay ���ӿ� ���� ������ ��Ƴ��� ���ڿ� �迭, String[0]�� �� �̴ϰ����� �̸�
	 */
	SuperClassMinigame(ImageIcon ima, String strings, String[] howtoplay) // ���� ����
	{
		this.image = ima;

		str = new String(strings);
		setList(howtoplay);
	}

	/**
	 * ���� �̹��� ��ȯ
	 * 
	 * @return image �̹��� ��ȯ
	 */
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon ima) {
		 image = ima;
	}
	/**
	 * ���� �� ��ȯ
	 * 
	 * @return str ���� ��ȯ
	 */
	public String getAnswer() {
		return str;
	}

	public void setAnswer(String strings) {
		this.str = new String(strings);
	}
	/**
	 * �̴ϰ��� pause üũ �ϴµ� ���� boolean �� ��ȯ
	 * @return isstop ��ȯ
	 */
	public boolean getisStop() {
		return isStop;
	}

	
	/**	�̴ϰ��� pause üũ �ϴµ� ���� boolean �� setting
	 * @param bool = setting�� boolean��
	 */
	public void setisStop(boolean bool) {
		isStop = bool;
	}
	
	/**
	 * Sets the list.
	 *
	 * @param getstring the new list, list[0]�� �� ���� �̸�
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
	 * Gets the list. list[0]�� �� �̴ϰ��� �̸�
	 *
	 * @param �ε��� ��ȣ
	 * @return the list
	 */
	public String getList(int i)
	{
		return list[i];
	}
}