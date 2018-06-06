package model;

public class Delegator {

	public Delegator() {
	}

	public void move(Base a, int toX, int toY, Base board[][]) {
		if (((Math.abs(a.locX - toX) <= a.spdX) && (a.locY == toY)) || ((Math.abs(a.locY - toY) <= a.spdY) && (a.locX == toX))) {
			System.out.println("�߰��ڰ� �������ݴϴ�");
			if(a.move() == 0){ // ���� ������ �� ������
				return;
			}
			board[toX][toY] = a;
			board[a.locX][a.locY] = null;
			a.locX = toX;
			a.locY = toY;
			System.out.println(a.master + "�� " + a.name + "��(��) " + a.locX + "��" + a.locY + "���� ���������ϴ�.");
			Game.turn *= -1;
		} else {
			System.out.println(a.name + "�� �̵����� ���Դϴ�.");
		}
	}
	
	public void attack(Base a, Base b, Base board[][]) {
		if (Math.abs(a.locX - b.locX) + Math.abs(a.locY - b.locY) <= a.range) {
			System.out.println("�߰��ڰ� ������ �õ����ݴϴ�.");
			if(a.attack() == 0){ // ���� ������ �� ������
				return;
			}
			b.hp -= a.atk - b.def;
			if(b.hp <= 0){
				System.out.println(a.master + "�� " + a.name + "�� �������� " + b.master + "�� " + b.name + "��(��) �׾����ϴ�.");
				board[b.locX][b.locY] = null;
				if(b instanceof King) {
					Game.win();
				}
			}
			else{
				System.out.println(a.master + "�� " + a.name + "�� �������� " + b.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
			}
			Game.turn *= -1;
		} else {
			System.out.println(a.name + "�� ���ݹ��� ���Դϴ�");
		}
	}

	public void skill(Base a, Base board[][]) { // �нú� ��ų�� ���
			System.out.println("�߰��ڰ� ��ų�� ���ݴϴ�.");
			a.skill();
			Game.turn *= -1;
			System.out.println(a.master + "�� " + a.name + "��(��) ��ų�� ����߽��ϴ�");
	}
	
	public void skill(Base a, Base b, Base board[][]) { // ���� ��ų�� ���
		if (Math.abs(a.locX - b.locX) + Math.abs(a.locY - b.locY) <= a.range) {
			System.out.println("�߰��ڰ� ��ų�� ���ݴϴ�.");
			if(a.skill(a, b) == 0){ // ��Ƽ�� ��ų�� ����� �� ������
				return;
			}
			if(b.hp <= 0){
				System.out.println(a.master + "�� " + a.name + "�� ��ų�������� " + b.master + "�� " + b.name + "��(��) �׾����ϴ�.");
				board[b.locX][b.locY] = null;
				if(b instanceof King) {
					Game.win();
				}
			}
			else{
				System.out.println(a.master + "�� " + a.name + "��(��) ��ų������ ����߽��ϴ�");
			}
			Game.turn *= -1;
			
		} else {
			System.out.println(a.name + "�� ��ų���� ���Դϴ�");
		}
	}

	public void equip(Base a, Equipment e) {
		System.out.println("�߰��ڰ� ��� �������ݴϴ�.");
		if (e.getClass().getName().equals("model.Armor") && a.e[0] == null) {
			a.e[0] = e;
			a.def += 3;
			System.out.println(a.master + "�� " + a.name + "���� �ƸӸ� �����մϴ�. ������ 3�����մϴ�." );
		}
		else if (e.getClass().getName().equals("model.Weapon") && a.e[1] == null) {
			a.e[1] = e;
			a.atk += 5;
			System.out.println(a.master + "�� " + a.name + "���� ���⸦ �����մϴ�. ���ݷ��� 5�����մϴ�." );
		}
		else if (e.getClass().getName().equals("model.Leg") && a.e[2] == null) {
			a.e[2] = e;
			a.spdX += 1;
			a.spdY += 1;
			System.out.println(a.master + "�� " + a.name + "���� �ٸ��� �����մϴ�. �̵��Ÿ��� 1�����մϴ�." );
		}
	}
}
