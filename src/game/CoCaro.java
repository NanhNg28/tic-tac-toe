package game;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;

public class CoCaro implements ActionListener {
		Random random= new Random();
		JFrame frame = new JFrame("TIC TAC TOE");
		JPanel title_panel= new JPanel();
		JPanel button_panel = new JPanel();
		JLabel textfield = new JLabel();
		JButton[][] buttons = new JButton[16][16];
		boolean player1_turn;
		//1S
		int xPoint = 0;
		int oPoint = 0;
		JPanel point_panel= new JPanel();
		JLabel textfield2 = new JLabel();
		int turn = 0;
		//1E
		CoCaro() {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800,800);
			frame.getContentPane().setBackground(new Color(20,20,30));
			frame.setLayout(new BorderLayout());
			frame.setVisible(true);
			frame.setResizable(false);

			textfield.setBackground(new Color(100,25,25));
			textfield.setForeground(new Color(25,255,0));
			textfield.setFont(new Font("ink free", Font.BOLD, 76));
			textfield.setHorizontalAlignment(JLabel.CENTER);
			textfield.setText("TIC TAC TOE");
			textfield.setOpaque(true);
			//2S
			textfield2.setBackground(new Color(100,25,25));
			textfield2.setForeground(new Color(25,255,0));
			textfield2.setFont(new Font("ink free", Font.BOLD, 76));
			textfield2.setHorizontalAlignment(JLabel.CENTER);
			textfield2.setText("X ["+ xPoint +"-"+ oPoint +"] O");
			textfield2.setOpaque(true);
			//2E
			title_panel.setLayout(new BorderLayout());
			title_panel.setBounds(0,0,400,100);

