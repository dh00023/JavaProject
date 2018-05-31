package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Game;
import view.Battle_Area;

public class Overseer implements ActionListener, MouseListener{
	//�� ���̴� ��Ʈ�ѷ�����. Game�� Battle_Area�� �� �� ������ �־ �߰��� ������ �Ѵ�ϴ�.
	//ActionListener�� MouseListener�� implement�� ���̿���.
	Game game = null;
	Battle_Area ba = null;
	int state;
	//���� ���� �� �������� �����ִ� ��������. 0�̸� ������ ���� �ִ� ��, 1�̸� ����, 2�� ������, 3�̸� ��ų�� ���� �ִ°ſ���.
	public Overseer(Game g)
	{//Game�� �޾Ƽ�...
		ba = new Battle_Area();//�켱 battle_area�������ְ�
		for(int i = 0;i<8; i++)
		{
			for(int j = 0;j<8;j++)
			{
				ba.getBoard()[i][j].addActionListener(this);
			}
		}//board�鿡�� actionlistener �־��ְ�
		ba.getAttack().addMouseListener(this);
		ba.getAttack().addActionListener(this);
		ba.getMove().addMouseListener(this);
		ba.getMove().addActionListener(this);
		ba.getSkill().addMouseListener(this);
		ba.getSkill().addActionListener(this);
		ba.getCancel().addMouseListener(this);
		ba.getCancel().addActionListener(this);
		//battle_area�� ������Ʈ�鿡�� �����ʵ��� �� �־����.
	
		this.game = g;
		//���� set���ְ�.
		
		ba.set_bPane(g);
		ba.set_turn(g);
		state = 0;
		//�׿� ���缭 set���ְ�.
	}
	//�ֵ��� ���� �Ƚ��.
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(game.turn == 1) //���콺�� ���� print_deses�� �����. �ڿ� ���´�ϴ�.
		{
			print_deses(e, 0);
		}
		else
		{
			print_deses(e, 1);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == ba.getAttack() || e.getSource() == ba.getMove() || e.getSource() == ba.getSkill() || e.getSource() == ba.getCancel())
		{//���콺�� ������ ������ des�� �ٽ� �����ϰ� �����.
			ba.getDes().setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�̰� ������ ��ư���� �׼��� �޴°ſ���.
		for(int i =0; i<8;i++)
		{
			for(int j =0;j<8;j++)
			{
				if(e.getSource() == ba.getBoard()[i][j] && this.state == 0)
				{
					if(game.board[i][j] != null)
					{
						if(game.turn == 1)
						{
							if(game.board[i][j].master == game.player[0].name)
							{
								game.player[0].control(game.board[i][j]);
								ba.set_sPane(game.player[0].get_Base());
							}
							else
							{
								ba.set_sPane_guest(game.board[i][j]);
							}
						}
						else
						{
							if(game.board[i][j].master == game.player[1].name)
							{
								game.player[1].control(game.board[i][j]);
								ba.set_sPane(game.player[1].get_Base());
							}
							else
							{
								ba.set_sPane_guest(game.board[i][j]);
							}
						}
					}
					else
					{
						game.player[0].set_Base(null);
						ba.reset_sPane();
						//�ƹ��͵� ���°��� Ŭ���ϸ� sPane�� ���������.
					}
				}
				//�ൿ�� ���Ϸ��� �� �� �����ư�� ������ �߻��ϴ� �̺�Ʈ���̿���.
				//�� ���� �˰�����, game�� �Լ����� ���� �־��.
				else if(e.getSource() == ba.getBoard()[i][j] && this.state == 1)
				{
					if(game.turn == 1)
					{
						game.attack(game.player[0].get_Base().locX, game.player[0].get_Base().locY, i, j);
					}
					else
					{
						game.attack(game.player[1].get_Base().locX, game.player[1].get_Base().locY, i, j);
					}
					//�Լ����� ������ ������ �Լ��� �����. �̰͵� �ڿ��� ���Ϳ�.
					ready_for_input();
				}
				else if(e.getSource() == ba.getBoard()[i][j] && this.state == 2)
				{
					if(game.turn == 1)
					{
						game.move(game.player[0].get_Base().locX, game.player[0].get_Base().locY, i, j);
					}
					else
					{
						game.move(game.player[1].get_Base().locX, game.player[1].get_Base().locY, i, j);
					}
					ready_for_input();
				}
				else if(e.getSource() == ba.getBoard()[i][j] && this.state == 3)
				{
					if(game.turn == 1)
					{
						game.skill(game.player[0].get_Base().locX, game.player[0].get_Base().locY, i, j);
					}
					else
					{
						game.skill(game.player[1].get_Base().locX, game.player[1].get_Base().locY, i, j);
					}
					ready_for_input();
				}
			}
		}
		///////////////////////////////////
		//���⼭���ʹ� ����, ������, ��ų ��ư�̿���.
		int point[][] = new int[8][8];
		//�̰ɷ� game�� �߰��� attackpoint movepoint�Լ��� ���� �޾Ƽ� ���ٰ� light_attackable, light_moveable�� �� �� �����ؿ�.
		if(e.getSource() == ba.getAttack())
		{
			shift_state(1);
			//shitf_state�� ���� ������ �� ���� �ٲ��ִ� �Լ�����. �ڿ� ���Ϳ�.
			if(game.turn == 1)
			{
				point = game.attackpoint(game.player[0].get_Base());
			}
			else
			{
				point = game.attackpoint(game.player[1].get_Base());
			}
			
			for(int i = 0; i< 8; i++)
			{
				for(int j = 0; j<8; j++)
				{
					if(point[i][j] == 1)
					{
						ba.light_attackable(i, j);
					}
					
				}
			}
		}
		else if(e.getSource() ==ba.getMove())
		{
			shift_state(2);
			
			if(game.turn == 1)
			{
				point = game.movepoint(game.player[0].get_Base());
			}
			else
			{
				point = game.movepoint(game.player[1].get_Base());
			}
			
			for(int i = 0; i< 8; i++)
			{
				for(int j = 0; j<8; j++)
				{
					if(point[i][j] == 1 && game.board[i][j] == null)
					{
						ba.light_moveable(i, j);
					}
					
				}
			}
		}
		else if(e.getSource() ==ba.getSkill())
		{
			shift_state(3);

			if(game.turn == 1)
			{
				point = game.attackpoint(game.player[0].get_Base());
			}
			else
			{
				point = game.attackpoint(game.player[1].get_Base());
			}
			
			for(int i = 0; i< 8; i++)
			{
				for(int j = 0; j<8; j++)
				{
					if(point[i][j] == 1)
					{
						ba.light_attackable(i, j);
					}
					
				}
			}
		}
		else if(e.getSource() ==ba.getCancel())
		{
			shift_state(0);
		}
		
	}

