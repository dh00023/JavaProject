package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import model.Base;
import model.Game;
import model.Pawn;
import model.Rook;

public class Battle_Area extends JFrame{
	//��Ʋ ������� �ϳ��� �������Դϴ�.
	public ImageIcon[] pic = {
			new ImageIcon("attack_point_o.png"), //0
			new ImageIcon("move_point_o.png"),   //1
			new ImageIcon("Pawn_R.png"),         //2
			new ImageIcon("Pawn_L.png"),         //3 
			new ImageIcon("Pawn_S.png"),         //4
			new ImageIcon("Move_R.png"),         //5
			new ImageIcon("Move_L.png"),         //6
			new ImageIcon("Move_S.png"),         //7
			new ImageIcon("Siege_L.png"),        //8
			new ImageIcon("Siege_R.png"),        //9
			new ImageIcon("Siege_S.png")         //10
	}; //setIcon�� �� icon���� ���� ��Ƴ��Ҿ��. �̳༮�� ������Ʈ ���� �ȿ� �� ���ϸ��� �׸��� ������ �� �׸��� ������ �ȴ�ϴ�.
	
	private JLayeredPane pane = new JLayeredPane(); //pane�� ���̾�������̿���. �� ���̴��п� �г� �������� ���ĳ��� �� �ִ�ϴ�.
	private JPanel bPane, sPane, tPane;
	private JLabel[][] point = new JLabel[8][8];
	private JButton[][] board = new JButton[8][8];
	private JButton attack, move, skill, cancel;
	private JLabel portrait, name, stat, turn;
	private JTextArea des;
	private JProgressBar hp;
	//���� ����� ������Ʈ���� �� �տ� ������ ���Ҿ��. �� ���ø� �����̺� ������ ���͸� �� �Ʒ��ʿ� ����� ���Ҵ�ϴ�.
	Color Brown = new Color(148, 87, 7);
	Color Beige = new Color(242, 184, 109);
	//�÷��� Ŀ���͸���¡ �� ���Ҿ��! RGB������ ���� ���ϴ� ������ ����� ������ �� �ִ�ϴ�.
	public Battle_Area()
	{	
		this.setResizable(false); //setResizable�� ������ âũ�⸦ �������� ���ϰ� �Ѵ�ϴ�.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� ������ �����Ϸ��� �����Ǿ��.
		this.setTitle("�κ� ü��"); //â�� �̸��� ������ �־��.
		this.setSize(1000, 678); //â�� ũ�⸦ ������ �־��.
		this.add(pane);
		this.setContentPane(pane); //pane�̶�� ���̸� contentPane���� ������ �־����.
		
		//Battle_area���� ������ �г��� �־��! �� ���̵��� �ʱ�ȭ ���ִ°� init_�Լ����̶��ϴ�!
		//�Ʒ��� �Լ��鿡�� �������� ������ �帱����.
		init_bPane(); 
		init_sPane();
		init_tPane();
		//���� Battle_Areaâ�� visible�ϰ� ���ݽô�! �̰ɷ� �����ڰ� �������!
		this.setVisible(true);
	}
	
