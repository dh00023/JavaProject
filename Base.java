
public abstract class Base{

	String name;
	String type;
	String master;
	Equipment[] e = new Equipment[3];
	int hp;
	int atk;
	int def;
	int range; // ���� ����
	int spdX; // x���� �󸶳� ��������
	int spdY; // y���� �󸶳� ��������
	int locX; // ���� ���� x�� ��ġ 
	int locY; // ���� ���� y�� ��ġ
	String des;
	
	public Base(String name, String type, String master, int x, int y){
		hp = 100;
		atk = 10;
		def = 0;
		range = 1;
		spdX = 1;
		spdY = 1;
		locX = x;
		locY = y;
		this.name = name;
		this.type = type;
		this.master = master;
		
		if(type.equals("�����")){
			hp += 50;
			atk += 20;
			def += 2;
			spdX += 2;
			spdY += 2;
			range += 1;
		}
	}
	
	public abstract void move();

	public abstract void attack();
	
	public abstract void skill();
}
