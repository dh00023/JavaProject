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
	public void skill() {
		System.out.println("Pawn skill �ߵ�");
	}
}