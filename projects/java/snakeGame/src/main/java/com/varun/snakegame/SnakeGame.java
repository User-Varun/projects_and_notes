package com.varun.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener { // Removed KeyListener
    private final int BOARD_WIDTH = 800;
    private final int BOARD_HEIGHT = 600;
    private final int UNIT_SIZE = 25;
    private final int DELAY = 1000;
    private final int X_AXIS = BOARD_WIDTH / UNIT_SIZE;
    private final int Y_AXIS = BOARD_HEIGHT / UNIT_SIZE;
    

    private boolean paused = false;
    private boolean running = false;
    private Timer timer;
    private LinkedList<Point> snakeBody;
    private Point food;
    private Random random;
    private char direction = 'R'; 

    public SnakeGame() {
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocusInWindow(); // Ensure focus
        
        // --- KEY BINDINGS ONLY (Removed KeyListener) ---
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0) , "spacebar");

        actionMap.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction != 'R') direction = 'L';
            }
        });

        actionMap.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction != 'L') direction = 'R';
            }
        });

        actionMap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction != 'D') direction = 'U';
            }
        });

        actionMap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction != 'U') direction = 'D';
            }
        });
        
        
        actionMap.put("spacebar", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            if(!running)return; // if not running , then don't do anything
            
            paused = !paused;
            
            if(paused){
                timer.stop();
              // show pause screen  
              pauseGame();
            }else{
                timer.start();
            }
            
        }
        });
        // -----------------------------------------------

        startGame();
    }

    private void startGame() {
        initGame();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initGame() {
        snakeBody = new LinkedList<>();
       // Add Head first
    snakeBody.add(new Point(100, 100)); 
    // Add Body
//    snakeBody.add(new Point(75, 100));
//    snakeBody.add(new Point(50, 100));
    
    random = new Random();
    placeFood();
    direction = 'R';
    }

    private void placeFood() {
        food = new Point(random.nextInt(X_AXIS) * UNIT_SIZE, random.nextInt(Y_AXIS) * UNIT_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollisions();
            repaint();
        }
    }

    private void move() {
        Point currentHead = snakeBody.getFirst();
    Point newHead = new Point(currentHead.x, currentHead.y); // Create NEW point

    switch (direction) {
        case 'U': newHead.y -= UNIT_SIZE; break;
        case 'D': newHead.y += UNIT_SIZE; break;
        case 'L': newHead.x -= UNIT_SIZE; break;
        case 'R': newHead.x += UNIT_SIZE; break;
    }

    snakeBody.addFirst(newHead); // Add new head

    if (newHead.equals(food)) {
        placeFood();
        // Don't remove tail -> Snake grows
    } else {
        snakeBody.removeLast(); // Remove tail -> Snake moves
    }
    }

    private void checkCollisions() {
       Point head = snakeBody.getFirst();

    // Wall Collision
    if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT) {
        running = false;
        gameOver();
    }

    // Self Collision (Start from index 1, because 0 is the head itself)
    for (int i = 1; i < snakeBody.size(); i++) {
        if (head.equals(snakeBody.get(i))) {
            running = false;
            gameOver();
        }
    }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over! Score: " + (snakeBody.size() - 3));
        System.exit(0);
    }

       private void pauseGame() {
        JOptionPane.showMessageDialog(this, "Game Paused! Score: " + (snakeBody.size() - 3));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(Color.RED);
    g.fillRect(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

    g.setColor(Color.GREEN);
    for (Point p : snakeBody) {
        g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
    }
    }

    // REMOVED: keyPressed, keyTyped, keyReleased methods

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);

    }
}   