public class Pawn extends Base implements Pawnable {

    public Pawn(String name, String type, String master, int x, int y){
    	super(name, type, master, x, y);
    	super.des = "���� ��ų�� ���ϴ�! �ι������Ͽ� �����մϴ�!";
    	System.out.println("Pawn ����");
    }

    public int attack(){
    	System.out.println("Pawn ������");
    	return 1;
    }
    
    public int move(){
    	System.out.println("Pawn ������");
    	return 1;
    }

	@Override
	public void skill(Base a, Base b) {
		System.out.println("Pawn skill �ߵ�");
		b.hp -= a.atk - b.def;
		b.hp -= a.atk - b.def;
		System.out.println(a.name + "�� ��ų ���Ӱ������� " + a.master + "�� " + b.name + "�� ü���� " + b.hp + "�� �Ǿ����ϴ�.");
	}
	
	public Movable getRookMoveable(){
		return null;
	}
}