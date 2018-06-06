package model;

public abstract class Base{

	public String name;
	public String type;
	public String master;
	public String ActiveSkillDescription;
	public String PassiveSkillDescription;
	public Equipment[] e = new Equipment[3];
	public int maxHp;
	public int hp;
	public int atk;
	public int def;
	public int range; // ���� ����
	public int spdX; // x���� �󸶳� ��������
	public int spdY; // y���� �󸶳� ��������
	public int locX; // ���� ���� x�� ��ġ 
	public int locY; // ���� ���� y�� ��ġ
	public int activeSkill;
	
	public Base(String name, String type, String master, int x, int y){
		
		DAO dao = new DAO();
		Horse horse = dao.findHorse(name, type);
		this.hp = horse.hp;
		this.atk = horse.atk;
		this.def = horse.def;
		this.range = horse.hrange;
		this.spdX = horse.spdX;
		this.spdY = horse.spdY;
		this.name = horse.name;
		this.type = horse.type;
		
//		hp = 150;
//		atk = 10;
//		def = 0;
//		range = 1;
//		spdX = 1;
//		spdY = 1;
		locX = x;
		locY = y;
//		this.name = name;
//		this.type = type;
		this.master = master;
		
//		if(name.equals("��")) {
//			hp -= 50;
//			atk += 20;
//			def += 2;
//			spdX += 2;
//			spdY += 2;
//			range += 1;
//		}
//		if(name.equals("ŷ")) {
//			hp += 100;
//			atk -= 5;
//		}
//		if(type.equals("�����")) {
//			hp += 10;
//			atk += 5;
//			def += 3;
//		}
		maxHp = horse.hp;
	}
	
	public abstract Movable getRookMoveable();
	
	public abstract int move();

	public abstract int attack();
	
	public abstract void skill();
	
	public abstract int skill(Base a, Base b);
}
