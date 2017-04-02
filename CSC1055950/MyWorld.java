import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.nio.file.Files;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    
    GreenfootImage BG = new GreenfootImage("BG.png");
    GreenfootImage ImgCycle = new GreenfootImage(BG);
    int animationTime = 0;
    int animSpeed = 2;
    int time = 0;
    int score = 0;
    int spawnLocat = 0;
    int difficulty = 0;
    public Player player = new Player();
    
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1, false);
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        ImgCycle.scale(ImgCycle.getWidth() * getHeight() / ImgCycle.getHeight(), getHeight());
        addObject(player, 300, 300);
        addObject(new Interface(), 250, 20);
        
    }
    
    public void animate(){
        
        animationTime++;
        if(animationTime >= BG.getWidth() * animSpeed){
            animationTime = 0;
        }
        
        ImgCycle.drawImage(BG, -animationTime / animSpeed + BG.getWidth(), 0);
        ImgCycle.drawImage(BG, -animationTime / animSpeed, 0);
        setBackground(ImgCycle);
    }
    
    /*
     * Spawn the enemy into the World randomly and check the difficulty before spawn enemy ship.
     */
    public void spawn(){
       if(difficulty * 100 + Greenfoot.getRandomNumber(difficulty * 2500) < spawnLocat && getObjects(Boss.class).isEmpty()){
            int spawnCount = 0;
            
            
            
            if(Greenfoot.getRandomNumber(100) < 15){
                
                spawnCount = spawnLocat / 1000;
                spawnLocat -= spawnCount * 1000;
                int rows = spawnCount / 3;
                int spawnY = 190 + Greenfoot.getRandomNumber(260);
                int i = 0;
                while(i < rows){
                    addObject(new Bomber(), 1260 + i * 120, spawnY - 90);
                    addObject(new Bomber(), 1260 + i * 120, spawnY);
                    addObject(new Bomber(), 1260 + i * 120, spawnY + 90);
                    i++;
                }
                
                if(spawnCount % 3 == 1){
                    addObject(new Bomber(), 1260 + rows * 120, spawnY);
                }else if(spawnCount % 3 == 2){
                    addObject(new Bomber(), 1260 + rows * 120, spawnY - 45);
                    addObject(new Bomber(), 1260 + rows * 120, spawnY + 45);
                }
                
            }else{
                
                spawnCount = spawnLocat / 400;
                spawnLocat -= spawnCount * 400;
                int rows = spawnCount / 5;
                int spawnY = 220 + Greenfoot.getRandomNumber(200);
                int i = 0;
                while(i < rows){
                    
                    addObject(new Jet(), 1230 + i * 50, spawnY - 100);
                    addObject(new Jet(), 1230 + i * 50, spawnY - 50);
                    addObject(new Jet(), 1230 + i * 50, spawnY);
                    addObject(new Jet(), 1230 + i * 50, spawnY + 50);
                    addObject(new Jet(), 1230 + i * 50, spawnY + 100);  
                    i++;
                }
                if(spawnCount % 5 == 1 || spawnCount % 5 == 3){
                    addObject(new Jet(), 1230 + rows * 50, spawnY);
                }
                if(spawnCount % 5 == 2 || spawnCount % 5 == 4){
                    addObject(new Jet(), 1230 + rows * 50, spawnY - 25);
                    addObject(new Jet(), 1230 + rows * 50, spawnY + 25);
                }
                if(spawnCount % 5 == 3){
                    addObject(new Jet(), 1230 + rows * 50, spawnY - 50);
                    addObject(new Jet(), 1230 + rows * 50, spawnY + 50);                    
                }
                if(spawnCount % 5 == 4){
                    addObject(new Jet(), 1230 + rows * 50, spawnY - 75);
                    addObject(new Jet(), 1230 + rows * 50, spawnY + 75);                    
                }
            }
            
            
        }
    }
    
    public void spawnBoss(){
        
        int spawnY = 220;
        
        addObject(new Boss(), 1230, spawnY);
    }
    
    public void act(){
        
        spawnLocat += difficulty;
        difficulty = 5 + score / 500 + 1;
        
        animate();
        
        spawn();
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new PauseMenu(this, score));
        }
    }
    
}
