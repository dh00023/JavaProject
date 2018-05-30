public class Rook extends Base implements Rookable {

	Rookable rk = null; // Rookable�� �� �ִ��� �ǹ��Դϴ�... �� �ϴ� �������� �־�����̾ �־����ϴ�.
	public Siegeable se = null; // Siegeable��
	public Movable mv = null; // Movable�� null ������ �� ��͵� �ƴմϴ�.

	public Rook(String name, String type, String master, int x, int y) {
		super(name, type, master, x, y);
		super.des = "���� ��ų�� ���ϴ�! ��带 ��ȯ�մϴ�!";
		System.out.println("Rook ����");
		mv = (Movable) this; // ������ Movable�� Rook���� �ٲ��ݴϴ�.
		se = null; // Siegeable�� null�̰��. �̷��� ���� Rook�� Movable�Դϴ�.
		rk = (Rookable) mv;
	}

	public void move() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� �������� ���մϴ�.
		{
			System.out.println("�� ��������! Siegeable�̿���!");
		} else {
			System.out.println("Rook ��������!");
		}
	}

	@Override
	public void change_form(Rookable rk) {
		this.rk = rk;
	}

	@Override
	public void attack() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� ������ �����մϴ�.
		{
			System.out.println("Rook �����ؿ�!");
		} else {
			System.out.println("�� �����ؿ�! Movable�̿���!");
		}
	}

	@Override
	public void skill() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� Skill�� ���� Movable��
								// �˴ϴ�.
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
	}

}
