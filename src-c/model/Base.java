package model;


public abstract class Base{

	public String name;
	String type;
	public String master;
	Equipment[] e = new Equipment[3];
	public int hp;
	public int atk;
	public int def;
	int range; // ���� ����
	public int spdX; // x���� �󸶳� ��������
	public int spdY; // y���� �󸶳� ��������
	public int locX; // ���� ���� x�� ��ġ 
	public int locY; // ���� ���� y�� ��ġ
	public String des;
	
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
		
		if(name.equals("��")) {
			hp += 50;
			atk += 20;
			def += 2;
			spdX += 2;
			spdY += 2;
			range += 1;
		}
		if(type.equals("�����")) {
			hp += 10;
			atk += 5;
			def += 3;
		}
	}
	
	public abstract int move();

	public abstract int attack();
	
	public abstract void skill();

	public void skill(Base a, Base b) {
		// TODO Auto-generated method stub
		
	}
}
