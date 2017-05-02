import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    
    int damage;
    int radius;
    int animCycle = 0;
    int animSpeed = 4;
    GreenfootImage[] image = {null, null, null, null};
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        if(animCycle >= image.length * animSpeed - 1){
            getWorld().removeObject(this);
        }
    }    
    
    public void animate(){
        animCycle++;
        setImage(image[animCycle / animSpeed]);
    }
    
    public void addedToWorld(World World){
        List<Enemy> enemy = getObjectsInRange(radius, Enemy.class);
        for(Enemy a : enemy){
            a.hp -= damage;
        }
    }
    
    public Explosion(int damagei, int radiusi){
        damage = damagei;
        radius = radiusi;
        for(int i = 0; i < 4; i++){
            image[i] = new GreenfootImage("explosion" + (i + 1) + ".png");
            image[i].scale(radius * 4, radius * 4);
        }
    }
}
