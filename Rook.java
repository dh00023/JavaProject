public class Rook extends Base implements Rookable{

	Rookable rk = null;
	
	public Rook(String name, String type){
    	super(name, type);
    	System.out.println("Rook ����");
    }

    public void move(){
    		System.out.println("Rook ������");
    }

	@Override
	public void change_form(Rookable rk) {
		this.rk = rk;
	}

	@Override
	public void status_change() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void skill() {
		rk.skill();
	}

}
