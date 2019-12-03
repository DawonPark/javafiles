/*
 * 
 */
package Map;

import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import playground.GameCharacter;

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
	
	/** �� ���� �̹��� */
	private ImageIcon image;
	
	/** �� ���� ������ �̹��� */
	private ImageIcon iconImage;
	
	LinkedList<GameCharacter> AI = new LinkedList<>();
	
	/** flag for thread true �� �ȴݱ�Ű� false�� �ݱ�*/
	private boolean flag = true;
	
			
	/** map�� setting �ϴ� map�� ������
	 * @param mylocation  map���� �� ��ġ�� �˷��ִ� ������
	 * @param name        map�� ��ġ�� �̸�
	 */
	public map(int mylocation,String name)
	{
		this.mapName = name;
		this.location = mylocation;
	}
	
	
	/** @return �ʿ��� �ڱ� ��ġ ��ȯ */
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
	 */
	public void setLoc(int setlocation)
	{
		this.location = setlocation;	
	}
	
	/** �� �� ���� �������� ��ȯ�ϴ� �޼ҵ� 
	 * @return ���� �ڱ� �� ���� �� ������ ��ȯ
	 */
	public int getAINumber()
	{
		return AI.size();
	}
	
	public LinkedList<GameCharacter> getAI(){
		return AI;
	}
	
	/** �� ���� AI�� ���ϴ� �޼ҵ� 
	 * @param number  
	 */
	public void addAI(GameCharacter AImove)
	{
		this.AI.add(AImove);
	}
	
	/**
	 * Pop �ʾ��� AI�� ���� �޼ҵ�.
	 * @param name AI�� �̸�
	 */
	public void popAI(String name)
	{
		for(int i=0; i<AI.size(); i++)
			{	
				if(AI.get(i).getName() == name)
					{	
						AI.remove(AI.get(i));			
					}
			}
	}
	
	/** ���� �̹����� �����ϴ� �޼ҵ� 
	 * @param ima �ڱ� �̹��� ����
	 */
	public void setImage(ImageIcon ima)
	{
		image = (ima);
	}
	
	/** ���� ������ �̹����� �����ϴ� �޼ҵ� 
	 * @param ima �ڱ� ������ �̹��� ����
	 */
	public void setIconImage(ImageIcon ima)
	{
		iconImage = (ima);
	}
	
	/** �ڽ��� �̹����� ��ȯ�ϴ� �޼ҵ�
	 * @return �ڱ� �̹��� ��ȯ
	 */
	public ImageIcon getMapImage()
	{
		return image;
	}
	
	/** �ڽ��� ������ �̹����� ��ȯ�ϴ� �޼ҵ�
	 * @return �ڱ� ������ �̹��� ��ȯ
	 */
	public ImageIcon getIconImage()
	{
		return iconImage;
	}
	
	/**
	 * ȭ�� �ѱ涧 ���� ������ ���� ������
	 */
	public void setFlag()
	{
		flag=!flag;
	}
	
	/** false�� ���� ��Ұ� true�� ���� ���
	 * @return ������ ��ȯ
	 */
	public boolean getFlag()
	{
		return flag;
	}
}
