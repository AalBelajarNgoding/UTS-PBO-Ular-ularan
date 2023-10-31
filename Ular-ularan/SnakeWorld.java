import greenfoot.*;
import java.util.*;

public class SnakeWorld extends World {
    private LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
    private int dx=1;
    private int dy=0;
    private int tailCounter = 5;
    private boolean dead = false;
    private int score;
    private GreenfootImage scoreImage = new GreenfootImage("Score: 0", 24, Color.WHITE, Color.BLACK);
    private GreenfootImage gameOverImage = new GreenfootImage("Game Over\nScore: 0", 36, Color.RED, Color.BLACK);
    private GreenfootImage[] snakeImages = new GreenfootImage[4];
    private int snakeSize = 4;
    
    
    /**
     * Constructor for objects of class SnakeWorld.
     */
    public SnakeWorld() {
        super(25, 20, 32);
        // ...
        
        score = 0;
        showText("Score: " + score, 100, 100);
        showScore();
        
        SnakeBody body = new SnakeBody();
        snake.add(body);
        addObject(body, 2, 2);
        
        Food apple = new Food();
        addObject(apple, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);
        
        Food0 duri = new Food0();
        addObject(duri, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);    
            
        Food1 roti = new Food1();
        addObject(roti, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);
        
        for (int x = 0; x < getWidth(); x++) {
            addObject(new Border(), x, 0);
            addObject(new Border(), x, getHeight() - 1);
        }
        for (int y = 0; y < getHeight(); y++) {
            addObject(new Border(), 0, y);
            addObject(new Border(), getWidth() - 1, y);
        }
    }
    
    public void act() {
        if (dead) return;
    changeDirection();
    SnakeBody head = snake.getLast();
    head.setImage("button-green.png");
    SnakeBody newHead = new SnakeBody();
    int newHeadX = head.getX() + dx;
    int newHeadY = head.getY() + dy;

    List<Block> blocks = getObjectsAt(newHeadX, newHeadY, Block.class);
    for (Block block : blocks) {
        block.collision(this);
    }

    addObject(newHead, newHeadX, newHeadY);
    snake.add(newHead);
    if (tailCounter == 0) {
        SnakeBody tail = snake.removeFirst();
        removeObject(tail);
    } else {
        tailCounter--;
    }
    
    showScore(); // Tampilkan skor
        
       
        
        addObject(newHead, newHeadX, newHeadY);
        snake.add(newHead);
        if (tailCounter == 0) {
            SnakeBody tail = snake.removeFirst();
            removeObject(tail);
        } else {
            tailCounter--;
        }
    }
    
    public void addToScore(int value) {
        score += value;
    }

    public int getScore() {
        return score;
    }
    
    
    
    private void showScore() {
        showText("Score: " + score, getWidth() / 2, 1); // Ubah posisi dan gaya sesuai keinginan Anda
    }
    
    private void changeDirection() {
        if(Greenfoot.isKeyDown("left") && dx ==0) {
            dx = -1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("right") && dx ==0) {
            dx = 1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("down") && dy ==0) {
            dx = 0;
            dy = 1;
        }
        if(Greenfoot.isKeyDown("up") && dy ==0) {
            dx = 0;
            dy = -1;
        }
    }
    
    
    public void dead() {
        dead = true;
    }
    
    public void grow(int size) {
        tailCounter+=size;
    }
}
