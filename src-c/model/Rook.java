package model;

public class Rook extends Base implements Rookable {

	Rookable rk = null; 
	public Siegeable se = null; 
	public Movable mv = null;

	public Rook(String name, String type, String master, int x, int y) {
		super(name, type, master, x, y);
		super.PassiveSkillDescription = "���� ��ų�� ���ϴ�! ��带 ��ȯ�մϴ�!";
    	super.ActiveSkillDescription = "���� ��ų�� ���ϴ�! ��ȭ�Ͽ� �����մϴ�!";
		System.out.println("Rook ����");
		mv = (Movable) this; // ������ Movable�� Rook���� �ٲ��ݴϴ�.
		se = null; // Siegeable�� null�̰��. �̷��� ���� Rook�� Movable�Դϴ�.
		rk = (Rookable) mv;
		activeSkill = 1;
	}

	public int move() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� �������� ���մϴ�.
		{
			System.out.println("�� ��������! Siegeable�̿���!");
			return 0;
		} else {
			System.out.println("Rook ��������!");
			activeSkill = 1;
			return 1;
		}
	}

	@Override
	public void change_form(Rookable rk) {
		this.rk = rk;
	}

	@Override
	public int attack() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� ������ �����մϴ�.
		{
			System.out.println("Rook �����ؿ�!");
			activeSkill = 1;
			return 1;
		} else {
			System.out.println("�� �����ؿ�! Movable�̿���!");
			return 0;
		}
	}

	@Override
	public void skill() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� Skill�� ���� Movable�̵˴ϴ�.
		{
			this.se = null; // se�� null
			this.mv = this; // Rook�� mv�� �ٲ�ϴ�.
			rk = (Rookable) mv;
			System.out.println("���� Movable�̿���!");
		} else {
			this.mv = null;
			this.se = this; // �ݴ��� ��쿡�� �ݴ��.
			rk = (Rookable) se;
			System.out.println("���� Siegeable�̿���!");
		}
		activeSkill = 1;
	}
	
	@Override
	public int skill(Base a, Base b) {
		if (this.mv == null && activeSkill == 1) // ���� ���� �����̸� ��ų�� ���ݴϴ�
		{
			System.out.println("Rook ��Ƽ�� skill �ߵ�");
			b.hp -= a.atk - b.def + 5;
			System.out.println(a.name + "�� ��ų ��ȭ�������� " + a.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
			activeSkill = -1;
			return 1;
		} else {
			System.out.println("���� ��Ƽ�� ��ų�� ����� �� �����ϴ�.");
			return 0;
		}
	}
	
	public Movable getRookMoveable(){
		return mv;
	}

}
