package Map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import minigame.*;




/**
 * �� ���� �Ŵ��� Ŭ����. Thread�� launcher�� �Բ� ���� �÷��̵��� ��� ���ư���.
 * @author Chungheon Yi
 */

public class Mapmanager extends JFrame implements Runnable{
	
	//private statusManager Man; -> ���� stat ������ ����
	String statue;
	
	//prvaite AImanager AI -> ���� AI�Ŵ��� �����ϸ� ����
	
	/** The hp */
	private JProgressBar HP = new JProgressBar(0,100);
	
	/** The my location. */
	private int myLocation = 0; //�ڽ��� ��ġ���ڷ� ����  
	
	/** �� �̸���. �� ���������� ���. */
	private String mapsName[] = {"���","����","�ڿ���","��ȸ��","�ι���","����","�濵��","����","����"};
	
	/** Ÿ�̸�  */
	private int timer = 0; // 
	
	/** �� 9��  */
	private map m[] = new map[9];
	
	/** ��ư 9��*/
	private JButton[] b= new JButton[9]; 
	
	/**Ÿ�̸� ������ ������*/
	private Thread myThread; 
	
	/** �� Ŭ������ Jframe. */
	private JFrame frame = new JFrame();
	
	/** ���� ��� �г� */
	private JPanel top = new JPanel();
	
	/** hp ��� */
	private JLabel forHp = new JLabel(" HP :");
	
	/** ���� ��� */
	private JLabel forDef = new JLabel(" ���� :");
	
	/** ������ġ ���  */
	private JLabel forLoc = new JLabel(" ���� ��ġ :   "+mapsName[myLocation]);	
	
	private JLabel Mytime =new JLabel("                   "+timer);
	/**
	 * �� ��� �̵��Ҷ� Ȯ�� Ȥ�� ��Ҹ� ������ �˾�â�� ���� inner class, JDialog�� ��ü ����
	 * @author Chungheon Yi
	 */
	private class MapLocationPopup extends JFrame
	{
		
		/** �̵� ��ư */
		private JButton Bt1 = new JButton("�̵�");
		
		/** ��� ��ư */
		private JButton Bt2 = new JButton("���");
		
		/** inner class�� JFrame */
		private JFrame thisframe = new JFrame();
		
		/** �ϴ� �г� */
		private JPanel bottom = new JPanel();
		
		/** ��� �г�  */
		private JPanel top = new JPanel();
		
		/**
		 * �̵�  ���� �� fight or startMinigame
		 * @param mv Ŭ���� ��ư�� map�� ���ڷ� ���� 
		 */
		public void moving(map mv) 
		{
			myLocation = mv.getLoc();  //�ڽ��� ��ġ �̰����� �̵�
			forLoc.setText(" ���� ��ġ :   "+mapsName[myLocation]);
			if(mv.getUserNumber()<=1) // start minigame 
			{
				new MinigameManager(mv,Mapmanager.this);
			}		
			else
			{
				//fight manager();
			}
			
	
		}
		/**
		 	Ȯ�� ������ �� �̵�, ��� ������ ���
		 * @param m �ڱ� ��ġ�� �˾Ƴ��� class map �̿�
		 */
		public MapLocationPopup(map M,int num)
		{
			    Toolkit tk = Toolkit.getDefaultToolkit();
			    Dimension screenSize = tk.getScreenSize();
			    int screenHeight = screenSize.height;
			    int screenWidth = screenSize.width;
			   
			thisframe.setTitle(M.getMapName()+"�� �̵�?");
			thisframe.setContentPane(new JLabel(M.getMapImage()));
			
			Bt1.addActionListener(
			
			new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) //Ȯ�� ��ư�� ������ �� ȭ�鿡�� ���� Ȥ�� �̴ϰ��� ȭ������ �̵�
				{ 
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
					thisframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					thisframe.setVisible(false);
					frame.setVisible(false);
					
					moving(m[num]);
				}
			});
			
			Bt2.addActionListener(new ActionListener() //��� ��ư�� �������� ������ ���ư�
			{
				public void actionPerformed(ActionEvent arg0)
				{ 
					
					thisframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					thisframe.setVisible(false);
				}
			});
		
			thisframe.add(Bt1);
			thisframe.add(Bt2);
			
			Bt1.setBounds(100,500,200,100);
			Bt2.setBounds(400,500,200,100);
			
			add(top);
			thisframe.add(Bt1);
			thisframe.add(Bt2);
			thisframe.add(bottom);
		
