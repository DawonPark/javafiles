package playground;

/** �÷��̾��� ���¸� �����ϴ� �Ŵ��� Ŭ���� */
public class StatusManager {
	/** �÷��̾��� ����*/
	GameCharacter player;
	
	/** �÷��̾� ���¸� �����Ѵ�. */
	public void setStatus(GameCharacter cha1) {
		this.player = cha1;
	}
	
	/** �÷��̾� ���¸� ��´�. */
	public GameCharacter getStatus() {
		return player;
	}
}
