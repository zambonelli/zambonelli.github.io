

class Point {
public int x;
public int y;
public Point() {x=0;y=0;}
public Point(int x, int y)
     {this.x=x;this.y=y;}

public Object clone()
{  Point p2 = new Point();
   p2.x = x;
   p2.y = y;
   return p2;
   }

}
