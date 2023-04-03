package Maze_Path_Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Newclass extends JFrame {
    private int [][] maze =
            {
                    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                    { 1, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
                    { 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 },
                    { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                    { 1, 1, 1, 0, 1, 1, 1, 0, 0, 1 },
                    { 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 },
                    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    { 1, 0, 1, 1, 1, 1, 0, 1, 9, 1 },
                    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
            };
    public ArrayList<Integer> path = new ArrayList<>();

    public Newclass(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DepthFirst.searchpath(maze,1,1,path);


    }
    @Override
    public void paint(Graphics g){

        g.translate(75,75);

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK;break;
                    case 9: color = Color.RED;break;
                    default : color = Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }

        for(int i = 0; i < path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            System.out.println("X coordinate"+ pathx);
            System.out.println("Y coordinate"+ pathy);

            g.setColor(Color.GREEN);
            g.fillRect(30*pathx,30*pathy,25,25);
        }
    }

    public static void main(String[] args){
        Newclass view = new Newclass();
        view.setVisible(true);
    }
}
