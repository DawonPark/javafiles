package minigame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Map.Mapmanager;
import Map.map;
/**
 * �̴ϰ����� �����ϴ� Ŭ����.
 *
 * @author Chungheon Yi
 */

public class MinigameManager extends JFrame implements Runnable {

	
	/** Ÿ�̸ӿ� ���̴� ����. */
	private int timer = 150;
	
	/**  �� �Ŵ��� ���� ������. */
	private Thread myThread;
	
	/** �� Ŭ������ frame. */
	private JFrame frame = new JFrame();
	
	/** ���. */
	private JPanel top = new JPanel();
	
	/** �߰�. */
	private JPanel middle = new JPanel();
	
	/** �ϴ�. */
	private JPanel bot = new JPanel();
	
	/** ���� ���1. */
	private JPanel topright = new JPanel();
	
	/** ���� ��� 2. */
	private JPanel topright1 = new JPanel();
	
	/** ���� ��� */
	private JPanel topleft = new JPanel();
	
	/** Ÿ�̸� ��¿� ��. */
	JLabel times = new JLabel(timer +" ��");

	/** ���� ��ư */
	private JButton bt = new JButton("����");
	
	/** �ؽ�Ʈ �ʵ� */
	private JTextField jp = new JTextField(20);
	
	/** The hp */
	private JProgressBar HP = new JProgressBar(0,100);

	/** Ŭ���� ���콺 ��ǥ x�� */
	private int x;
	
	/** Ŭ���� ���콺 ��ǥ y�� */
	private int y;
	
	/**  ���� ����. */
	private String answer = "��";

	/**  ��� ���. */
	private map currentMap;
	
	/**  ���ӵ�. */
	public static Minigame mini[];

	/**  ���õ� ����. */
	private Minigame currentMinigame;
	
	private Mapmanager manager;
	/**
	 * ������ ������ ���߸� true, Ʋ���� false ��ȯ, �׸��� �ð��ʰ� ������ false ��ȯ.
	 * @return ������ ������ ���߸� true, Ʋ���� false ��ȯ
	 */
	public boolean gameresult() {
		
		if(currentMinigame instanceof Minigame) { //Ŭ�� ������ ���� ���� Ŭ������ �޶���
		answer.replaceAll(" ", "");  //����� ���ڿ� ��ĭ����
		currentMinigame.setAnswer(currentMinigame.getAnswer().replaceAll(" ", ""));  //���� ��ĭ����. ������ġ

		if (timer <= 0) //�ð����� 
			return false;

			try {
				if (answer.equals(currentMinigame.getAnswer())) // �Ȱ����� ���� �ƴϸ� ����
					return true;
				else
					return false;
			} catch (NullPointerException e) // ���� ��Ȳ�� ���� �ȶ�
			{
				e.printStackTrace(); //���� ȣ��
				return false;
			}
		}
		else
		{
			return false; //�ٸ���
		}
	}

	/**
	 *  �� Ŭ������ �����带 �����ϴ� �޼ҵ�.
	 * @param th the new thread
	 */
	public void setThread(Thread th) {
		this.myThread = th;
	}

	/**
	 *  �� Ŭ������ Thread�� ��ȯ�ϴ� �޼ҵ�.
	 * @return the thread
	 */
	public Thread getThread() {
		return this.myThread;
	}

	/**
	 *  ���ӵ� ������, mini[] ���.
	 */
	private void gamesGenerator() {

		currentMinigame = new Minigame(new ImageIcon("image1.PNG"), "��",
				new String[]{"���� ����! ","�̷��� ","�÷���","�ϴ°� "}
				);// ������!

		
		// Minigame(img,answer);
	}
	
	@Override
	public void run() {

		try {
			
			int count = 0; //count
			int currentHP = 89;  //Character�� HP�� ����� ����
			
			int arr[] = new int[] {count,currentHP};  //���� count=0, �ڴ� chracter HP�� ������

			while (timer >= 0 && !myThread.isInterrupted()) {

				System.out.println("minigame manager thread");
				
	
				if (!currentMinigame.getisStop()) { // ����� �ٽ� �÷����ϸ� �����
					times.setText(timer--+" ��"); // 1�ʸ��� Ÿ�̸� 1�ʾ� ����
					manager.IsClosedMap(arr,HP,1);	
				}
				
				
				
				Thread.sleep(1000); // 1�ʾ� sleep. �����̶����� ��Ȯ���� ������ ���� ���࿣ ū ������ ����
			}
		} catch (InterruptedException e) {
			
			// Interrupted catch - while�� ����

		} catch (Exception e) {
			e.printStackTrace(); // �׿� ������ ���
		}
		
		if(timer<=0)
		{
			bt.doClick(); //Ÿ�̸Ӱ� ������ ������ ����
		}
		
	}
	
	  
	
