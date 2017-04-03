import greenfoot.*;
//import java.awt.Color;
/**
 * Write a description of class Star2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private static final int Size = 3;
    private int speed;
    
    /**
     * Act - do whatever the Star2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Star(){
        GreenfootImage img = new GreenfootImage(Size,Size);
        //int color = Greenfoot.getRandomNumber(256);
        img.setColor(new Color(198, 192, 83));
        img.fillOval(0,0,Size,Size);
        setImage(img);
        speed = Greenfoot.getRandomNumber(5)+1;
        //this method just like Star Method is random make Star
    }
    
    public void act() 
    {
        setLocation( getX(), getY()+speed);
        if(getY() < Size){
            int x = Greenfoot.getRandomNumber(getWorld().getHeight());
            int y = getWorld().getHeight()+Size;
            setLocation(x,y);
            //but this is to be different because is move in the vertical
        }
    }    
}
