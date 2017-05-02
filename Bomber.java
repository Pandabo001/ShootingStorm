import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomber extends Enemy
{
    BomberTurret turret;
    
    
    /**
     * Act - do whatever the Bomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animated();
        move(-speed);
        turret.setLocation(getX(), getY());
        getDamaged();
        Destroyed();
    }
    
    public void Destroyed(){
        
        if(hp <= 0){
            myworld.score += score;
            myworld.removeObject(turret);
            myworld.addObject(new Explosion(0, 40), getX(), getY());
            myworld.removeObject(this);
        }else if(getX() <= -getImage().getWidth()){
            myworld.removeObject(this);
        }
    }
    
    public void addedToWorld(World World){
    
        myworld = (MyWorld) World;
        speed = 1;
        hp = myworld.difficulty * 30 - 50;
        score = 100;
        dropPercentage = 100;
        turret = new BomberTurret();
        myworld.addObject(turret, getX(), getY());
        image[0] = new GreenfootImage("bomber1.png");
        image[1] = new GreenfootImage("bomber2.png");
    }
}
