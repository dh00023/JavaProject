package model;

public class Armor extends Equipment{

	public Armor(Base a, Equipment e) {
		this.equip_type = "Armor"; 
		a.e[0] = e;
		a.def += 3;
		System.out.println(a.master + "�� " + a.name + "���� �ƸӸ� �����մϴ�. ������ 3�����մϴ�." );
	}

}