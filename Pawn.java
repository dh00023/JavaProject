public class Pawn extends Base implements Pawnable {

    public Pawn(String name, String type, String master, int x, int y){
    	super(name, type, master, x, y);
    	super.des = "���� ��ų�� ���ϴ�! �ι������Ͽ� �����մϴ�!";
    	System.out.println("Pawn ����");
    }

    public void attack(){
    	System.out.println("Pawn ������");
    }
    
    public void move(){
    	System.out.println("Pawn ������");
    }

	@Override
	public void skill() {
		System.out.println("Pawn skill �ߵ�");
	}
}