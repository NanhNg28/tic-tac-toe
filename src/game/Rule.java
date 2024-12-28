package game;

import java.awt.*;
import javax.swing.*;

public class Rule {
	JFrame f =new JFrame();
	TextArea t =new TextArea();
	String nextline=new String("\n");
	Rule(){
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(400, 200);
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);
		f.setResizable(false);
		t.setText("Luat Choi: ngau nhien nguoi choi X,O"+nextline+"duoc chon de di truoc,"
				+ "ai danh duoc 5 o "+nextline+"lien tiep truoc se thang, neu het o ma"+nextline+"khong ai thang thi hoa");
		t.setFont(new Font("ink free", Font.PLAIN, 20));
		t.setForeground(Color.black);
		t.setEditable(false);
		f.add(t);
	}
}