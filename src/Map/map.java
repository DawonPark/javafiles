package Map;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * �ʿ� ���� Ŭ����
 * @author Chungheon Lee(������)
 *
 */

public class map
{
	/**�� �����̼� ��ġ(��ȣ) ������ ���� {x ��  Z , 0<=x<=8} */
	private int location; 
	
	/**  �� �̸� */
	private String mapName; 
	
	/** �� ��� �� �ȿ� �ִ� ������ ��  */
	private int UserNumber;
	
	/** �� ���� �̹��� */
	private ImageIcon image;
	
	/** flag for thread */
	private boolean flag = false;
	
			
	/** map�� setting �ϴ� map�� ������
	 * @param mylocation  map���� �� ��ġ�� �˷��ִ� ������
	 * @param name        map�� ��ġ�� �̸�
	 */
	public map(int mylocation,String name)
	{
		this.mapName = name;
		this.location = mylocation;
		UserNumber = 0;
	}
	
	
	/** @return �ڱ� ��ġ ��ȯ */
	public int getLoc()
	{
		
		return location;
	}
	
	/** @return �ڽ� �̸� ��ȯ  */
	public String getMapName()
	{
		return mapName;
	}
	
	/** �ڱ� ��Ҹ� setting �ϴ� �޼ҵ� 
	 * @param setlocation �ڱ� ���(��ġ) ����
	 * @param name �ڱ� �̸� ����
	 */
	public void setLoc(int setlocation,String name)
	{
		this.location = setlocation;
		this.mapName = name;
	}
	
	/** �� �� ���� �������� ��ȯ�ϴ� �޼ҵ� 
	 * @return ���� �ڱ� �ڽ� ���� �� ������ ��ȯ
	 */
	public int getUserNumber()
	{
		return UserNumber;
	}
	
	/** �� ���� �������� �����ϴ� �޼ҵ� 
	 * @param number  
	 */
	public void setUserNumber(int number)
	{
		this.UserNumber = number;
	}
	
	/** ���� �̹����� �����ϴ� �޼ҵ� 
	 * @param ima �ڱ� �̹��� ����
	 */
	public void setImage(ImageIcon ima)
	{
		image = (ima);
	}
	
	/** �ڽ��� �̹����� ��ȯ�ϴ� �޼ҵ�
	 * @return �ڱ� �̹��� ��ȯ
	 */
	public ImageIcon getMapImage()
	{
		return image;
	}
	
	/**
	 * ȭ�� �ѱ涧 ���� ������ ���� ������
	 */
	public void setFlag()
	{
		flag=!flag;
	}
	
	/**
	 * @return ������ ��ȯ
	 */
	public boolean getFlag()
	{
		return flag;
	}
}
