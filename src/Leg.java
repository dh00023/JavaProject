package Model;

public class Leg extends Equipment{

	public Leg(Base a, Equipment e) {
		this.equip_type = "Leg";
		a.e[2] = e;
		a.spdX += 1;
		a.spdY += 1;
		System.out.println(a.master + "�� " + a.name + "���� �ٸ��� �����մϴ�. �̵��Ÿ��� 1�����մϴ�." );
	}

}
