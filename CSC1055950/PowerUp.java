import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    int animCycle = 0;
    int animSpeed = 10;
    int time = 360;
    Animate anim1 = new Animate();
    GreenfootImage[] image = {null, new GreenfootImage(40, 40)};
    
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        expire();
    }    
    
    /*
     * Set expire into the power up object when it spawn into world.
     */
    public void expire(){
        time--;
        if(time <= 0){
            getWorld().removeObject(anim1);
            getWorld().removeObject(this);
        }   
    }
    
    /*
     * Add the objects to the world and animation.
     */
    public void addedToWorld(World World){
        getWorld().addObject(new Animate(), getX(), getY());
    }
    
    /*
     * get animation to object.
     */
    public void animate(){
        animCycle ++;
        if(animCycle >= 2 * animSpeed){
            animCycle = 0;
        }
        if(time <= 120){
            if(animCycle % animSpeed == 0){
                setImage(image[animCycle / animSpeed]);
            }
            animSpeed = 2;
        }
    }
}