			button_panel.setLayout(new GridLayout(16,16));
			button_panel.setBackground(new Color(205,205,205));
			//3S
			point_panel.setLayout(new BorderLayout());
			point_panel.setBounds(0,0,400,100);
			//3E
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					buttons[i][j] =new JButton();
					button_panel.add(buttons[i][j]);
					buttons[i][j].setFocusable(false);
					buttons[i][j].addActionListener(this);
					//4S
					buttons[i][j].setBackground(Color.WHITE);
					buttons[i][j].setBorder(new LineBorder(Color.GRAY, 1));
					//4E
				}

			title_panel.add(textfield);
			frame.add(title_panel,BorderLayout.SOUTH);
			frame.add(button_panel);

			FirstTurn();
			//5S
			point_panel.add(textfield2);
			frame.add(point_panel,BorderLayout.NORTH);
			frame.add(button_panel);

			JPanel panel_14 = new JPanel();
			panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			Container panel = null;
			panel.add(panel_14);
			panel_14.setLayout(new BorderLayout(0, 0));

			JButton btnReset = new JButton("RESET");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<16; i++)
						for(int j=0; j<16; j++) {
							buttons[i][j].setEnabled(true);
							buttons[i][j].setText(null);
						}
				}
			});
			//5E
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					if(e.getSource()==buttons[i][j]) {
						if(player1_turn) {
							if(buttons[i][j].getText()=="") {
								buttons[i][j].setForeground(new Color(255, 0, 0));
								buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
								buttons[i][j].setText("X");
								player1_turn=false;
								textfield.setText("O turn");
								check(i,j);
							}
						} else {
							if(buttons[i][j].getText()=="") {
								buttons[i][j].setForeground(new Color(0, 0, 225));
								buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
								buttons[i][j].setText("O");
								player1_turn=true;
								textfield.setText("X turn");
								check(i,j);
							}
						}
					}
				}
			turn++;
		}
		public void FirstTurn() {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(random.nextInt(2)==0) {
				player1_turn=true;
				textfield.setText("X turn");
			} else {
				player1_turn=false;
				textfield.setText("O turn");
			}
		}

		public  void check(int a, int b) {
			int n=4, TH=0, dem=0;
			int[]c=new int[5];
			c[0]=a;
			int[]d=new int[5];
			d[0]=b;
			while(TH<4) {
				dem=0;
				if(TH==0) {
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a+x][b].getText()) {
							dem++;
							c[dem]=a+x;
							d[dem]=b;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a-x][b].getText()) {
							dem++;
							c[dem]=a-x;
							d[dem]=b;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
				}
				if(TH==1) {
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a+x][b+x].getText()) {
							dem++;
							c[dem]=a+x;
							d[dem]=b+x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a-x][b-x].getText()) {
							dem++;
							c[dem]=a-x;
							d[dem]=b-x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
				}
				if(TH==2) {
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a][b+x].getText()) {
							dem++;
							c[dem]=a;
							d[dem]=b+x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
					for( int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a][b-x].getText()) {
							dem++;
							c[dem]=a;
							d[dem]=b-x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}

				}
				if(TH==3) {
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a-x][b+x].getText()) {
							dem++;
							c[dem]=a-x;
							d[dem]=b+x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
					for(int x=1; x<=n; x++) {
						if(buttons[a][b].getText()==buttons[a+x][b-x].getText()) {
							dem++;
							c[dem]=a+x;
							d[dem]=b-x;
							if(dem==4&&buttons[a][b].getText()=="X")
								xWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
							else if(dem==4&&buttons[a][b].getText()=="O")
								OWins(c[0],c[1],c[2],c[3],c[4],
								      d[0],d[1],d[2],d[3],d[4]);
						} else break;
					}
				}

				TH++;
			}
			//6S
			if(TH==4 && turn==256) {
				TIE();
			}
			//6E
		}
		//7S
		public void RESET() {
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					buttons[i][j].setEnabled(true);
					buttons[i][j].setText("");
					buttons[i][j].setBackground(Color.WHITE);
					turn = 0;
				}
			FirstTurn();
		}
		public void TIE() {
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					buttons[i][j].setEnabled(false);
				}
			textfield.setText("Tie");
			JFrame frame1 = new JFrame("Continue?");
			if (JOptionPane.showConfirmDialog(frame, "Continue?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_NO_OPTION) {
				frame.dispose();
//				System.exit(0);
			}
			RESET();
		}
		//7E
		public void xWins(int a,int b,int c,int d,int e,
		                  int v,int w,int x,int y,int z) {
			buttons[a][v].setBackground(Color.MAGENTA);
			buttons[b][w].setBackground(Color.MAGENTA);
			buttons[c][x].setBackground(Color.MAGENTA);
			buttons[d][y].setBackground(Color.MAGENTA);
			buttons[e][z].setBackground(Color.MAGENTA);
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					buttons[i][j].setEnabled(false);
				}
			textfield.setText("X wins");
			//8S
			xPoint++;
			textfield2.setText("X ["+ xPoint +"-"+ oPoint +"] O");
			JFrame frame1 = new JFrame("Continue?");
			if (JOptionPane.showConfirmDialog(frame, "Continue?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_NO_OPTION) {
				//System.exit(0);
				frame.dispose();
			}
			RESET();
			//8E
		}
		public void OWins(int a,int b,int c,int d,int e,
		                  int v,int w,int x,int y,int z) {
			buttons[a][v].setBackground(Color.MAGENTA);
			buttons[b][w].setBackground(Color.MAGENTA);
			buttons[c][x].setBackground(Color.MAGENTA);
			buttons[d][y].setBackground(Color.MAGENTA);
			buttons[e][z].setBackground(Color.MAGENTA);
			for(int i=0; i<16; i++)
				for(int j=0; j<16; j++) {
					buttons[i][j].setEnabled(false);
				}
			textfield.setText("O wins");
			//9S
			oPoint++;
			textfield2.setText("O ["+ oPoint +"-"+ xPoint +"] X");
			JFrame frame1 = new JFrame("Continue?");
			if (JOptionPane.showConfirmDialog(frame, "Continue?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_NO_OPTION) {
//				System.exit(0);
				frame.dispose();
			}
			RESET();
			//9E
		}
}