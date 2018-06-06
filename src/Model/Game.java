package Model;

public class Game {

	public Player player[];
	public Base board[][];
	Equipment equipment;
	static int turn;

	public Game() {
		player = new Player[2];
		player[0] = new Player("������");
		player[1] = new Player("�����");
		board = new Base[8][8];
		turn = 1; // 1�Ͻ� �÷��̾�[0]�� ��, -1�Ͻ� �÷��̾�[1]�� ��
	}

	public static void main(String args[]) {
		// ���̺� ���� �� ���ڵ� �߰�
//		DAO dao = new DAO();
//		dao.createHorse();
//		dao.insert_record();
		
		Game g = new Game();

		g.board[4][0] = new Rook("��", "�����", g.player[0].name, 4 , 0);
		g.board[3][1] = new Pawn("��", "�ΰ���", g.player[0].name, 3 , 1);
		g.board[5][1] = new Pawn("��", "�����", g.player[0].name, 5 , 1);
		g.board[3][7] = new Rook("��", "�����", g.player[1].name, 3 , 7);
		g.board[2][6] = new Pawn("��", "�ΰ���", g.player[1].name, 2 , 6);
		g.board[4][6] = new Pawn("��", "�����", g.player[1].name, 4 , 6);

		Game.turn = 1;
	
		g.move(4, 0, 4, 3);
		g.move(3, 7, 3, 4);
		g.attack(4, 3, 2, 6);
		g.attack(4, 3, 2, 7);
		g.attack(4, 3, 3, 4);
		g.skill(4, 3);
		g.skill(3, 4, 4, 3);
		g.skill(3, 4);
		g.attack(4, 3, 3, 4);
		g.skill(3, 4, 4, 3);
		g.equipment = new Weapon();
		g.equip(4, 3, g.equipment);
		g.attack(4, 3, 3, 4);
	}

	public void win() {
		if (turn == 1)
			System.out.println(player[0].name + "��(��) �¸��߽��ϴ�.");
		if (turn == -1)
			System.out.println(player[1].name + "��(��) �¸��߽��ϴ�.");
	}

	public void move(int x, int y, int toX, int toY) {
		if (board[x][y] == null) {
			System.out.println("���� ���� ���ϼ̽��ϴ�.");
		} else {
			if (turn == 1 && board[x][y].master.equals(player[0].name) && board[toX][toY] == null) {
				player[0].move(board[x][y], toX, toY, board);
			} else if (turn == -1 && board[x][y].master.equals(player[1].name) && board[toX][toY] == null) {
				player[1].move(board[x][y], toX, toY, board);
			} else {
				System.out.println("�� �Ǵ� �̵��Ұ��� �߸������ϼ̽��ϴ�.");
			}
		}
	}

	public void attack(int x, int y, int toX, int toY) {
		if (board[x][y] == null || board[toX][toY] == null) {
			System.out.println("���� �߸� �����ϼ̽��ϴ�.");
		} else {
			if (turn == 1 && board[x][y].master.equals(player[0].name)
					&& board[toX][toY].master.equals(player[1].name)) {
				player[0].attack(board[x][y], board[toX][toY], board);
			} else if (turn == -1 && board[x][y].master.equals(player[1].name)
					&& board[toX][toY].master.equals(player[0].name)) {
				player[1].attack(board[x][y], board[toX][toY], board);
			} else {
				System.out.println("���� �߸� �����ϼ̽��ϴ�.");
			}
		}
	}
	
	public void skill(int x, int y) {
		if (board[x][y] == null) {
			System.out.println("���� �߸� �����ϼ̽��ϴ�.");
		} else {
			if (turn == 1 && board[x][y].master.equals(player[0].name)) {
				player[0].skill(board[x][y], board);
			} else if (turn == -1 && board[x][y].master.equals(player[1].name)) {
				player[1].skill(board[x][y], board);
			} else {
				System.out.println("���� �߸� �����ϼ̽��ϴ�.");
			}
		}
	}
	
	public void skill(int x, int y, int toX, int toY) {
		if (board[x][y] == null || board[toX][toY] == null) {
			System.out.println("���� �߸� �����ϼ̽��ϴ�.");
		} else {
			if (turn == 1 && board[x][y].master.equals(player[0].name)
					&& board[toX][toY].master.equals(player[1].name)) {
				player[0].skill(board[x][y], board[toX][toY], board);
			} else if (turn == -1 && board[x][y].master.equals(player[1].name)
					&& board[toX][toY].master.equals(player[0].name)) {
				player[1].skill(board[x][y], board[toX][toY], board);
			} else {
				System.out.println("���� �߸� �����ϼ̽��ϴ�.");
			}
		}
	}

	public void equip(int x, int y, Equipment e) { // e�� 0 ��� 1 ���� 2 �ٸ�
		if (board[x][y] == null) {
			System.out.println("���� �߸� �����ϼ̽��ϴ�.");
		} else {
			if (turn == 1 && board[x][y].master.equals(player[0].name)) {
				player[0].equip(board[x][y], e);
			} else if (turn == -1 && board[x][y].master.equals(player[1].name)) {
				player[1].equip(board[x][y], e);
			} else {
				System.out.println("���� �߸� �����ϼ̽��ϴ�.");
			}
		}
	}
}
