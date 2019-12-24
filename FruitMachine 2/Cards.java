//ZHENG ZHAOHUO
//2455448z

import javax.swing.*;
import java.awt.*;
public class Cards extends JPanel {
	Graphics g;
	Model m;
	public String card1,card2,card3;
	public Cards(Model m) {
		this.m = m;
		
		card1 = m.card1;
		card2 = m.card2;
		card3 = m.card3;
		
        this.setVisible(true);	
	}
	public void paint(Graphics g) {
			
		g.setColor(Color.yellow);
		// to draw three poker with yellow background.
		g.fillRect(20,0,70,140);
		
		g.fillRect(110,0,70,140);
		
		g.fillRect(200,0,70,140);
		// to set font design
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		// to add card value to three poker
		g2.drawString(m.card1, 38, 70);
		g2.drawString(m.card2, 128, 70);
		g2.drawString(m.card3, 218, 70);
		
		// to add a black frame to three poker
		Graphics2D g3 = (Graphics2D) g;
		g3.setColor(Color.black);
		g3.draw(new Rectangle(20,0,70,140));
		g3.draw(new Rectangle(110,0,70,140));
		g3.draw(new Rectangle(200,0,70,140));
		
		}
	
	public void repaint() {
		super.repaint();
	}
	
	public void Update(Graphics content) {
		// everytimes we spin, we update three poker.
		Graphics2D g2 = (Graphics2D) content;

		g2.setColor(Color.black);
		g2.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		g2.drawString(card1, 38, 70);
		g2.drawString(card2, 128, 70);
		g2.drawString(card3, 218, 70);
	}
}
