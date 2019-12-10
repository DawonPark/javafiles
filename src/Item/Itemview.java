package Item;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Mapmanager;
import playground.GameCharacter;

/**�ʿ����� �κ��丮 view Ŭ����
 * @author �ڴٿ�
 *
 */
public class Itemview extends JFrame {
	JLabel des = new JLabel();
	public Itemview(LinkedList<JFrame> getframe, GameCharacter player, Mapmanager manager) {
		Inventory inventory= new Inventory();
		inventory = player.getInventory();
		JFrame frame = new JFrame("Inventory screen");
		
		while (!getframe.isEmpty()) {
			getframe.peekFirst().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getframe.pollFirst().setVisible(false);
		} 
		
		getframe.add(frame);
		frame.setSize(520, 540);
		frame.setLayout(null);
		JButton[] button = new JButton[15];
		JButton out = new JButton();
		ImageIcon[] image= new ImageIcon[11];
		ImageIcon[] manual = new ImageIcon[11];
 		final int[] id= new int[10];
		ArrayList<Item> playerinventory = new ArrayList<Item>();
		playerinventory= inventory.getItemlist();
		for(int i= 0; i<playerinventory.size(); i++) //�÷��̾��� �κ��丮�� Ȯ��
		{	
			
			Item temp = playerinventory.get(i);
			image[i]= temp.getImage();
			manual[i]= temp.getManual();
			
			String name= temp.getName();
			id[i] =temp.getItemId();
			button[i] = new JButton(name,image[i]);
			button[i].setLayout(null);
			if(i<=2)
				button[i].setBounds(100*(i),0,100,100);
			if(2<i && i<6)
				button[i].setBounds(100*(i-3),100,100,100);
			if(6<=i && i<9)
				button[i].setBounds(100*(i-6),200,100,100);
			if(9<=i && i<12)
				button[i].setBounds(100*(i-9),200,100,100);
			frame.add(button[i]);
			Font f1 = new Font("����", Font.PLAIN, 10);
			final int mynum = i;
			System.out.println(mynum);
			des.setBounds(300,0,200,400);
			
			button[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {

                	if(e.getClickCount()==2) //����Ŭ���� ����
                		if(id[mynum]==1||id[mynum]==2||id[mynum]==3||id[mynum]==4||id[mynum]==5||id[mynum]==9||id[mynum]==10||id[mynum]==11) {
					{	System.out.println("click");
						player.setEquip(temp);
						JFrame frame= new JFrame("�����Ϸ�");
						frame.setSize(200,200);
						frame.setLayout(null);
						JLabel set = new JLabel("���� �Ϸ��߽��ϴ�");
						set.setLayout(null);
						set.setBounds(0,10,200,100);
						frame.add(set);
						JButton ok = new JButton("�Ϸ�");
						ok.setLayout(null);
						ok.setBounds(50,100,100,50);
						frame.add(ok);
						ok.addActionListener(new ActionListener() { // �͸�Ŭ������ ������ �ۼ�
							public void actionPerformed(ActionEvent e) {
								frame.dispose();
							}
						});
						
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						System.out.print(player.getEquip()[0].getName());
					}
                }
                }
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

        });
			
		
			button[i].addActionListener(new ActionListener() { // �͸�Ŭ������ ������ �ۼ�
				public void actionPerformed(ActionEvent e) {
				
				des.setIcon(manual[mynum]);
				
				}
			});
		}
	
		out = new JButton("������");
	
		out.addActionListener(new ActionListener() { // �͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e) {
				manager.getMapFrame().setVisible(true);
				manager.getMapFrame().setDefaultCloseOperation(EXIT_ON_CLOSE);
				while (!getframe.isEmpty()) {
					getframe.peekFirst().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					getframe.pollFirst().setVisible(false);
				} // �̰� ������ �˾��� �ߺ��Ǵ� ������ ���ܼ� ���� �ڵ��Դϴ�..Ȯ���� ������
			}
		});
		out.setLayout(null);
		out.setBounds(300, 400, 200, 100);
		frame.add(des);
		frame.add(out);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}