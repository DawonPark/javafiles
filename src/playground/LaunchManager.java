package playground;

import javax.swing.JFrame;

/** �α��� �� ĳ���� ������ �����ϴ� Ŭ���� */
public class LaunchManager {
	/** ������� ���� */
	UserInfo user;
	StatusManager player;
	LoginView lv;
	
	LaunchManager(UserInfo user, StatusManager player) {
		this.user = user;
		this.player = player;
		lv = new LoginView(user, player);
	}

}