package Model;

public class Weapon extends Equipment{

	public Weapon(Base a, Equipment e) {
		this.equip_type = "Weapon";
		a.e[1] = e;
		a.atk += 5;
		System.out.println(a.master + "�� " + a.name + "���� ���⸦ �����մϴ�. ���ݷ��� 5�����մϴ�." );
	}


}
