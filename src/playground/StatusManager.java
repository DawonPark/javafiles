package playground;

/** �÷��̾��� ���¸� �����ϴ� �Ŵ��� Ŭ���� */
public class StatusManager {
	/** �÷��̾��� ����*/
	private Character player;
	private CharacterSelectView cv;
	
	StatusManager(CharacterSelectView cv){
		this.cv = cv;
		cv.player = player;
	}
	public void setStatus(Character player) {
		this.player = player;
	}
	
	public Character getStatus() {
		return player;
	}
}
