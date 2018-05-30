public class Rook extends Base implements Rookable {

	Rookable rk = null; 
	public Siegeable se = null; 
	public Movable mv = null;

	public Rook(String name, String type, String master, int x, int y) {
		super(name, type, master, x, y);
		super.des = "���� ��ų�� ���ϴ�! ��带 ��ȯ�մϴ�!";
		System.out.println("Rook ����");
		mv = (Movable) this; // ������ Movable�� Rook���� �ٲ��ݴϴ�.
		se = null; // Siegeable�� null�̰��. �̷��� ���� Rook�� Movable�Դϴ�.
		rk = (Rookable) mv;
	}

	public int move() {
		if (this.mv == null) // mv�� null, �� se�� null�� �ƴ϶� �������� ���մϴ�.
		{
			System.out.println("�� ��������! Siegeable�̿���!");
			return 0;
		} else {
			System.out.println("Rook ��������!");
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
			return 1;
		} else {
			System.out.println("�� �����ؿ�! Movable�̿���!");
			return 0;
		}
	}

	@Override
	public void skill(Base a, Base b) {
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
	}
	
	public Movable getRookMoveable(){
		return mv;
	}

}
