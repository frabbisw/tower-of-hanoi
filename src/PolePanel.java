import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PolePanel extends JPanel{
	int number=8, revy=300;
	ClearObj obj;
	ArrayList <Bar> stk1;
	ArrayList <Bar> stk2;
	ArrayList <Bar> stk3;
	boolean foul = false;
	
	public PolePanel(int number)
	{
		this.number=number;
		stk1 = new <Bar> ArrayList();
		stk2 = new <Bar> ArrayList();
		stk3 = new <Bar> ArrayList();
		
		obj = new ClearObj();
		makePole();
	}
	private void makePole() 
	{
		int dw=20,dx=dw/2,dh=20,dy=dh;
		int tx=20,ty=0,tw=160,th=10;
		int AR = 10;
		
		for(int i=number; i>=1; i--)
		{
			Bar b = new Bar(140-i*dx, ty, i*dw, dh);
			stk1.add(b);
			
			ty+=dy;
		}
	}
	public void oneToThree()
	{
		if(stk1.size()!=0)
		{
			Bar a = stk1.get(stk1.size()-1);
			if(stk3.size()==0)
			{
				obj.setPosition(a);
				a.x1+=600;
				a.y1=0;
				stk3.add(a);
				stk1.remove(stk1.size()-1);			
				foul = true;
			}
			
			else
			{
				Bar b = stk3.get(stk3.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1+=600;
					a.y1=b.y1+b.height;
					stk3.add(a);
					stk1.remove(stk1.size()-1);
					foul = true;
				}
			}
		}
	}
	public void oneToTwo()
	{
		if(stk1.size()!=0)
		{
			Bar a = stk1.get(stk1.size()-1);
			if(stk2.size()==0)
			{
				obj.setPosition(a);
				a.x1+=300;
				a.y1=0;
				stk2.add(a);
				stk1.remove(stk1.size()-1);
				foul = true;
			}
			
			else
			{
				Bar b = stk2.get(stk2.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1+=300;
					a.y1=b.y1+b.height;
					stk2.add(a);
					stk1.remove(stk1.size()-1);
					foul = true;
				}
			}
		}
	}
	public void twoToOne()
	{
		if(stk2.size()!=0)
		{
			Bar a = stk2.get(stk2.size()-1);
			if(stk1.size()==0)
			{
				obj.setPosition(a);
				a.x1-=300;
				a.y1=0;
				stk1.add(a);
				stk2.remove(stk2.size()-1);
				foul = true;
			}
			
			else
			{
				Bar b = stk1.get(stk1.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1-=300;
					a.y1=b.y1+b.height;
					stk1.add(a);
					stk2.remove(stk2.size()-1);
					foul = true;
				}
			}
		}
	}
	public void twoToThree()
	{
		if(stk2.size()!=0)
		{
			Bar a = stk2.get(stk2.size()-1);
			if(stk3.size()==0)
			{
				obj.setPosition(a);
				a.x1+=300;
				a.y1=0;
				stk3.add(a);
				stk2.remove(stk2.size()-1);
				foul = true;
			}
			
			else
			{
				Bar b = stk3.get(stk3.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1+=300;
					a.y1=b.y1+b.height;
					stk3.add(a);
					stk2.remove(stk2.size()-1);
					foul = true;
				}
			}
		}
	}
	public void threeToOne()
	{
		if(stk3.size()!=0)
		{
			Bar a = stk3.get(stk3.size()-1);
			if(stk1.size()==0)
			{
				obj.setPosition(a);
				a.x1-=600;
				a.y1=0;
				stk1.add(a);
				stk3.remove(stk3.size()-1);
				foul = true;
			}
			
			else
			{
				Bar b = stk1.get(stk1.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1-=600;
					a.y1=b.y1+b.height;
					stk1.add(a);
					stk3.remove(stk3.size()-1);
					foul = true;
				}
			}
		}
	}
	public void threeToTwo()
	{
		if(stk3.size()!=0)
		{
			Bar a = stk3.get(stk3.size()-1);
			if(stk2.size()==0)
			{
				obj.setPosition(a);
				a.x1-=300;
				a.y1=0;
				stk2.add(a);
				stk3.remove(stk3.size()-1);
				foul = true;
			}
			
			else
			{
				Bar b = stk2.get(stk2.size()-1);
				if(b.width>a.width)
				{
					obj.setPosition(a);
					a.x1-=300;
					a.y1=b.y1+b.height;
					stk2.add(a);
					stk3.remove(stk3.size()-1);
					foul = true;
				}
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		if(obj!=null)
			if(obj.needToUpdate())
			{
				g.clearRect(obj.x, revy-obj.y, obj.width, obj.height);
				//g.fillRect(obj.x, revy-obj.y, obj.width, obj.height);
				obj.reset();
			}
		g.setColor(Color.BLUE);
		
		for(int i=0; i<stk1.size(); i++)
		{
			Bar b = stk1.get(i);
			g.fillOval(b.x1, revy-b.y1, b.width, b.height);
		}
		for(int i=0; i<stk2.size(); i++)
		{
			Bar b = stk2.get(i);
			g.fillOval(b.x1, revy-b.y1, b.width, b.height);
		}
		for(int i=0; i<stk3.size(); i++)
		{
			Bar b = stk3.get(i);
			g.fillOval(b.x1, revy-b.y1, b.width, b.height);
		}
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
}
