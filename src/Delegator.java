


public class Delegator {

	public Delegator() {
	}

	public void attack(Base a, Base b) {
		if(Math.abs(a.locX - b.locX) + Math.abs(a.locY - b.locY) <= a.range) {
			System.out.println("�߰��ڰ� ������ �õ����ݴϴ�.");
			a.attack();
			b.hp -= a.atk - b.def;
			System.out.println(a.name + "�� �������� " + a.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
			Game.turn *= -1;
		}
		else{
			System.out.println(a.name +"�� ���ݹ��� ���Դϴ�");
		}
	}

	public void move(Base a, int toX, int toY, Base board[][]) {
		System.out.println("�߰��ڰ� �������ݴϴ�");
		a.move();
		board[toX][toY] = a;
		board[a.locX][a.locY] = null;
		a.locX = toX;
		a.locY = toY;
		Game.turn *= -1;
	}

	public void skill(Base a, Base b) {
		System.out.println("�߰��ڰ� ��ų�� ���ݴϴ�.");
		b.skill();
		Game.turn *= -1;
	}

	public void equip(Base b, Equipment e) {
		System.out.println("�߰��ڰ� ��� �������ݴϴ�.");
		Game.turn *= -1;
	}
}
