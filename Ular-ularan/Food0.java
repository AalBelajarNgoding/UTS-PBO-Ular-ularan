import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Food0 extends Block
{
    
    public void act() 
    {
        // Add your action code here.
    }    
    public void collision(SnakeWorld world) {
        Greenfoot.playSound("slurp.mp3");
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getWorld().getHeight()-2)+1);
        world.grow(0);
        world.addToScore(-3);
    }
}