package playground;

/** �÷��̾��� ���¸� �����ϴ� �Ŵ��� Ŭ���� */
public class StatusManager {
	/** �÷��̾��� ����*/
	private GameCharacter player;
	private CharacterSelectView cv;
	
	StatusManager(CharacterSelectView cv){
		this.cv = cv;
		cv.player = player;
	}
	public void setStatus(GameCharacter player) {
		this.player = player;
	}
	
	public GameCharacter getStatus() {
		return player;
	}
}
