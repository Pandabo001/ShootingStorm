import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jet extends Enemy
{
    
    int firingRate = 75;
    int firingCycle = 0;
    int movementCycle = 20;
    
    
    /**
     * Act - do whatever the Jet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animated();
        move();
        fire();
        getDamaged();
        Destroyed();
    }    
    

    
    public void fire(){
        firingCycle++;
        if(firingCycle >= firingRate){
            EnemyBullet bullet = new EnemyBullet();
            bullet.setRotation(getRotation());
            myworld.addObject(bullet, getX(), getY());
            Greenfoot.playSound("Gun+Silencer.wav");
            firingCycle = 0;
        }
    }
    
    public void move(){
        movementCycle++;
        if(movementCycle <= 40){
            setLocation(getX() - speed, getY() - speed);
        }
        if(movementCycle > 40){
            setLocation(getX() - speed, getY() + speed);
        }
        if(movementCycle > 80){
            movementCycle = 0;
        }
    }
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        dropPercentage = 5;
        speed = 2;
        hp = myworld.difficulty * 7 - 15;
        score = 10;
        turn(180);
        image[0] = new GreenfootImage("fighter1.png");
        image[1] = new GreenfootImage("fighter2.png");
    }
}
