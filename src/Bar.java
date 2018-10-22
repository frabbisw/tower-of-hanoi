
public class Bar {
	int x1,x2,y1,width,height;
	public Bar(int x, int y, int width, int height)
	{
		this.width=width;
		this.height=height;
		x1=x;
		x2=x+width;
		y1=y;
	}
	public void setY(int y1)
	{
		this.y1=y1;
	}
}