	//sPane, statusPane�� ���ڿ���. �� ���̴� �����ʿ� ��µǴ� ���¸� ����ϴ� �г��̶��ϴ�.
	public void init_sPane()
	{
		UIManager.put("ProgressBar.selectionForeground", Color.black);
		UIManager.put("ProgressBar.selectionBackground", Color.black);
		//progressBar�� �ؽ�Ʈ������ �ٲ��ֱ� ���� ó������!
		
		sPane = new JPanel(); //���� sPane�� �������ְ�,
		pane.add(sPane, new Integer(30)); //pane�� �ֽ��ϴ�. �ڿ� �ٴ� Integer���� ������ ���� ���� �Ʒ��� �򸮰� �Ǿ��
		sPane.setBounds(650, 0, 350, 678);
		sPane.setLayout(null);
		
		portrait = new JLabel(); 
		sPane.add(portrait);
		portrait.setBounds(20, 50, 100, 100);
		portrait.setBorder(BorderFactory.createLineBorder(Color.black)); //�ʻ�ȭ�� label�̿���. Borderline��
																		 //���������� �־��־����. ��������!
		name = new JLabel();
		sPane.add(name);
		name.setBounds(205, 50, 100, 30);
		name.setFont(new Font("Monospaced", Font.PLAIN, 20));  //�̰� ���� �̸��� ǥ���ϱ����� label
		
		hp = new JProgressBar(0, 50);
		hp.setBounds(150, 100, 150, 30);
		hp.setForeground(Color.green);
		hp.setValue(50);
		hp.setString("50/50");
		hp.setFont(new Font("Monospaced", Font.PLAIN, 15));
		hp.setStringPainted(true);
		sPane.add(hp); //hp�� progressbar
		
		setAttack(new JButton("�����ϱ�"));
		getAttack().setBackground(Color.gray);
		sPane.add(getAttack());
		getAttack().setBounds(20, 200, 100, 70);
		getAttack().setEnabled(false);
		
		setMove(new JButton("�����̱�"));
		getMove().setBackground(Color.gray);
		sPane.add(getMove());
		getMove().setBounds(20, 300, 100, 70);
		getMove().setEnabled(false);
		
		setSkill(new JButton("��ų���"));
		getSkill().setBackground(Color.gray);
		sPane.add(getSkill());
		getSkill().setBounds(20, 400, 100, 70);
		getSkill().setEnabled(false);
		
		setCancel(new JButton("���"));
		getCancel().setBackground(Color.gray);
		sPane.add(getCancel());
		getCancel().setBounds(20, 500, 100, 70);
		getCancel().setEnabled(false); //�ൿ�� ��ư�� �߰������ְ�
		
		stat = new JLabel("Atk: - , Def: - ");
		sPane.add(stat);
		stat.setFont(new Font("Monospaced", Font.PLAIN, 20));
		stat.setBounds(150, 130, 200, 100); //label�� �־�þ��.
		
		setDes(new JTextArea());
		sPane.add(getDes());
		getDes().setBounds(150, 300, 150, 100);
		getDes().setLineWrap(true);
		getDes().setEditable(false);
		getDes().setFont(new Font("Monospaced", Font.PLAIN, 15));
		getDes().setOpaque(false); //��ư�� ���콺�� ������ ��� ������ ��µǰ� �� �ſ���.
		
		turn = new JLabel();
		sPane.add(turn);
		turn.setBounds(20, 590, 200, 30);
		turn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		turn.setText("--------�� ����"); //���� ������ Ȯ�ν����ִ� label
	}
	