	public void print_deses(MouseEvent e, int num) //�÷��̾ �ƹ� ���̽��� ������ ���� �ʴ� ��츦 �����ϸ� des�� append�����.
	{
		if(game.player[num].get_Base() != null)
		{
			if(e.getSource() == ba.getAttack())
			{
				ba.getDes().append("�������� ���� "+game.player[num].get_Base().atk + "�� ���ݷ����� �������մϴ�.");
			}
			if(e.getSource() == ba.getMove())
			{
				ba.getDes().append("�̵��� �� �ִ� ���� ���� ĭ���� �̵��մϴ�.");
			}
			if(e.getSource() == ba.getSkill())
			{
				ba.getDes().append("���� Ư���ɷ��� ����մϴ�: " +game.player[num].get_Base().des);
			}
			if(e.getSource() == ba.getCancel())
			{
				ba.getDes().append("���� �Ϸ��� �ൿ�� ����մϴ�.");
			}
		}
	}
	
	public void ready_for_input()
	{//bPane�ٲ��ְ�, �� �� ����, state 0���� �����, �� �ٲ��ְ�, sPane ���������.
		ba.set_bPane(this.game);
		ba.dislight();
		this.state = 0;
		ba.set_turn(this.game);
		ba.reset_sPane();
	}
	
	public void shift_state(int num)
	{
		if(num == 0)
		{//cancel�� ���� �� �� ����, state 0���� �����, ��ư���� cancel�����ϰ� enable�����.
			ba.dislight();
			ba.getAttack().setEnabled(true);
			ba.getMove().setEnabled(true);
			ba.getSkill().setEnabled(true);
			ba.getCancel().setEnabled(false);	
		}
		else
		{//0�� �ƴϸ� state�� num���� �ٲٰ� cancel���� enable false�� �����.
			ba.getAttack().setEnabled(false);
			ba.getMove().setEnabled(false);
			ba.getSkill().setEnabled(false);
			ba.getCancel().setEnabled(true);
		}
		state = num;
	}
	
}
