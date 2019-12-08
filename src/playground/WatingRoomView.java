package playground;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Map.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class WaitingRoomView extends JFrame implements ActionListener{
	UserInfo user;
	StatusManager player;
	JLabel winlose = new JLabel("");
	JLabel gameDes = new JLabel("���� ����~~");
	JButton startButton = new JButton("Start!");
	JButton scoreButton = new JButton("Score");
	
	public WaitingRoomView(UserInfo user, StatusManager player) {
		this.user = user;
		this.player = player;
		winlose.setText("Win :  " + user.getWin() +"  Lose :  " + user.getLose());
		setVisible(false);
		setTitle("Wait Playing");
		setSize(500, 500);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		startButton.addActionListener(this);
		scoreButton.addActionListener(this);
		
		Container contentPane = getContentPane();
		
		winlose.setBounds(20, 10, 200, 70);
		gameDes.setBounds(40, 150, 250, 250);
		startButton.setSize(70, 70);
		startButton.setLocation(300, 10);
		scoreButton.setSize(70, 70);
		scoreButton.setLocation(200, 10);
		panel.add(winlose);
		panel.add(gameDes);
		panel.add(startButton);
		panel.add(scoreButton);
		contentPane.add(panel);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startButton)) {
			System.out.println("���� ��ư ����");
			gamestart();
			
		}
		else if (e.getSource().equals(scoreButton)) {
			ScoreView sv = new ScoreView(user);
		}
		
	}
	
	public void gamestart() {
		System.out.println(player.getStatus().getName());
		final Mapmanager Mapcontroller = new Mapmanager(user, player);
		Thread T1 = new Thread() { // ���� ������
			@Override
			public void run() {
				int timer = 0;
				// MinigameManager mini= new MinigameManager(new map(1,"���"));
				while (true) {
					try {
						Mapcontroller.setTimer(timer++); // �����̷� ���Ͽ� ������ �߻������� �����÷��̿� �������
						
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						break; // ���ͷ�Ʈ ĳġ
					} catch (Exception e) {
						e.printStackTrace(); // ���� ĳġ
					}
				}
			}
		};
		T1.start();
		Mapcontroller.setVisible(true);
	}
	
}
