import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Block extends Actor
{
    
        
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void collision(SnakeWorld world) {
        Greenfoot.playSound("dead.mp3");
        world.dead();
    }
    
    
}
