package model;
public class King extends Base {

    public King(String name, String type, String master, int x, int y){
    	super(name, type, master, x, y);
    	super.des = "ŷ�� ��ų�� ���ϴ�! ���ֽ��ϴ�...";
    	System.out.println("King ����");
    }

    public int attack(){
    	System.out.println("King ������");
    	return 1;
    }
    
    public int move(){
    	System.out.println("King ������");
    	return 1;
    }

	@Override
	public void skill(Base a, Base b) {
		System.out.println("King skill �ߵ�");
		System.out.println("�� ����");
	}
	
	public Movable getRookMoveable(){
		return null;
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}
}