package playground;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.JLabel;

public class ScoreView extends JFrame {
	private UserInfo user;
	
	public ScoreView(UserInfo user) {
		this.user = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		
		
		//�÷��̾� ����
		JLabel label = new JLabel("���� ����");
		label.setBounds(17, 15, 82, 21);
		contentPane.add(label);
		
		JLabel lblMyRank = new JLabel("d");
		
		lblMyRank.setBounds(17, 48, 82, 21);
		contentPane.add(lblMyRank);
		
		JLabel lblNewLabel = new JLabel("d");
		lblNewLabel.setBounds(316, 48, 82, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("d");
		lblNewLabel_7.setBounds(463, 48, 82, 21);
		contentPane.add(lblNewLabel_7);
		//�÷��̾� ��
		
		
		//���ھ� �г� ����
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(32, 119, 82, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�г���");
		lblNewLabel_2.setBounds(160, 119, 82, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�̱� Ƚ��");
		lblNewLabel_3.setBounds(316, 119, 82, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�� Ƚ��");
		lblNewLabel_4.setBounds(463, 119, 82, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("�̱� Ƚ��");
		lblNewLabel_5.setBounds(316, 15, 82, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("�� Ƚ��");
		lblNewLabel_6.setBounds(463, 15, 82, 21);
		contentPane.add(lblNewLabel_6);
		
		ScorePanel sp = new ScorePanel();
		sp.setBounds(0, 0, 582, 553);
		getContentPane().add(sp);
		
		setVisible(true);
	}
}

class ScorePanel extends JPanel{
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	public ScorePanel() {
		lblNewLabel_8 = new JLabel("����");
		lblNewLabel_8.setBounds(32, 119, 82, 21);
		add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("�г���");
		lblNewLabel_9.setBounds(160, 162, 82, 21);
		add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("�̱� Ƚ��");
		lblNewLabel_10.setBounds(316, 162, 82, 21);
		add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("�� Ƚ��");
		lblNewLabel_11.setBounds(463, 162, 82, 21);
		add(lblNewLabel_11);
	}
	
}
