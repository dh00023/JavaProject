package model;

public class Pawn extends Base implements Pawnable {
	
	public Pawn(String name, String type, String master, int x, int y) {
		super(name, type, master, x, y);
		super.PassiveSkillDescription = "���� �нú� ��ų�� ���ϴ�. ü���� 5ȸ���˴ϴ�.";
		super.ActiveSkillDescription = "���� ��ų�� ���ϴ�! �ι������Ͽ� �����մϴ�!";
		System.out.println("Pawn ����");
		activeSkill = 1;
	}

	public int attack() {
		System.out.println("Pawn ������");
		activeSkill = 1;
		return 1;
	}

	public int move() {
		System.out.println("Pawn ������");
		activeSkill = 1;
		return 1;
	}

	public void skill() {
		System.out.println("Pawn �нú� skill �ߵ�");
		hp += 5;
		if (hp > maxHp) {
			hp = maxHp;
		}
		activeSkill = 1;
	}

	@Override
	public int skill(Base a, Base b) {
		if (activeSkill == 1) { // ���� ���� �����̸� ��ų�� ���ݴϴ�
			System.out.println("Pawn ��Ƽ�� skill �ߵ�");
			b.hp -= a.atk - b.def;
			b.hp -= a.atk - b.def;
			System.out.println(a.name + "�� ��ų ���Ӱ������� " + a.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
			activeSkill = -1;
			return 1;
		}
		else {
			return 0;
		}
	}

	public Movable getRookMoveable() {
		return null;
	}
}