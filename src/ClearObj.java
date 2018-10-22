
public class ClearObj {
	boolean a = false;
	int x,y,width,height;
	
	public ClearObj()
	{
		a=false;
	}
	public void setPosition(Bar b)
	{
		x=b.x1;
		y=b.y1;
		width=b.width;
		height=b.height;
		a=true;
	}
	void reset()
	{
		a=false;
	}
	boolean needToUpdate()
	{
		return a;
	}
}
