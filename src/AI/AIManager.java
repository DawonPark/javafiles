package AI;

import java.util.LinkedList;

import Map.*;
import playground.*;

/**
 * AI�� ��Ʈ�� �ϴ� Ŭ����
 * @author Chungheon Yi
 *
 */
public class AIManager {

	LinkedList<GameCharacter> AI = new LinkedList<>();
	
	/**
	 * AI�� �����ϴ� AIManager ������ .
	 *
	 * @param �� ��ü�� ���⿡ ���� 
	 */
	public AIManager(map[] puthere)
	{
		String adj[]= {"�ȶ���","������","��������","��û��","�Ϳ���","�����","�����","Ű ū"};
		String name[]= {"����","��","���̺�","ȫ�浿","�����","����","����","����"};
		
		LinkedList<String> names = new LinkedList<>();
		for(int i=0; i<8; i++) names.add(name[i]);                           

		
		for(int i=0; i<5; i++) //AIgenerator i�� �Ѱ� = ai�� ����
			{
			int num =(int)(Math.random()*10)%names.size();
			String Ainame = adj[(int)(Math.random()*10)%8]+" "+
					names.get(num); //�̸� ����  
			
			names.remove(num); //�� �̸��� ����
			
			/**
		   	 * ĳ������ ������ �����Ѵ�.
		   	 * @param name - ĳ���� �̸�
		   	 * @param hp - ĳ���� ü��
		   	 * @param off - ĳ���� ���ݷ�
		   	 * @param def - ĳ���� ����
		   	 * @param agi - ĳ���� ��ø
		   	 * @param image - ĳ���� �̹���
		   	 */
				AI.add(new GameCharacter(Ainame,100,3,3,4,"1.jpg"));
				int popAILocation = (int)(Math.random()*10)%9; //�̰��� ����
				
				puthere[popAILocation].addAI(AI.getLast());
				
				System.out.println(AI.getLast().getName() +" �� "+puthere[popAILocation].getMapName()+"���� �̵�");
				
				
			}
		
		for(int j=0; j<9; j++)
			System.out.println(puthere[j].getMapName()+puthere[j].getAINumber());
	}
	
	/**
	 * AI�� �����̴� Move algorithm.
	 *
	 * @param �� ��ü�� �̰��� ����
	 * @param list ���� �������� �Ǵ��� �ȵǴ��� Ȯ��
	 */
	
	public void MoveAlgorithm(map[] worldMap,final LinkedList<Integer> list) 
	{
		LinkedList<GameCharacter> targetAI = new LinkedList<>(); //AI ���� ����Ʈ 
		
		for(int a=0; a<9; a++)
		{
			for(int b=0; b<worldMap[a].getAINumber(); b++)
			{
				if(worldMap[a].getAI().get(b).getHp()>0)
						targetAI.add(worldMap[a].getAI().get(b)); //��� AI ����
			}
			
			worldMap[a].getAI().clear(); //������ ����
		}
		
		for(int a=0; a<targetAI.size(); a++)
		{
			int move; //�̵��� ��ġ 
			
			if(list.isEmpty()) //���� ��� �ݰ����� �������� �̵�
			{	 
				move= (int)(Math.random()*10)%9;
			}
		else //�ƴϸ� �ݱ��� ���������� �̵�
			{
				move = list.get((int)(Math.random()*10)%list.size());
			}
			
			worldMap[move].addAI(targetAI.get(a));  //�װ��� AI�� �־���
			
			
		}
		
		for(int j=0; j<9; j++) {
			for(int x=0; x<worldMap[j].getAINumber(); x++)
		{
				System.out.print(worldMap[j].getMapName()+" :");
				System.out.print(worldMap[j].getAI().get(x).getName()+" " + worldMap[j].getAI().get(x).getHp()+"\n");
			
			} 
		}
		System.out.println();
	}
	

	/*
	 * 
	public void attackAlgorithm()
	{
		fightManager�� �̵�
	}
	*/
	
	/**
	 * AI�� ���� ���������� ���� �����ϴ�.
	 */
	public void AIgetStronger()
	{
		for(int i=0; i<AI.size(); i++)
		{
			int HPbonus = (AI.get(i).getHp()+12);
			if(HPbonus>=100);
			else AI.get(i).setHp(HPbonus); //100�� ���� ���� 
			
			AI.get(i).setDef(AI.get(i).getDef()+1);
			AI.get(i).setAgi(AI.get(i).getAgi()+1);
			AI.get(i).setOff(AI.get(i).getOff()+2);
			
			//���� 1,��ø1,���ݷ� 2 ����
		
		}
	}
}