	/**
	 * �̴ϰ����� �����ϰ�, �����ϴ� �Ŵ���.
	 *
	 * @param map
	 */
	public MinigameManager(map m,Mapmanager Manager) {
		
		
		manager = Manager;
		
		final int ROW = 1000; // The row. 	 	
		final int COL = 900; // The col.
		
		
		setThread(new Thread(this));
		gamesGenerator();
			
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		currentMap = m;

		frame.setTitle("���� �׶��� - Minigame"); //Ÿ��Ʋ ���� 
		frame.setLayout(null); //���̾ƿ� ����

		JLabel img = new JLabel(m.getMapImage());
		img.setBounds(2,40,196,178);
		frame.add(img); //���� ��� �� �̹��� ����
		
		JLabel img1 = new JLabel(currentMinigame.getImage());
		middle.add(img1); // �̴����� ����
		
		
		JLabel timelimit = new JLabel("���� �ð�");
		
		timelimit.setBounds(870,10,70,70);
		frame.add(timelimit);
		times.setBounds(870,120,70,70);
		frame.add(times);	
		
	
		HP.setStringPainted(true);
		if(m.getFlag()) HP.setForeground(Color.RED);
		else  HP.setForeground(Color.MAGENTA);
		HP.setBounds(597,194,201,24);
		HP.setValue(74); // ���⿡ Character HP ����
		HP.setStringPainted(true);
		frame.add(HP); //show progressbar
		
		JLabel nameofMap = new JLabel(m.getMapName());
		nameofMap.setBounds(85,0,60,60);
		frame.add(nameofMap);
		
		JLabel[] howtoplay = new JLabel[5]; //���� �̴ϰ��ӿ� ���� ����,
		// howtoplay[0]�� �̴ϰ��� �̸���, howtoplay[4]�� "space�ٸ� ������ �ߴ�" ���
		JLabel how = new JLabel("���� ���� "); // the title
		
		how.setBounds(220,20,100,25);
		frame.add(how); // ���Ӽ��� ��ܿ� ����
		
		JLabel showhp = new JLabel("HP :");
		showhp.setBounds(560,195,30,20); 
		frame.add(showhp); //HP : ��ܿ� add
		
		howtoplay[0] = new JLabel(currentMinigame.getList(0));  
		howtoplay[0].setBounds(220,50,100,25);
		
		howtoplay[4]  = new JLabel("���� ��� �ߴ��� �� �׸��� ��������.");		
		frame.add(howtoplay[0]);
		for(int i=1; i<5; i++)
		{
			if(i!=4)	howtoplay[i] = new JLabel(currentMinigame.getList(i));  
			howtoplay[i].setBounds(220,70+i*20,250,25);
			frame.add(howtoplay[i]);
		}
		
		bot.add(new JLabel("����"));
		bot.add(jp);
		bot.add(bt, BorderLayout.LINE_END);
		
		top.setBounds(0, 0, 200, 220);
		topright.setBounds(800, 0, 195, 100);
		topright1.setBounds(800,100,195,120);
		topleft.setBounds(200,0,600,220);
		middle.setBounds(0, 300, 900, 500);
		bot.setBounds(0, 800, 1000, 300);
		
		top.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		topright.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		topleft.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		topright1.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
		
		frame.add(top);
		frame.add(topright);
		frame.add(topright1);
		frame.add(topleft);
		frame.add(bot);
		
		frame.setSize(ROW, COL);

		frame.setLocation(screenWidth / 4, screenHeight / 10);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		int result = JOptionPane.showConfirmDialog(null, "�̴ϰ��� ���� !\n ���� ����� ����� Ȯ���ϼ���.\n"
				+ "Ȯ���� ������ �����մϴ�.","Ȯ��", JOptionPane.CLOSED_OPTION);
			
			if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {	
				frame.add(middle);	//Ȯ���� ������ �̴ϰ����� ���� 
				myThread.start();
			
			}
		
		//���콺 Ŭ���� �ν��ϴ� addMouseListener
          frame.addMouseListener(new MouseAdapter(){
          
        	  @Override
        	  public void mousePressed(MouseEvent e)
        	  {
        		   x = e.getX();
        		   y = e.getY();
        		   
        		   currentMinigame.setXY(x, y);
        		  
        		   System.out.println(x+" "+y);
        		  
        		  if(x>=2 && x<=198 && y>=70 && y<=246) // ���� ��� �׸��� ������ pause�ǰ� ���� , �� name�� �׸��� �ణ �̴°ɷ� ����
        			 {
        		 currentMinigame.setisStop(!currentMinigame.getisStop());
        		 middle.setVisible(!currentMinigame.getisStop());  //�׸� ������ pause �ǰ� �̴ϰ����� �Ⱥ���
        		 int result = JOptionPane.showConfirmDialog(null, "PAUSE", "�����", JOptionPane.CLOSED_OPTION);

 				if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {
 					currentMinigame.setisStop(!currentMinigame.getisStop());
 	        		middle.setVisible(!currentMinigame.getisStop());
 					}
        		} //�˾� Ȯ�� Ȥ�� ��� ������ �����
        		  
        						 
        	  }
          }
		);
         
			
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ans;

				answer = jp.getText(); // �Է¹��� �ؽ�Ʈ ����
				
				myThread.interrupt();
				
				if (gameresult())
					ans = "�̴ϰ��� ���� ! �������� Ȯ���մϴ�.";
				else
					ans = "�̴ϰ��� ���� ! \n�������� Ȯ������ ���Ͽ����ϴ�.";

				int result = JOptionPane.showConfirmDialog(null, ans, "Ȯ��", JOptionPane.CLOSED_OPTION);

				if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {

					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(false);
					
					
					/**/
					manager.getMapFrame().setVisible(true);
					manager.getMapFrame().setDefaultCloseOperation(EXIT_ON_CLOSE);
					/**/
					
				
					
					// ���� ���� �Ŵ��� ����
				}

			}
		});

	}

}
