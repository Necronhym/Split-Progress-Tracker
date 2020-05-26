package SplitOMatic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SplitOMatic
	{
		public static void main(String args[])
			{
				Window Win = new Window();
			}
	}
class Window extends JFrame implements KeyListener, MouseListener
	{
		JPanel Panel;
		int CurrentInt;
		int BestInt;
		Split[] Splits;
		int NumberOfSplits;

		JLabel Current;
		JLabel PersonalBest;
		
		@Override public void keyReleased(KeyEvent e)
			{
			}
		@Override public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == 107)
					{
						CurrentInt = (CurrentInt%NumberOfSplits) + 1;
					}
				if(e.getKeyCode() == 109)
					{
						CurrentInt = 1;
					}
				if(e.getKeyCode() == 106)
					{
						CurrentInt = 1;
						BestInt = 1;
					}
				if(CurrentInt > BestInt)
					{
						BestInt = (BestInt%NumberOfSplits) + 1;
					}

				Current.setBounds(300-75, CurrentInt*30,30, 30);
				PersonalBest.setBounds(300-40, BestInt*30, 30, 30);
			}
		@Override public void keyTyped(KeyEvent e)
			{
					
			}
		@Override public void mouseEntered(MouseEvent e)
			{
				this.requestFocusInWindow();
			}
		@Override public void mousePressed(MouseEvent e)
			{

			}
		@Override public void mouseReleased(MouseEvent e)
			{

			}
		@Override public void mouseExited(MouseEvent e)
			{

			}
		@Override public void mouseClicked(MouseEvent e)
			{

			}
		Window()
			{
				String ProgramName = JOptionPane.showInputDialog(null, "Name the program:","Split-0-matic",JOptionPane.QUESTION_MESSAGE);
				setTitle(ProgramName);
				String stringNuSections = JOptionPane.showInputDialog(null, "Number of sections:","Split-o-Matic",JOptionPane.QUESTION_MESSAGE);
				int nuSplits = Integer.parseInt(stringNuSections);
				Split[] Splits = new Split[nuSplits];
				NumberOfSplits = nuSplits;
				CurrentInt = 1;
				BestInt = 1;

				Panel = new JPanel();
				setSize(300, (30*nuSplits+1)+85);
				setLayout(null);
				Panel.setLayout(null);
				Panel.setBounds(0,0, 300, (30*(nuSplits+1))+5);
				//Top Row
				Split TopRow = new Split(5, 5, 300, 30);
				TopRow.setCurrent("C");
				TopRow.setPersonalBest("PB");
				TopRow.setText("Split Name:");
				
				for(int i = 0; i < nuSplits; i++)
					{
						Splits[i] = new Split(5, (i+1)*30+5, 300, 30);
						Splits[i].setCurrent("");
						Panel.add(Splits[i]);
					}
				Panel.add(TopRow);
				add(Panel);
				getContentPane().setBackground(Color.black);	
				Panel.setBackground(Color.black);	
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				addKeyListener(this);
				addMouseListener(this);
				this.setFocusable(true);
				this.requestFocusInWindow();
				
				Current = new JLabel("<");
				PersonalBest = new JLabel("<");
				
				Current.setFont(new Font("Monspace",Font.BOLD, 18));	
				PersonalBest.setFont(new Font("Monspace",Font.BOLD, 18));	
				
				Current.setBounds(300-75, 30,30, 30);
				Current.setForeground(Color.white);
				Panel.add(Current);

				PersonalBest.setBounds(300-40, 30, 30, 30);
				PersonalBest.setForeground(Color.white);
				Panel.add(PersonalBest);
				
				
				setVisible(true);
			}
	}
class Split extends JComponent
	{
		JTextField SplitName;
		JLabel Current;
		JLabel PersonalBest;
		class SplitHandler implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
					{
						SplitName.setEditable(false);
					}
			}
		Split(int x, int y, int w, int h)
			{
				SplitName = new JTextField("");
				Current = new JLabel(" ");
				PersonalBest = new JLabel(" ");
				
				SplitName.setFont(new Font("Monspace",Font.BOLD, 18));	

				SplitName.setForeground(Color.white);
				SplitName.setBackground(Color.black);	
				
				SplitName.setBounds(0,0,w-100,h);
				add(SplitName);

				PersonalBest.setFont(new Font("Monspace",Font.BOLD, 18));	
				Current.setFont(new Font("Monspace",Font.BOLD, 18));	
				
				Current.setBounds(w-75, 0,50, h);
				Current.setForeground(Color.white);
				add(Current);	
				PersonalBest.setBounds(w-40, 0, 50, h);
				PersonalBest.setForeground(Color.white);
				add(PersonalBest);
				
				setBounds(x,y,w,h);
				SplitName.addActionListener(new SplitHandler());
			}
		public void setText(String Text)
			{
				SplitName.setText(Text);
				SplitName.setEditable(false);
			}
		public void setCurrent(String Text)
			{
				Current.setText(Text);
			}
		public void setPersonalBest(String Text)
			{
				PersonalBest.setText(Text);
			}
		public void setColor(Color c)
			{
				Current.setForeground(c);
			}
	}
