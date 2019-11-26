package minigame;





import Map.Mapmanager;

/**
 * �ΰ��� �����带 �۵���Ű�� launcher class. �ϳ��� �� �÷��� �ð� ��� �� ��ü. �ϳ��� ����
 * @author Chungheon Yi
 */
public class launcher implements Runnable{

	/** The timer. */
	public int timer = 0 ;	
	
	/** The flag 1. */
	public boolean flag1 = true ,flag2 = true;
	
	/** Map�� �����带 �۵���Ű�� T1 Thread. */
	Thread T1;
	
	/** launcher�� �����ϴ� MapController. */
	Mapmanager MapController;
	
	@Override
	public void run()
	{
		
		T1 = null; // Mapmanager�� �� Thread
		
		MapController = new Mapmanager(T1);
		
		Thread T2 = new Thread(){	 //���� ������
			@Override
			public void run(){
				
					//MinigameManager mini= new MinigameManager(new map(1,"���"));
				while(flag1)
				{
				
				try {
						MapController.setTimer(timer++); //�����̷� ���Ͽ� ������ �߻������� �����÷��̿� �������
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
		
	
					
		T2.start();

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
