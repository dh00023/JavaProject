
public class Delegator {

	public Delegator() {
	}

	public void attack(Base a, Base b) {
		if (Math.abs(a.locX - b.locX) + Math.abs(a.locY - b.locY) <= a.range) {
			System.out.println("�߰��ڰ� ������ �õ����ݴϴ�.");
			a.attack();
			b.hp -= a.atk - b.def;
			System.out.println(a.name + "�� �������� " + a.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
			Game.turn *= -1;
		} else {
			System.out.println(a.name + "�� ���ݹ��� ���Դϴ�");
		}
	}

	public void move(Base a, int toX, int toY, Base board[][]) {
		if (Math.abs(a.locX - toX) <= a.spdX && Math.abs(a.locY - toY) <= a.spdY) {
			System.out.println("�߰��ڰ� �������ݴϴ�");
			a.move();
			board[toX][toY] = a;
			board[a.locX][a.locY] = null;
			a.locX = toX;
			a.locY = toY;
			Game.turn *= -1;
		} else {
			System.out.println(a.name + "�� �̵����� ���Դϴ�.");
		}
	}

	public void skill(Base a, Base b) {
		if (Math.abs(a.locX - b.locX) + Math.abs(a.locY - b.locY) <= a.range) {
			System.out.println("�߰��ڰ� ��ų�� ���ݴϴ�.");
			b.skill();
			Game.turn *= -1;
		} else {
			System.out.println(a.name + "�� ���ݹ��� ���Դϴ�");
		}
	}

	public void equip(Base b, Equipment e) {
		System.out.println("�߰��ڰ� ��� �������ݴϴ�.");
		if (e.getClass().getName().equals("Armor") && b.e[0] == null) {
			b.e[0] = e;
			b.def += 3;
			System.out.println(b.master + "�� " + b.name + "���� �ƸӸ� �����մϴ�. ������ 3�����մϴ�." );
		}
		else if (e.getClass().getName().equals("Weapon") && b.e[1] == null) {
			b.e[1] = e;
			b.atk += 5;
			System.out.println(b.master + "�� " + b.name + "���� ���⸦ �����մϴ�. ���ݷ��� 5�����մϴ�." );
		}
		else if (e.getClass().getName().equals("Leg") && b.e[2] == null) {
			b.e[2] = e;
			b.spdX += 1;
			b.spdY += 1;
			System.out.println(b.master + "�� " + b.name + "���� �ٸ��� �����մϴ�. �̵��Ÿ��� 1�����մϴ�." );
		}
	}
}