	//bPane, boardPane�� ���ڿ���. �� ���̴� ���ʿ� ��µǴ� ���带 ����ϴ� �г��̶��ϴ�.
	public void init_bPane()
	{
		bPane = new JPanel();
		pane.add(bPane, new Integer(10));
		bPane.setBounds(0,0,650,678);
		bPane.setLayout(null);
		
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				getBoard()[i][j] = new JButton();
				if((i+j)%2 == 0) {getBoard()[i][j].setBackground(Brown);}
				else{getBoard()[i][j].setBackground(Beige);} //2�� �������� 0�� 1�ۿ� ���ٴ� ���� �̿��ؼ� ���� �ٲ����
				bPane.add(getBoard()[i][j]);
				getBoard()[i][j].setBounds(j*80, i*80, 80, 80); //i�� j�� ���� ��ǥ�� �������.
				
			}
		}
	}
	
	//tPane�� testPane�� ���ڿ���. �������� �غ��� �����ߴ�ϴ�.
	public void init_tPane()
	{
		tPane = new JPanel();
		pane.add(tPane, new Integer(20)); //���ڰ� bPane���� �����̶� bPane���� ���ʿ� ��ġ�ؿ�.
		tPane.setBounds(0,0,650,678);
		tPane.setOpaque(false); //Opaque�� false�� ������ panel�̿���.
		tPane.setLayout(null);
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				point[i][j] = new JLabel();
				point[i][j].setVisible(false);
				tPane.add(point[i][j]);

				point[i][j].setBounds(20 + j*80, 20 + i*80, 40, 40);
			} //attack, movepoint�� ���� label���̿���.
		}
	}
	
	//�� �Լ����� control���� ������ �޾ƿͼ� ����ǰ� �˴ϴ�.
	
	public void set_bPane(Game game)
	{//Game�� �޾Ƽ� ���带 �ٲٴ� �Լ�����.
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(game.board[i][j] != null)
				{
					if(game.board[i][j].master == game.player[0].name) //�÷��̾ �����Ŀ� ���� pic�� �޶�����
					{
						if(game.board[i][j] instanceof Pawn)
						{//board[i][j]�� �ִ°� pawn�̸�  pawn��
							getBoard()[i][j].setIcon(pic[2]);
						}
						else if(game.board[i][j] instanceof Rook)
						{//Rook�̸� rook��
							getBoard()[i][j].setIcon(pic[5]);
						}
					}
					else
					{
						if(game.board[i][j] instanceof Pawn)
						{
							getBoard()[i][j].setIcon(pic[3]);
						}
						else if(game.board[i][j] instanceof Rook)
						{
							getBoard()[i][j].setIcon(pic[6]);
						}
					}
				}
				else
				{//�ƹ��� ������ �������.
					getBoard()[i][j].setIcon(null);
				}
			}
		}
	}
	
	public void set_sPane(Base b)
	{//sPane�� �ٲ㺸�ƿ�.
		if(b instanceof Pawn)
		{
			portrait.setIcon(pic[4]);
		}
		else if(b instanceof Rook)
		{
			portrait.setIcon(pic[7]);
		}
		
		name.setText(b.name);
		
		hp.setMaximum(500);
		hp.setMinimum(0);
		hp.setValue(b.hp);
		hp.setString(b.hp+"/500");

		getAttack().setEnabled(true);
		getMove().setEnabled(true);
		getSkill().setEnabled(true);
		getCancel().setEnabled(false);
		
		stat.setText("Atk: "+b.atk+" , Def: "+b.def);
	}
	
	public void reset_sPane()
	{//�ƹ��͵� ���õ��� �ʾ����� ���� �Լ�����.
		portrait.setIcon(null);
		name.setText("��������");
		
		hp.setMaximum(0);
		hp.setMinimum(0);
		hp.setValue(0);
		hp.setString("");

		getAttack().setEnabled(false);
		getMove().setEnabled(false);
		getSkill().setEnabled(false);
		getCancel().setEnabled(false);
		
		stat.setText("��������");
	}
	
	public void set_turn(Game game)
	{ //���� �˷��ٶ� ���.
		if(Game.turn == -1)
		{
			turn.setText(game.player[1].name + "�� ��");
		}
		else
		{
			turn.setText(game.player[0].name + "�� ��");
		}
	}
	
	public void light_moveable(int i, int j)
	{//������ �� �ִ°��� setIcon.
		point[i][j].setVisible(true);
		point[i][j].setIcon(pic[1]);
	}
	
	public void light_attackable(int i, int j)
	{//������ �� �ִ� ���� setIcon
		point[i][j].setVisible(true);
		point[i][j].setIcon(pic[0]);
	}
	
	public void dislight()
	{//���� tPane���� ���� �༮���� �� �����ֱ�
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				point[i][j].setVisible(false);
			}
		}
	}
	//���⼭���ʹ� getter setter����.
	public JButton getAttack() {
		return attack;
	}

	public void setAttack(JButton attack) {
		this.attack = attack;
	}

	public JButton[][] getBoard() {
		return board;
	}

	public void setBoard(JButton[][] board) {
		this.board = board;
	}

	public JTextArea getDes() {
		return des;
	}

	public void setDes(JTextArea des) {
		this.des = des;
	}

	public JButton getMove() {
		return move;
	}

	public void setMove(JButton move) {
		this.move = move;
	}

	public JButton getSkill() {
		return skill;
	}

	public void setSkill(JButton skill) {
		this.skill = skill;
	}

	public void set_sPane_guest(Base b) {
		set_sPane(b);
		getAttack().setEnabled(false);
		getMove().setEnabled(false);
		getSkill().setEnabled(false);
		getCancel().setEnabled(false);
	}
	

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
}
