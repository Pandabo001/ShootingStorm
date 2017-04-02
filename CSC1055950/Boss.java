import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    BossTurret turret;
    BossTurret turret2;
    BossTurret turret3;
    int firingRate = 75;
    int firingCycle = 0;
    
    /**
     * Act - do whatever the Bomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        animated();
        
        move(-speed);
        //fire();
        turret.setLocation(getX(), getY());
        turret2.setLocation(getX()+85, getY()-90);
        turret3.setLocation(getX()+85, getY()+90);
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
    
    public void fire(){
        firingCycle++;
        if(firingCycle >= firingRate){
            BossBullet bullet = new BossBullet();
            bullet.setRotation(getRotation());
            myworld.addObject(bullet, getX(), getY());
            Greenfoot.playSound("Gun+Silencer.wav");
            firingCycle = 0;
        }
    }
    
    public void addedToWorld(World World){
    
        myworld = (MyWorld) World;
        speed = 0;
        hp = myworld.difficulty * 200;
        score = 500;
        dropPercentage = 100;
        turret = new BossTurret();
        turret2 = new BossTurret();
        turret3 = new BossTurret();
        myworld.addObject(turret, getX(), getY());
        myworld.addObject(turret2, getX()+85, getY()-90);
        myworld.addObject(turret3, getX()+85, getY()+90);
        turn(180);
        image[0] = new GreenfootImage("boss.png");
        image[1] = new GreenfootImage("boss.png");
    }   
}
