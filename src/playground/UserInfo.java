package playground;

/** �α����� �ϰ� ������� ���������� �����ϱ� ���� Ŭ���� */
class UserInfo {
	/** ����� ���̵� */
	String id;
	/** ����� ��й�ȣ */
	String pw;
	/** ������� �¸� Ƚ�� */
	int win;
	/** ������� �й� Ƚ�� */
	int lose;
	
	/**
   	 * ������� ���̵�� ��й�ȣ�� �����Ѵ�.
   	 * @param id - ����� ���̵�
   	 * @param pw - ����� ��й�ȣ
   	 */
	UserInfo(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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