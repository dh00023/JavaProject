package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

public class Battle_Area extends JFrame{
	
	public ImageIcon[] pic = {
			new ImageIcon("attack_point_o.png"),
			new ImageIcon("move_point_o.png")
	};
	
	private JLayeredPane pane = new JLayeredPane();
	private JPanel bPane, sPane, tPane;
	private JLabel[][] point = new JLabel[8][8];
	private JButton[][] board = new JButton[8][8];
	private JButton attack, move, skill, cancel;
	private JLabel portrait, name, stat, turn;
	private JTextArea des;
	private JProgressBar hp;
	
	Color Brown = new Color(148, 87, 7);
	Color Beige = new Color(242, 184, 109);
	
	//�̰� �� �������� ����. Battle_Area�� �����ڴϱ�, �� ��Ȳ�� ���缭, ��.
	//s,b,t�� ���� Ŭ������ �ٲ� ���� ���� ��. Extends �ؼ�
	public Battle_Area()
	{	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�κ� ü��");
		this.setSize(1000, 678);
		this.add(pane);
		this.setContentPane(pane);
		
		init_bPane();
		init_sPane();
		init_tPane();
	}
	
	public void init_sPane()
	{
		UIManager.put("ProgressBar.selectionForeground", Color.black);
		UIManager.put("ProgressBar.selectionBackground", Color.black);
		
		sPane = new JPanel();
		pane.add(sPane, new Integer(30));
		sPane.setBounds(650, 0, 350, 678);
		sPane.setLayout(null);
		
		portrait = new JLabel();
		sPane.add(portrait);
		portrait.setBounds(20, 50, 100, 100);
		portrait.setBorder(BorderFactory.createLineBorder(Color.black));
		
		name = new JLabel();
		sPane.add(name);
		name.setBounds(205, 50, 100, 30);
		name.setFont(new Font("Monospaced", Font.PLAIN, 20));
		name.setText("Test");
		
		hp = new JProgressBar(0, 50);
		hp.setBounds(150, 100, 150, 30);
		hp.setForeground(Color.green);
		hp.setValue(50);
		hp.setString("50/50");
		hp.setFont(new Font("Monospaced", Font.PLAIN, 15));
		hp.setStringPainted(true);
		sPane.add(hp);
		
		attack = new JButton("�����ϱ�");
		attack.setBackground(Color.gray);
		sPane.add(attack);
		attack.setBounds(20, 200, 100, 70);
		attack.addMouseListener(new MListener());
		
		move = new JButton("�����̱�");
		move.setBackground(Color.gray);
		sPane.add(move);
		move.setBounds(20, 300, 100, 70);
		move.addMouseListener(new MListener());
		
		skill = new JButton("��ų���");
		skill.setBackground(Color.gray);
		sPane.add(skill);
		skill.setBounds(20, 400, 100, 70);
		skill.addMouseListener(new MListener());
		
		cancel = new JButton("���");
		cancel.setBackground(Color.gray);
		sPane.add(cancel);
		cancel.setBounds(20, 500, 100, 70);
		cancel.setEnabled(false);
		//cancel.addActionListener(new AListener());
		
		stat = new JLabel("Atk: - , Def: - ");
		sPane.add(stat);
		stat.setFont(new Font("Monospaced", Font.PLAIN, 20));
		stat.setBounds(150, 130, 200, 100);
		
		des = new JTextArea();
		sPane.add(des);
		des.setBounds(150, 300, 150, 100);
		des.setEditable(false);
		des.setFont(new Font("Monospaced", Font.PLAIN, 15));
		des.setOpaque(false);
		
		turn = new JLabel();
		sPane.add(turn);
		turn.setBounds(20, 590, 100, 30);
		turn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		turn.setText("-�� ����");
	}
	
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
				board[i][j] = new JButton();
				if((i+j)%2 == 0) {board[i][j].setBackground(Brown);}
				else{board[i][j].setBackground(Beige);}
				bPane.add(board[i][j]);
				board[i][j].setBounds(i*80, j*80, 80, 80);
				//board[i][j].addActionListener(new AListener());
				board[i][j].addMouseListener(new MListener());
			}
		}
	}
	
	public void init_tPane()
	{
		tPane = new JPanel();
		pane.add(tPane, new Integer(20));
		tPane.setBounds(0,0,650,678);
		tPane.setOpaque(false);
		tPane.setLayout(null);
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				point[i][j] = new JLabel();
				point[i][j].setVisible(false);
				tPane.add(point[i][j]);

				point[i][j].setBounds(20 + i*80, 20 + j*80, 40, 40);
				//point[i][j].addActionListener(new AListener());
			}
		}
	}
	
	//�� �Լ����� control���� ������ �޾ƿͼ� ����ǰ� ��.
	public void set_mPane()
	{
		//�������� ����
	}
	
	public void set_sPane()
	{
		//status���� ����
	}
	
	public void set_turn()
	{
		//���� �ٲ� �� ����� ��.
	}
	
	public void light_movable()
	{
		//������ �� �ִ� ���� mPane�� ü���� ���� ǥ��
	}
	
	public void light_moveable(int i, int j)
	{
		point[i][j].setVisible(true);
		point[i][j].setIcon(pic[1]);
	}
	
	public void light_attackable()
	{
		//������ �� �ִ� ���� mPane�� ü���� ���� ǥ��
	}
	
	public void light_attackable(int i, int j)
	{
		point[i][j].setVisible(true);
		point[i][j].setIcon(pic[0]);
	}
	
	private class AListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class MListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == attack)
			{
				des.append("�������� ���� --�� ���ݷ����� �������մϴ�.");
			}
			if(e.getSource() == move)
			{
				des.append("�̵��� �� �ִ� ���� ���� ĭ���� �̵��մϴ�.");
			}
			if(e.getSource() == skill)
			{
				des.append("���� Ư���ɷ��� ����մϴ�.(�� �κ��� ������ �޾ƿ� ����)");
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == attack || e.getSource() == move || e.getSource() == skill)
			{
				des.setText("");
			}
			
		}
	
	}
	
}
