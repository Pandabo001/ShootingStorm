import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GreenfootSound music = new GreenfootSound("08 - Theme Of Soldier (Instrumental)-(MyMp3Singer.net).MP3");
    
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
    private MainMenu main;
    GreenfootImage imageHit = new GreenfootImage("playerhit.png");
    GreenfootImage[] image = {new GreenfootImage("player1.png"), new GreenfootImage("player2.png")};
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!destroyed){
            music.playLoop();
            move();
            fire();
            damageAnim++;
            animate();
            getDamaged();
            getDamagedFromBoss();
            getItem();
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
    
    public void getDamagedFromBoss(){
        while(getOneIntersectingObject(BossBullet.class) != null){
            Actor a = getOneIntersectingObject(BossBullet.class);
            hp -= BossBullet.damage;
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
                    
                    myworld.addObject(new PlayerBullet(), x, y + (int)((i + 0.5) * 6 - fireLevel * 3));
                }
                Greenfoot.playSound("Gun+1.wav");
                firingCycle = 0;
            }
        }
        
        if(Greenfoot.isKeyDown("z")){
            if(rocketCycle >= rocketRate && rockets > 0){
                rockets--;
                Greenfoot.playSound("Missile+2.wav");
                myworld.addObject(new Rocket(), (int)x, (int)y);
                rocketCycle = 0;
            }
        }
    }
    
    /*
     * Check that palyer ship get the power up, increase the power in player ship and check max of power up.
     */
    public void getItem(){
        while(getOneIntersectingObject(Repair.class) != null){
            Repair a = (Repair)getOneIntersectingObject(Repair.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            hp = maxhp;
        }
        while(getOneIntersectingObject(RocketUp.class) != null){
            RocketUp a = (RocketUp)getOneIntersectingObject(RocketUp.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            rockets += 2;
            if(rockets > 1000){
                rockets = 1000;
            }
        }
        while(getOneIntersectingObject(BulletLvlUp.class) != null){
            BulletLvlUp a = (BulletLvlUp)getOneIntersectingObject(BulletLvlUp.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            if(fireLevel < 8){
                fireLevel++;
            }
        }
        while(getOneIntersectingObject(BulletSpeed.class) != null){
            BulletSpeed a = (BulletSpeed)getOneIntersectingObject(BulletSpeed.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            if(bulletSpeed < 20){
                bulletSpeed++;
            }
        }
        while(getOneIntersectingObject(HPUP.class) != null){
            HPUP a = (HPUP)getOneIntersectingObject(HPUP.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            maxhp += 20;
            hp += 20;
            if(maxhp > 1000){
                maxhp = 1000;
            }
            if(hp > 1000){
                hp = 1000;
            }
        }
        while(getOneIntersectingObject(Damage.class) != null){
            Damage a = (Damage)getOneIntersectingObject(Damage.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            if(damage < 40){
                damage += 2;
            }
        }
        while(getOneIntersectingObject(FireRate.class) != null){
            FireRate a = (FireRate)getOneIntersectingObject(FireRate.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            if(firingRate > 2){
                firingRate--;
            }
        }
        while(getOneIntersectingObject(Speed.class) != null){
            Speed a = (Speed)getOneIntersectingObject(Speed.class);
            Greenfoot.playSound("Beep1.wav");
            myworld.removeObject(a.anim1);
            myworld.removeObject(a);
            if(speed < 8){
                speed++;
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
            music.stop();
            //main.stopped();
            destroyed = true;
        }
    }
    
}
