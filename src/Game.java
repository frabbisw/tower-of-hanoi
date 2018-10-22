import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	int number;
	int height,width;
	public Game(int number)
	{
		this.number=number;
		this.width=900;
		this.height=700;
		
		setTitle("Tower Of Honoi");
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		add(panel1);
		
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=10;
		gbc.weighty=0;
		
		JButton oneToTwo = new JButton("1 >> 2");
		JButton oneToThree = new JButton("1 >> 3");
		JButton twoToOne = new JButton("1 << 2");
		JButton twoToThree = new JButton("2 >> 3");
		JButton threeToOne = new JButton("1 << 3");
		JButton threeToTwo = new JButton("2 << 3");

		panel1.add(oneToTwo,gbc);
		gbc.gridx++;
		panel1.add(twoToOne,gbc);
		gbc.gridx++;
		panel1.add(threeToOne,gbc);
		gbc.gridy++;
		gbc.gridx=0;
		panel1.add(oneToThree,gbc);
		gbc.gridx++;
		panel1.add(twoToThree,gbc);
		gbc.gridx++;
		panel1.add(threeToTwo,gbc);
		
		final PolePanel poles = new PolePanel(number);
		add(poles);
		
		oneToThree.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.oneToThree();
			}
		});
		oneToTwo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.oneToTwo();
			}
		});
		twoToThree.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.twoToThree();
			}
		});
		twoToOne.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.twoToOne();
			}
		});
		threeToOne.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.threeToOne();
			}
		});
		threeToTwo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				poles.threeToTwo();
			}
		});
		
	}
}
