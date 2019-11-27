package stat;


import Map.Mapmanager;
/**
 * �ΰ��� �����带 �۵���Ű�� launcher class. �ϳ��� �� �÷��� �ð� ��� �� ��ü. �ϳ��� ����
 * @author Chungheon Yi
 */
public class launcher{

	/** The timer. */
	public int timer = 0 ;	
	
	/** Map�� �����带 �۵���Ű�� T1 Thread. */
	Thread T1;
	
	/** launcher�� �����ϴ� MapController. */
	Mapmanager MapController;
	
	
	public void gameStart()
	{
		
		T1 = null; // Mapmanager�� �� Thread	
		MapController = new Mapmanager(T1);
		
		Thread T2 = new Thread(){	 //���� ������
			@Override
			public void run(){
				
					//MinigameManager mini= new MinigameManager(new map(1,"���"));
				while(true)
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
		gameStart();

		
	}
}
