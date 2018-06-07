package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.Base;
import model.Game;
import model.Horse;
import model.King;
import model.Pawn;
import model.Rook;
import control.Overseer;

public class ReadyFrame extends JFrame implements ActionListener,MouseListener{
	private PlayerFrame[] PF = new PlayerFrame[2];
	private JPanel WF;
	private int RUReady = 0; 
	private int w = 1000;
	private int h = 678;
	private BaseList B[];
	private Game G;
	public String[] ss;
	public String[] s1;
	public String[] s2;
	public Overseer OV;
	Ost ost = Ost.getInstance();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ReadyFrame(Game g) {
		int i = 0;
		int j = 0;
		
		G = g;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, w+10, h);
		B = new BaseList[5];
		B[0] = new BaseList("��","�ΰ���");
		B[1] = new BaseList("��","�����");
		B[2] = new BaseList("��","�ΰ���");
		B[3] = new BaseList("��","�����");
		B[4] = new BaseList("ŷ","�ΰ���");
		
		ss = new String[1];
		s1 = new String[3];
		s2 = new String[3];
		
		ss[0] = B[4].NT;
		
		s1[0] = "����";
		s1[1] = B[0].NT;
		s1[2] = B[1].NT;
		
		s2[0] = "����";
		s2[1] = B[2].NT;
		s2[2] = B[3].NT;
		
		G.board[4][0] = new King("ŷ","�ΰ���",G.player[0].name,4,0);
		G.board[3][7] = new King("ŷ","�ΰ���",G.player[1].name,3,7);
		
		WF = new JPanel();
		WF.setBorder(new EmptyBorder(5, 5, 5, 5));
		WF.setLayout(null);
		WF.setBounds(0,0,this.w,this.h);;
		
		setContentPane(WF);
		PF[0] = new PlayerFrame(0,0,1,ss,s1,s2);
		PF[0].setBounds(0,0,this.w/2,h);
		PF[0].setVisible(true);
		PF[0].Ready.addMouseListener(this);
		for(i = 0; i < 2 ; i++) {
			for(j = 0; j < 8 ; j++) {
				PF[0].Choose[i][j].addActionListener(this);
			}
		}
		
		PF[1] = new PlayerFrame(w/2,0,2,ss,s1,s2);
		PF[1].setBounds(this.w/2,0,this.w/2,h);
		PF[1].setVisible(true);
		PF[1].Ready.addMouseListener(this);
		for(i = 0; i < 2 ; i++) {
			for(j = 0; j < 8 ; j++) {
				PF[1].Choose[i][j].addActionListener(this);
			}
		}
		
		WF.add(PF[0]);
		WF.add(PF[1]);
		
		
		this.setVisible(true);
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Overseer OV;
		if( e.getSource() == PF[0].getReady() || e.getSource() == PF[1].getReady()) {
			boolean tmp = false;
			this.RUReady = 0;
			
			tmp = PF[0].getRUReady();
			if(tmp == true) {
				RUReady++;
			}
			System.out.println(tmp);
			
			tmp  = PF[1].getRUReady();
			System.out.println(tmp);
			if(tmp == true) {
				RUReady++;
			}
			
			System.out.println(RUReady);
			
			if(RUReady == 2) {
				 ost.stopMusic();
				 OV = new Overseer(G);
				 setVisible(false);

			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		String tmp1 = "";
		String tmp2 = "";
	
		// TODO Auto-generated method stub
			for(i = 0; i < 2 ; i++) {
				for(j = 0 ; j < 2; j++) {
					for(k = 0; k < 8 ; k++) {
						if(e.getSource() == PF[i].Choose[j][k]) {
							System.out.print(j+" ");
							System.out.println(k);
							System.out.println(i);
							if(PF[i].Choose[j][k].getSelectedItem().toString() == "����") {
								if(i == 0) {
									System.out.println("1p�� ��â�� ���ϴ�.");
									G.board[k][1-j] = null;
								}
								else {
									System.out.println("2p�� ��â�� ���ϴ�.");
									G.board[7-k][6+j] = null;
								}
							}
							else {
								for(l = 0; l < 5 ; l++) {
									if(B[l].NT == PF[i].Choose[j][k].getSelectedItem().toString()) {
										tmp1 = B[l].name;
										tmp2 = B[l].type;
									}
								}
								System.out.println(tmp1+tmp2);
								if(i == 0) {
									if(tmp1 == "��") {
										if(G.board[k][1-j] == null) {
											System.out.println("���� ���� ������.");
											G.board[k][1-j] = new Rook(tmp1,tmp2,G.player[0].name,k,1-j); 
										}
										else {
											System.out.println("���� ���� ������.");
											G.board[7-k][6+j] = null;
											G.board[7-k][6+j] = new Rook(tmp1,tmp2,G.player[0].name,k,1-j);
										}
									}
									else if(tmp1 == "ŷ") {
										if(G.board[k][1-j] == null) {
											G.board[k][1-j] = new King(tmp1,tmp2,G.player[0].name,k,1-j);
										}
										else {
											System.out.println("���� �ڸ��� �̹� ���ֽ��ϴ�.");
										}
									}
									else {
										if(G.board[k][1-j] == null) {
											System.out.println("���� ���� ������.");
											G.board[k][1-j] = new Pawn(tmp1,tmp2,G.player[0].name,k,1-j); 
										}
										else {
											System.out.println("���� ���� ������.");
											G.board[k][1-j] = null;
											G.board[k][1-j] = new Pawn(tmp1,tmp2,G.player[0].name,k,1-j);
										}
									}
								}
								else {
									if(tmp1 == "��") {
										if(G.board[7-k][6+j] == null) {
											System.out.println("2p�� ���� ���� ������");
											G.board[7-k][6+j] = new Rook(tmp1,tmp2,G.player[1].name,7-k,6+j); 
										}
										else {
											System.out.println("2p�� ���� ���� ������");
											G.board[7-k][6+j] = null;
											G.board[7-k][6+j] = new Rook(tmp1,tmp2,G.player[1].name,7-k,6+j);
										} 
									}
									else if(tmp1 == "ŷ") {
										if(G.board[7-k][6+j] == null) {
											G.board[7-k][6+j] = new King(tmp1,tmp2,G.player[1].name,7-k,6+j);
										}
										else {
											System.out.println("2p�� ���´� �̹� �����Ǿ����ϴ�.");
										}
									}
									else {
										if(G.board[7-k][6+j] == null) {
											System.out.println("2p�� ���� ���� ������");
											G.board[7-k][6+j] = new Pawn(tmp1,tmp2,G.player[1].name,7-k,6+j); 
										}
										else {
											System.out.println("2p�� ���� ���� ������");
											G.board[7-k][6+j] = null;
											G.board[7-k][6+j]= new Pawn(tmp1,tmp2,G.player[1].name,7-k,6+j);
										} 		
									}
								}
							}
						}
					}
				}
			}	
	}

}
