public class Pawn extends Base implements Pawnable {

    public Pawn(String name, String type){
    	super(name, type);
    	System.out.println("Pawn ����");
    }

    public void attack(){
    	System.out.println("Pawn ������");
    }
    
    public void move(){
    	System.out.println("Pawn ������");
    }

	public void status_change(){
		System.out.println("Pawn �ɷº�ȭ");
	}

	@Override
	public void skill() {
		System.out.println("Pawn skill �ߵ�");
	}
}