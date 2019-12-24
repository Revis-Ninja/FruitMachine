//ZHENG ZHAOHUO
//2455448z

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PrintGUI extends JFrame implements ActionListener {

public JButton Spin, NewGame;
public JLabel label1, label2,label1Temp, labelTemp=new JLabel(" "), labelBalance;
public JPanel panel1, panel2, panel3,panel4;
public Model m;
public Cards card ;

public Graphics2D G2;


	public PrintGUI(Model m){
		this.m = m;
		card = new Cards(this.m);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Fruit Machine");
		setSize(600,400);
		setLocation(100,100);
		Spin = new JButton("Spin");	
		Spin.addActionListener(this);
	
		NewGame = new JButton("New Game");
		NewGame.addActionListener(this);
		
		this.setLayout(new GridLayout(2,2));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		label1Temp = new JLabel("");
		
		layoutComponent1();
		layoutComponent2();	
		layoutComponent3();
		layoutComponent4();
		this.setVisible(true);
	}
	
	public void layoutComponent1() {
			
		panel1.setLayout(new GridLayout(3,0));
		
		int balance = m.Balance;
		label1 = new JLabel(" balance is ");
		label2 = new JLabel(" welcome!");
		labelBalance = new JLabel(""+balance);
		
		JPanel panelBalance = new JPanel();
		FlowLayout fl = new FlowLayout();	//in panel1, there are two labels in the first grid, so I use a flowlayout,
		fl.setAlignment(FlowLayout.LEFT);	// which is aligned to left.
		panelBalance.setLayout(fl);
		
		panelBalance.add(label1);
		panelBalance.add(labelBalance);
		
		panel1.add(panelBalance);
		panel1.add(label2);
		panel1.add(label1Temp);				//normally, it is space character except when it wins or loses.
		this.add(panel1);  				
	}
	
	public void layoutComponent2() {
		panel2.add(labelTemp);				//it is always a space character
		this.add(panel2);
	}
	
	public void layoutComponent3() {
		panel3.setLayout(new GridLayout(0,1));
		panel3.add(card);
		panel3.setVisible(true);
		this.add(panel3);
	}
	
	public void layoutComponent4() {
	
		panel4.setLayout(new GridLayout(2,0));
		panel4.add(Spin);
		panel4.add(NewGame);
		this.add(panel4);
	}
	
	public void actionPerformed(ActionEvent e) {
		card = new Cards(this.m);
		int bal = m.Balance;
		
		if(e.getSource()==Spin) {
		
		card.m.spin();
		bal = card.m.balanceUpdate();
		String b = ""+bal;
		
		labelBalance.setText(b);
		label2.setText(card.m.ResultUpdate());
		panel3.removeAll();			//everytime we spin, we remove all of the panel3 and 
		panel3.add(card);			// then we add card class on it.
		
		card.Update(panel3.getGraphics());
		
		if(bal<0) {
			Spin.setEnabled(false);
			label2.setText("Welcome !");	
			label1Temp.setText("You Lose !");
		}
		else if(bal>=150) {
			Spin.setEnabled(false);
			label1Temp.setText("You Win !");
		}
	}
		
		else if(e.getSource()==NewGame) {
			label1Temp.setText("");
			label2.setText("Welcome !");
			m.Balance = 100;
			labelBalance.setText(""+m.Balance);
			panel1.repaint();
			Spin.setEnabled(true);
		}
	}
}
