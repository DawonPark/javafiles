package playground;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//�α���
//�α����̳� ȸ������ ��ư ������ id�� pw���� ������ �ѱ��.
class LoginView extends JFrame implements ActionListener {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://34.236.219.181:3306/OOP_USER";
	static final String USERNAME = "tester";
	static final String PASSWORD = "tester1234";
	private CharacterSelectView cv;
	private JTextField id;
	private JTextField pw;
	private JButton login;
	private JButton signUp;
	private Container c;
	public static final int width = 500;
	public static final int height = 500;

	UserInfo userInfo;
	JFrame frame;

	LoginView(UserInfo ui, CharacterSelectView cv) {
		this.cv = cv;
		userInfo = ui;
		frame = new JFrame("Login");
		frame.setSize(width, height);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		id = new JTextField();
		pw = new JTextField();
		id.setBounds(150, 150, 200, 30);
		pw.setBounds(150, 200, 200, 30);

		panel.add(id);
		panel.add(pw);

		JLabel tid = new JLabel("ID");
		JLabel tpw = new JLabel("PW");
		tid.setBounds(100, 130, 200, 60);
		tpw.setBounds(100, 180, 200, 60);

		panel.add(tid);
		panel.add(tpw);

		login = new JButton("�α���");
		signUp = new JButton("ȸ������");
		login.addActionListener(this);
		signUp.addActionListener(this);
		login.setBounds(100, 350, 100, 80);
		signUp.setBounds(300, 350, 100, 80);
		panel.add(login);
		panel.add(signUp);

		c = frame.getContentPane();

		c.add(panel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(login)) {
			System.out.println("�α��� ��ư ����");
			System.out.println(id.getText());

			Connection conn = null;
			Statement stmt = null;
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				System.out.println("\n- MySQL Connection");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM OOP_player WHERE ID = \"" + id.getText() + "\"";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String p = rs.getString("PW");
					if (p.equals(pw.getText())) {
						System.out.println("�α��� ����!");
						userInfo.setId(id.getText());
						userInfo.setPw(pw.getText());
						sql = "SELECT * FROM OOP_score WHERE ID = \"" + userInfo.getId() + "\"";
						ResultSet rs2 = stmt.executeQuery(sql);
						while (rs2.next()) {
							int win = rs2.getInt("win");
							int lose = rs2.getInt("lose");
							userInfo.setWin(win);
							userInfo.setLose(lose);
						}
						rs.close();
						frame.setVisible(false);
						cv.setVisible(true);
					} else
						System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se1) {
				se1.printStackTrace();
				System.out.println("���� ����?");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			System.out.println("\n\n- MySQL Connection Close");
		}

		if (e.getSource().equals(signUp)) {
			
		}

	}
}