package playground;

/** �÷��̾��� ���¸� �����ϴ� �Ŵ��� Ŭ���� */
public class StatusManager {
	/** �÷��̾��� ����*/
	/**
	* ĳ������ ������ �����Ѵ�.
    * @param name - ĳ���� �̸�
    * @param hp - ĳ���� ü��
    * @param off - ĳ���� ���ݷ�
    * @param def - ĳ���� ����
    * @param agi - ĳ���� ��ø
    * @param image - ĳ���� �̹���
    */
	GameCharacter player;
	
	public void setStatus(GameCharacter cha1) {
		this.player = cha1;
		
	}
	
	public GameCharacter getStatus() {
		return player;
	}
}
