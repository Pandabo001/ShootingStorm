import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplosionEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosionEnd extends Actor
{
    int animCycle = 0;
    int animSpeed = 4;
    GreenfootImage[] image = {null, null, null, null, null};
    
    /**
     * Act - do whatever the ExplosionEnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
        if(animCycle >= image.length * animSpeed - 1){
            MyWorld myworld = (MyWorld) getWorld();
            Greenfoot.setWorld(new GameOver(myworld.score));
        }
    }    
    
    public ExplosionEnd(){
        for(int i = 0; i < 5; i++){
            image[i] = new GreenfootImage("explosion" + (i + 1) + ".png");
            image[i].scale(200, 200);
        }
    }
    
    void animate(){
        animCycle++;
        setImage(image[animCycle / animSpeed]);
    }
}
