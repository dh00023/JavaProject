package model;

import java.util.ArrayList;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UDao udao = new UDao();
		// User table ����! �̰� �ʱ⿡ �ѹ������ְ� �ּ�ó�����ּ���!
//		udao.createUser();
		
		String uname1 = "dahye";
		String uname2 = "����";
		//User �Է� ���࿡ �̹� �����ϴ� �̸��̸� 0 �ƴϸ� 1
		int u1 = udao.insert_record(uname1);
		if(u1==0) {
			System.out.println("�̹� �����ϴ� �̸��Դϴ�. ������ �����ϴ� User������ �ҷ��ɴϴ�.");
			
		}else {
			System.out.println("�������� �ʴ� �̸� �Դϴ�. ���ο� User ������ �����մϴ�..");
		}
		User user1 = udao.findUser(uname1);
		int u2 = udao.insert_record(uname2);
		if(u2==0) {
			System.out.println("�̹� �����ϴ� �̸��Դϴ�. ������ �����ϴ� User������ �ҷ��ɴϴ�.");
			
		}else {
			System.out.println("�������� �ʴ� �̸� �Դϴ�. ���ο� User ������ �����մϴ�..");
		}
		User user2 = udao.findUser(uname2);
		
		
		// �̰���� ������ ���� update
		udao.updateResult(user2.id, "win");
		udao.updateResult(user1.id, "lose");
		
		// ��ü ����Ʈ ��
		ArrayList<User> dtos = udao.list();
		dtos.forEach((user) -> {

			System.out.println("�̸� : "+user.name);
			System.out.println("�� ���Ӽ� : "+user.total);
			System.out.println("lose : "+user.lose);
			System.out.println("win : "+user.win);
			if(user.total!=0) {
				System.out.println("�·� : "+(double) user.win/ (double) user.total * 100.0 + "%");
			}
			
		});
	}

}
