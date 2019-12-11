package playground;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**ȸ������ ��*/
public class RegisterView {
	
	private JFrame frame;
	/**���̵� �Է� �ʵ�*/
	private JTextField textField;
	/**�г��� �Է� �ʵ�*/
	private JTextField textField_1;
	/**��й�ȣ �Է� �ʵ�*/
	private JTextField textField_2;
	/**��й�ȣ Ȯ�� �ʵ�*/
	private JTextField textField_3;
	/**DB�� �����ϱ� ���� ��ü*/
	private UserInfo user;
	
	/**ȸ�������� �����ϸ� ��ư�� ���¸� �ٲٱ� ���� ����*/
	boolean registerCheck = false;

	/**ȸ������ �� ����
	 * @param user - ����� ����*/
	public RegisterView(UserInfo user) {
		this.user = user;
		initialize();
		frame.setVisible(true);
	}

	/**������ ����*/
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setLocation(screenWidth / 4, screenHeight / 10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 578, 544);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(99, 94, 82, 21);
		panel.add(lblId);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(96, 173, 82, 21);
		panel.add(lblNickname);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(99, 240, 82, 21);
		panel.add(lblPassword);

		JLabel lblPasswordCheck = new JLabel("Password Check");
		lblPasswordCheck.setBounds(91, 316, 152, 21);
		panel.add(lblPasswordCheck);

		textField = new JTextField();
		textField.setBounds(296, 91, 166, 27);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(296, 150, 166, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(296, 237, 166, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(296, 313, 166, 27);
		panel.add(textField_3);
		textField_3.setColumns(10);
		JLabel label = new JLabel("");
		label.setBounds(17, 411, 544, 21);
		panel.add(label);

		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(228, 459, 129, 29);
		panel.add(btnRegister);
		/**ȸ�������� �����ϸ� registerCheck�� true�� �ٲ� �������� ���� �� �ֵ��� �Ѵ�.*/
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(btnRegister)) {
					if (registerCheck == false) {
						if (textField.getText().length() < 4 || textField.getText().length() > 15)
							label.setText("���̵�� 4�� �̻�, 15�� ���Ͽ��� �մϴ�.");
						else if (textField_1.getText().length() < 1 || textField_1.getText().length() > 15)
							label.setText("�г����� 1�� �̻�, 15�� ���Ͽ��� �մϴ�.");
						else if (!(textField_2.getText().equals(textField_3.getText())))
							label.setText("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
						else {
							String result = user.register(textField.getText(), textField_2.getText(), textField_3.getText());
							if (result.equals("�Ϸ�")) {
								result = "ȸ�������� �Ϸ�Ǿ����ϴ�. OK ��ư�� �����ּ���";
								btnRegister.setText("OK");
								registerCheck = true;
							}
							label.setText(result);
						}
					}
					else {
						frame.dispose();
					}
				}

			}
		});

	}
}
