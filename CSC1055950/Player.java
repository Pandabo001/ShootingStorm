import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    int animCycle = 0;
    int animSpeed = 5;
    int x;
    int y;
    int speed = 3;
    int firingRate = 10;
    int firingCycle = 0;
    int rocketRate = 20;
    int rocketCycle = 0;
    int rockets = 3;
    int maxhp = 100;
    int hp = 100;
    int fireLevel = 1;
    int bulletSpeed = 4;
    int damage = 10;
    int damageAnim = 0;
    int sid = Greenfoot.getRandomNumber(100);
    boolean destroyed = false;
    private MyWorld myworld;
    GreenfootImage imageHit = new GreenfootImage("playerhit.png");
    GreenfootImage[] image = {new GreenfootImage("player1.png"), new GreenfootImage("player2.png")};
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!destroyed){
            move();
            fire();
            damageAnim++;
            animate();
            getDamaged();
            getDestroyed();
            setLocation(x, y);
        }
    }    
    
    /*
     * add player ship into World and check X and Y coordinates of object.
     */
    public void addedToWorld(World World){
        myworld = (MyWorld) World;
        x = getX();
        y = getY();
    }
    
    /*
     * check the given key is currently down and set the location to move.
     */
    public void move(){
        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
            y += speed;
        }
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
            y -= speed;
        }
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            x += speed;
        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            x -= speed;
        }
        if(y > myworld.getHeight() - getImage().getHeight() / 2){
            y = myworld.getHeight() - getImage().getHeight() / 2;
        }
        if(y < 40 + getImage().getHeight() / 2){
            y = 40 + getImage().getHeight() / 2;
        }
        if(x > myworld.getWidth() - getImage().getWidth() / 2){
            x = myworld.getWidth() - getImage().getWidth() / 2;
        }
        if(x < 0 + getImage().getWidth() / 2){
            x = 0 + getImage().getWidth() / 2;
        }
    }
    
    
    
    /*
     * Check if player ship get damage from enemy bullet and decrease player hp.
     */
    public void getDamaged(){
        while(getOneIntersectingObject(EnemyBullet.class) != null){
            Actor a = getOneIntersectingObject(EnemyBullet.class);
            hp -= EnemyBullet.damage;
            myworld.removeObject(a);
            damageAnim = 0;
            setImage(imageHit);
        }
    }
    
    /*
     * Check key and get fire to enemy ships.
     */
    public void fire(){
        firingCycle++;
        rocketCycle++;
        if(Greenfoot.isKeyDown("space")){
            if(firingCycle >= firingRate){
                //sid = Greenfoot.getRandomNumber(100);
                for(int i = 0; i < fireLevel; i++){
                    Greenfoot.playSound("Laser_Shoot1.wav");
                    myworld.addObject(new PlayerBullet(), x, y + (int)((i + 0.5) * 6 - fireLevel * 3));
                }
                firingCycle = 0;
            }
        }
        
        if(Greenfoot.isKeyDown("r")){
            if(rocketCycle >= rocketRate && rockets > 0){
                rockets--;
                Greenfoot.playSound("howitzer_cannon_single_shot.mp3");
                myworld.addObject(new Rocket(), (int)x, (int)y);
                rocketCycle = 0;
            }
        }
    }
    
    /*
     * Animate the palyer animation.
     */
    public void animate(){
        animCycle++;
        if(animCycle >= image.length * animSpeed){
            animCycle = 0;
        }
        if(hp <= maxhp / 2 && animCycle % 3 == 0){
            myworld.addObject(new Smoke(), getX(), getY());
        }
        if(damageAnim > 5){
            setImage(image[animCycle / animSpeed]);
        }
    }
    
    /*
     * If player ship is destroy set the animation into the world.
     */
    public void getDestroyed(){
        if(hp <= 0){
            myworld.addObject(new ExplosionEnd(), getX(), getY());
            Greenfoot.playSound("explosion.mp3");
            ///((MainMenu)(getWorld())).stopped();
            setImage(new GreenfootImage(1, 1));
            destroyed = true;
        }
    }
    
}
