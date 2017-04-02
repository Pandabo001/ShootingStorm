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
            spawnItem();
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
    
    /*
     * Randomly spawn power up objects.
     */
    public void spawnItem(){
        if(Greenfoot.getRandomNumber(50) < dropPercentage){
                int item = Greenfoot.getRandomNumber(100);
                if(item < 20){
                    myworld.addObject(new Repair(), getX(), getY());
                }else if(item < 40){
                    myworld.addObject(new RocketUp(), getX(), getY());
                }else if(item < 50){
                    myworld.addObject(new BulletLvlUp(), getX(), getY());
                }else if(item < 60){
                    myworld.addObject(new HPUP(), getX(), getY());
                }else if(item < 70){
                     myworld.addObject(new FireRate(), getX(), getY());
                }else if(item < 80){
                     myworld.addObject(new Speed(), getX(), getY());
                }else if(item < 90){
                     myworld.addObject(new Damage(), getX(), getY());
                }else{
                    myworld.addObject(new BulletSpeed(), getX(), getY());
                }
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
