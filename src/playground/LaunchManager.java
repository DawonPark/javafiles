package playground;

import javax.swing.JFrame;

/** �α��� �� ĳ���� ������ �����ϴ� Ŭ���� */
public class LaunchManager {
	/** ������� ���� */
	UserInfo user;
	
	/** �÷����ϰ� �ִ� ĳ������ ���� */
	StatusManager player;
	LoginView lv;
	
	/** �ʿ��� ������ �����Ѵ�.
	 * @param user - ����� ����
	 * @param player - ĳ���� ����
	 * */
	LaunchManager(UserInfo user, StatusManager player) {
		this.user = user;
		this.player = player;
		lv = new LoginView(user, player);
	}

}