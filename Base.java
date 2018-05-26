
public abstract class Base{

	String name;
	String type;
	Equipment[] e = new Equipment[3];
	int hp;
	int atk;
	int def;
	int range; // ���� ����
	int spdX; // x���� �󸶳� ��������
	int spdY; // y���� �󸶳� ��������
	int locX; // ���� ���� x�� ��ġ 
	int locY; // ���� ���� y�� ��ġ
	
	public Base(String name, String type){
		hp = 100;
		atk = 10;
		def = 0;
		range = 2;
		spdX = 1;
		spdY = 1;
		locX = 1;
		locY = 1;
		this.name = name;
		this.type = type;
	}
	
	public abstract void status_change();
	
	public abstract void move();

	public abstract void attack();
	
	public abstract void skill();
}
