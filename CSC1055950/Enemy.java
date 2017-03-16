import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int animCycle = 0;
    int animSpeed = 5;
    int hp = 1;
    int speed = 1;
    int score = 1;
    int dropPercentage = 0;
    MyWorld myworld;
    GreenfootImage[] image = {null, null};
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getDamaged();
        Destroyed();
    }    
    
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
    }
    
    /*
     * if the enemy ship is destroy update score and spawn power up object to the world.
     */
    public void Destroyed(){
        if(hp <= 0){
            myworld.score += score;
            myworld.addObject(new Explosion(0, 40), getX(), getY());
            Greenfoot.playSound("explosion.mp3");
            myworld.removeObject(this);
        }else if(getX() <= -getImage().getWidth()){
            myworld.removeObject(this);
        }
    }
    
    public void getDamaged(){
        while(getOneIntersectingObject(PlayerWeapons.class) != null){
            PlayerWeapons a = (PlayerWeapons)getOneIntersectingObject(PlayerWeapons.class);
            hp -= a.damage;
            if(a.explosive){
                myworld.addObject(new Explosion(a.damage, a.radius), a.getX(), a.getY());
            }
            myworld.removeObject(a);
        }
    }
    
    public void animated(){
        animCycle ++;
        if(animCycle >= image.length * animSpeed){
            animCycle = 0;
        }
        setImage(image[animCycle / animSpeed]);
    }
}
