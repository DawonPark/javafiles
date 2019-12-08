package playground;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** �α���, ȸ������ ��� �� ������� ���������� �����ϱ� ���� Ŭ���� */
public class UserInfo {
	/** ����� ���̵� */
	String id;
	/** ����� �г��� */
	String nickname;
	/** ������� �¸� Ƚ�� */
	int win;
	/** ������� �й� Ƚ�� */
	int lose;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://34.236.219.181:3306/OOP_USER";
	static final String USERNAME = "tester";
	static final String PASSWORD = "tester1234";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs;
	
	UserInfo() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
		} catch (SQLException se1) {
			se1.printStackTrace();
			System.out.println("���� �Ұ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String register(String id, String nickname, String pw) {
		try {
			String sql = "SELECT COUNT(*) FROM OOP_player WHERE ID = \"" + id + "\"";
			rs = stmt.executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				return "���̵� �̹� �����մϴ�.";
			} else {
				sql = "INSERT INTO OOP_player VALUES(\"" + id + "\", \"" + nickname + "\", \"" + pw + "\")";
				int rs1 = stmt.executeUpdate(sql);
				sql = "INSERT INTO OOP_score VALUES(\"" + id + "\", 0, 0)";
				rs1 = stmt.executeUpdate(sql);
				return "�Ϸ�";
			}

		} catch (SQLException se1) {
			se1.printStackTrace();
			System.out.println("����!");
			return "����!";
		}
	}

	public String login(String id, String pw) {
		try {
			String sql;
			sql = "SELECT * FROM OOP_player WHERE ID = \"" + id + "\"";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String p = rs.getString("PW");
				if (p.equals(pw)) {
					this.setId(id);
					this.setNn(pw);
					sql = "SELECT * FROM OOP_score WHERE nickname = \"" + nickname + "\"";
					ResultSet rs2 = stmt.executeQuery(sql);
					while (rs2.next()) {
						System.out.println(rs2.getInt("win"));
						System.out.println(rs2.getInt("lose"));
						win = rs2.getInt("win");
						lose = rs2.getInt("lose");
					}
					rs2.close();
					return "�α��� ����!";
				} else
					return "��й�ȣ�� Ʋ���ϴ�.";
			}
		} catch (SQLException se1) {
			se1.printStackTrace();
			System.out.println("���� ����?");
			return "������ �����ϴ�.";
		}
		return "����?";
	}

	public void getScore() {
		
	}

	public void updateMyScore(int win, int lose) {
		this.win = win;
		this.lose = lose;
		try {
			String sql;
			sql = "update score set win=" + this.win + ", lose=" + this.lose + " where nickname=\"" + nickname + "\"";
			int rs = stmt.executeUpdate(sql);
			System.out.println("������Ʈ �Ϸ�");
		} catch (SQLException se1) {
			se1.printStackTrace();
			System.out.println("����");
		}
	}
	
	public void closeGame() {
		try {
			rs.close();
			stmt.close();
			conn.close();
			System.out.println("���� �Ϸ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNn() {
		return nickname;
	}

	public void setNn(String nn) {
		this.nickname = nn;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
}