package playground;

/** Character Ŭ������ ��ӹ��� AI Ŭ���� */
class AI extends Character{
	/** AI�� ��ġ */
	int place;
	/**
   	 * AI�� ������ �����Ѵ�.
   	 * @param name - AI �̸�
   	 * @param hp - AI ü��
   	 * @param off - AI ���ݷ�
   	 * @param def - AI ����
   	 * @param agi - AI ��ø
   	 * @param image - AI �̹���
   	 * @param place - AI ��ġ
   	 */
	AI(String name, int hp, int off, int def, int agi, int place, String image) {
		super(name, hp, off, def, agi, image);
		this.place = place;
	}
}