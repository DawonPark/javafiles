package minigame;

import Map.Mapmanager;

// TODO: Auto-generated Javadoc
/**
 * �ΰ��� �����带 �۵���Ű�� launcher class. �ϳ��� �� �÷��� �ð� ��� �� ��ü. �ϳ��� ����
 * @author Chungheon Yi
 */
public class launcher implements Runnable{

	/** The timer. */
	public int timer = 0 ;	
	public boolean flag1 = true ,flag2 = true;
	
	@Override
	public void run()
	{
		Mapmanager J = new Mapmanager();
		
		Thread T1 = new Thread(){	 //���� ������
			@Override
			public void run(){
				
					//MinigameManager mini= new MinigameManager(new map(1,"���"));
				while(flag1)
				{
				
				try {
						J.setTimer(timer++); //�����̷� ���Ͽ� ������ �߻������� �����÷��̿� �������
						System.out.println(timer);
						Thread.sleep(1000);
					}
				catch(InterruptedException e)
				{
					break; //���ͷ�Ʈ ĳġ
				}
				catch(Exception e)
				{
					e.printStackTrace(); //���� ĳġ
				}
			}
			}		
		};
		
		Thread T2 = new Thread()  //���� ������ 
				{		
					@Override 
					public void run() {
						
						
							while(flag2) {
						try
						{
							Thread.sleep(1000);
						}
							catch(Exception e)
						{
								break; //���� ĳġ
						}
							}
						}
					};
		
		T1.start();
		//T2.start();
		
	}
	
	/**
	 * Instantiates a new launcher.
	 */
	public launcher()
	{
		Thread T = new Thread(this);
		
		T.run();
		
	}
}
