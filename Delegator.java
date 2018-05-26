
public class Delegator {

	public Delegator() {
		// TODO Auto-generated constructor stub
	}

	public void attack(int x, int y, Base b, Base[][] board) {
		System.out.println("�߰��ڰ� ������ �õ����ݴϴ�.");
		b.attack();
		board[x][y].hp -= b.atk - board[x][y].def;
		System.out.println(b.name + "�� �������� " + board[x][y].name + "�� ü���� " + board[x][y].hp + "�� �Ǿ����ϴ�.");
	}

	public void move(int x, int y, Base b, Base[][] board) {
		System.out.println("�߰��ڰ� �������ݴϴ�");
		b.move();
		board[x][y] = b;
		board[b.locX][b.locY] = null;
		b.locX = x;
		b.locY = y;		
	}

	public void skill(int x, int y, Base b, Base[][] board) {
		System.out.println("�߰��ڰ� ��ų�� ���ݴϴ�.");
		b.skill();
	}
	
	public void equip(Base b, Equipment e) {
		System.out.println("�߰��ڰ� ��� �������ݴϴ�.");
	}
}
