package game;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menu  implements ActionListener{
	
	JFrame frame = new JFrame("TIC TAC TOE");
	JPanel title_panel= new JPanel();
	JLabel textfield = new JLabel();
	JPanel button_panel = new JPanel();
	JButton start=new JButton("Start");
	JButton Rule=new JButton("Rule");
	JButton exit=new JButton("Exit");
	CoCaro s;

	public Menu(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	frame.getContentPane().setBackground(new Color(20,20,30));
	frame.setLayout(new BorderLayout());
	frame.setVisible(true);
	
	textfield.setBackground(new Color(100,25,25));
	textfield.setForeground(new Color(25,255,0));
	textfield.setFont(new Font("ink free", Font.BOLD, 76));
	textfield.setHorizontalAlignment(JLabel.CENTER);
	textfield.setText("Tic Tac Toe");
	textfield.setOpaque(true);
	
	button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));
	button_panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
	button_panel.setBackground(new Color(151, 205, 219));
	
	button_panel.add(start);
	Dimension bDim = new Dimension(200, 200);
	start.setFont(new Font("Courier Prime",Font.BOLD,30));
	start.setFocusable(false);
	start.setPreferredSize(bDim);
	start.setMaximumSize(bDim);
	start.addActionListener(this); 
	
	button_panel.add(Rule);
	Rule.setFont(new Font("Courier Prime",Font.BOLD,30));
	Rule.setFocusable(false);
	Rule.setPreferredSize(bDim);
	Rule.setMaximumSize(bDim);
	Rule.addActionListener(this);

	
	button_panel.add(exit);
	exit.setFont(new Font("Courier Prime",Font.BOLD,30));
	exit.setFocusable(false);
	exit.setPreferredSize(bDim);
	exit.setMaximumSize(bDim);
	exit.addActionListener(this);
	
	title_panel.setLayout(new BorderLayout());
	title_panel.setBounds(0,0,400,100);
	title_panel.add(textfield);
	frame.add(title_panel,BorderLayout.NORTH);
	frame.add(button_panel);
	frame.pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start) {
			s=new CoCaro();
		}
		if(e.getSource()==Rule) {
			if(e.getSource()==Rule) {
				Rule r = new Rule();
			}
//			JOptionPane.showMessageDialog(frame, "Try your best to mark 5 consecutive boxes and not let your opponent do so", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==exit) {
			frame = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frame, "Confirm You Want To Exit", "Tic Tac Toe",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
	 }
}
	 