			setResizable(false);
			 thisframe.setLocation(screenWidth / 3, screenHeight / 7);
			 thisframe.setSize(700,700);
			 thisframe.setVisible(true);	 
			//int result = JOptionPane.showConfirmDialog(null, "����� ���Դϱ�?")
		}
	}
	/**
	 * @return �ڱ� �ڽ� ��ġ ����
	 */
	public map getMyLoc(){  
		return m[myLocation];
	}
	
	/**
	 * @param �ڱ� �ڽ� ��ġ ����
	 */
	public void setMyLoc(int num)  
	{
		this.myLocation = num;
	}
	
	/**
	 * Sets the thread.
	 * @param the thread�� ���ڷ� ����.
	 */
	void setThread(Thread T1)  
	{   
		 myThread = T1 = new Thread(this);
		 
		 // myThread == launcher�� Thread T1
	}
	
	/**
	 * Gets the thread.
	 *
	 * @return the thread
	 */
	public Thread getThread()
	{
		return this.myThread;
	}
	
	/**
	 * Sets the timer. ������ ���Ұ�
	 * @param time the new timer
	 */
	public void setTimer(final int time)
	{
		this.timer = time;
	}
	
	/**
	 * Gets the timer.
	 * @return the timer
	 */
	public int getTimer()
	{
		return timer;
	}
	
	/**
	 * Gets the map frame.
	 * @return the map frame
	 */
	public JFrame getMapFrame()
	{
		return frame;
	}
	
	/**
	 * Sets the map frame.
	 * @param frame the new map frame
	 */
	public void setMapFrame(JFrame frame)
	{
		this.frame = frame;
	}
	
	/**
	 * Sets the hp bar. map, fight, minigame �Ŵ������� ���
	 * @param CharHP the new hp
	 */
	public void setHP(int CharHP,JProgressBar HPBar)
	{
		HPBar.setValue(CharHP);
	}
	
	
	/**
	 * ���� �ݰ����� ������� �����Ͽ��� ���������� ü���� ��´�.
	 *
	 * @param count the count. C++�� ���� ����(&)�� �����ϱ� ���Ͽ� �迭�� ����Ͽ���. ĭ�� �� 1ĭ(count)
	 * @param HPBar �� ��ü���� ���� JProgressBar
	 * @param Threadspeed 1000 = 1, 250 = 4 , 500 = 2 , 100 = 10
	 */
	public void IsClosedMap(int count[],JProgressBar HPBar,double Threadspeed)  //
	{
		// count = a[0];
		
		if(!this.m[myLocation].getFlag())  //flag�� 0�̸� ���� �ݰ��ִ°��̰� 1�̸� ü�� �ȱ���
		{
			HPBar.setForeground(Color.magenta);  //�ڱ��� �ȿ� �ִٰ� ǥ������
			
			if(count[0]++>4*Threadspeed) {   // ���� �������� �� �ִٸ� 4*Threadspeed�� ���Ŀ� ü���� 1 ����
				
					count[0] = 0;
					int hp =100; // character.setHp(character.getHp()-1);
					setHP(--hp,HPBar);  //���� HP�� characterHP ����. �̺κ��� ���� character�� �����Ұ�
			}
		}
		else
		{
			HPBar.setForeground(Color.RED); // ���� ����
		}
	}

	@Override
	public void run()
	{
		try
		{
			int count = 0; //count
			int whattime = 0; //�ð� launcher timer�� ��� ���� ������� Ÿ�̸� 
			boolean notify = true; // notify = �̸� �˶��� boolean
			
			LinkedList<Integer> list = new LinkedList<Integer>(); //�ڱ��� ����� LinkedList
			
			for(int i=0; i<9;i++) list.add(i);      //[0,9]
			Collections.shuffle(list);     //�����ϰ� ����
			
			int[] arr = new int[]{count};  // C++�� ����(&) ����, �����ϴٺ��� ���� ������ �� �ʿ䰡 ���� �Ǿ����� �׳� ����
			
			while(true)
			{

				//System.out.println(timer+"���� - mapmanager"); //Ȯ�ο� print
				Mytime.setText("                   "+timer);  //�ð��� ��� ����
				
				IsClosedMap(arr,HP,(double)10); // arr = ������ ���� ���� ����(C++�� &)�� ���� �迭,
												//HP�� HP��, ������ speed(500millsec*10)
				
				if(!list.isEmpty()) //��� �ݰ�ٸ� ���� ���� ����
					{
						if( notify && whattime>750) //75���Ŀ�, 15���� �̰��� ������ �޴´ٰ� �˷���
						{
							JOptionPane.showConfirmDialog(null, m[list.peekLast()].getMapName()
									+"���� �� �ڱ����� �����˴ϴ�.\n","!!", JOptionPane.CLOSED_OPTION);
						
						notify = false;
					}
					
					whattime++;
					
					if(whattime>900) //90�ʸ��� �ݱ�
						{
									m[list.peekLast()].setFlag();   //�̰��� ����
									JOptionPane.showConfirmDialog(null, m[list.pollLast()].getMapName()+"(��)�� �� �ڱ����� ���⿡ ��ϴ�!\n"
									 		+ "� ����ġ���� !!",
											 "!!", JOptionPane.CLOSED_OPTION);	
							whattime = 0; //Ÿ�̸� ��� �ʱ�ȭ		
							notify = true;
						}	
				}	
				
				Thread.sleep(100); //������ sleep 0.1��	
				}
			}
			catch(InterruptedException e)
			{
				 //���ͷ�Ʈ �Ͼ�� while�� ����
			}
			catch(Exception e)
			{
				e.printStackTrace(); //�׿� ���� üũ
			}
		
	}

	/**
	 * map�� �������ִ� �Ŵ��� ������.
	 */
	public Mapmanager(Thread T1)
	{
		
		final  int ROW = 1000; //ũ�� ���߿� ����
		final  int COL = 1000;
		
		for(int i=0; i<9; i++)
		{
			m[i] = new map(i,mapsName[i]);
		}
		
		
		m[0].setImage(new ImageIcon("image.PNG"));
		m[1].setImage(new ImageIcon("image.PNG"));
		m[2].setImage(new ImageIcon("image.PNG"));
		m[3].setImage(new ImageIcon("image.PNG"));
		m[4].setImage(new ImageIcon("image.PNG"));
		m[5].setImage(new ImageIcon("image.PNG"));
		m[6].setImage(new ImageIcon("image.PNG"));
		m[7].setImage(new ImageIcon("image.PNG"));
		m[8].setImage(new ImageIcon("image.PNG"));
		
		setThread(T1);
		
		frame.setLayout(null);
		
		JPanel topright = new JPanel();
		topright.setBounds(0,90,202,30);
		topright.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
		topright.add(new JLabel(" ĳ���� �̸�"),BorderLayout.CENTER);
		
		top.setBounds(200,0,(ROW)/20+ROW-770,120);
		top.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
		top.setLayout(new BoxLayout(top,BoxLayout.Y_AXIS));
		forHp.setBounds(200,20,40,30);
		forDef.setBounds(200,50,200,30);
		forLoc.setBounds(200,80,200,30);
		
		HP.setStringPainted(true);
		HP.setForeground(Color.RED);
		HP.setValue(74); // ������ hp�� ���⿡ ����
		HP.setStringPainted(true);
		HP.setBounds(240,20,238,30);
		
		
		JLabel timeTitle= new JLabel("                Time");
		timeTitle.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		timeTitle.setBounds(479,0,140,61);
		
		Mytime.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		Mytime.setBounds(479,60,140,60);
		
		
		frame.add(HP);
		frame.add(forHp);
		frame.add(forDef);
		frame.add(forLoc);
		frame.add(Mytime);
		frame.add(timeTitle);
		frame.add(topright);
		frame.add(top);
		
		
		for(int i=0; i<9; i++)
		{
			b[i] = new JButton(mapsName[i]);
		}
		
		JButton Item = new JButton("����");
		
		Item.setBounds((13*ROW)/20,20,ROW-770,100);
		b[0].setBounds(ROW/20,150,ROW-770,ROW-770);
		b[1].setBounds((7*ROW)/20,150,ROW-770,ROW-770);
		b[2].setBounds((13*ROW)/20,150,ROW-770,ROW-770);
		b[3].setBounds(ROW/20,400,ROW-770,ROW-770);
		b[4].setBounds(ROW/20,650,ROW-770,ROW-770);
		b[5].setBounds((7*ROW)/20,400,ROW-770,ROW-770);
		b[6].setBounds((7*ROW)/20,650,ROW-770,ROW-770);
		b[7].setBounds((13*ROW)/20,400,ROW-770,ROW-770);
		b[8].setBounds((13*ROW)/20,650,ROW-770,ROW-770);
		frame.add(Item);
		for(int i=0; i<9; i++)  
		{
			b[i].addActionListener(new ActionListener() //��Ҹ� ������ ���۵Ǵ� �̺�Ʈ
			{
				public void actionPerformed(ActionEvent e)
				{ 
					int i=0;
		            for(i=0; i<9; i++)
		            {
		            	if(e.getSource()==b[i])
		            	{
		            		new MapLocationPopup(m[i],i);
		            		break;
		            	}
		            }
		        }
			}
		);
	
		frame.add(b[i]);
		}
		
		Item.addActionListener(new ActionListener()  //������ ������ ���۵Ǵ� �̺�Ʈ
				{
					public void actionPerformed(ActionEvent e)
					{ 
						// new Item();
					}
				});	
		
		 Toolkit tk = Toolkit.getDefaultToolkit();
		    Dimension screenSize = tk.getScreenSize();
		    int screenHeight = screenSize.height;
		    int screenWidth = screenSize.width;
		   
		    frame.setTitle("���� �׶��� - Map");
			frame.setSize(ROW,COL);
	   
		    frame.setLocation(screenWidth / 4, screenHeight / 10);
		    frame.setVisible(true);
		    frame.setResizable(false);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			myThread.setDaemon(true);
			myThread.start();
	}
	
}