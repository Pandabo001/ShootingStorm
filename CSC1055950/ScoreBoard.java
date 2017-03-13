import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Menu
{

    /**
     * Constructor for objects of class ScoreBoard.
     * 
     */
    public ScoreBoard()
    {
        List<String> entry = new ArrayList<String>();
        int entryCount = 0;
        try{
            FileReader reader = new FileReader("scores.txt");
            BufferedReader in = new BufferedReader(reader);
            String tmp;
            while((tmp = in.readLine()) != null){
                entry.add(tmp);
                entryCount++;
            }
            reader.close();
        }
        catch(IOException e){
        }
        String[] date = new String[entryCount];
        int[] score = new int[entryCount];
        int i = 0;
        while(i < entry.size()){
            date[i] = entry.get(i).split(" ", 3)[0] + "  " + entry.get(i).split(" ", 3)[1];
            score[i] = Integer.parseInt(entry.get(i).split(" ", 3)[2]);
            i++;
        }
        
        while(i < entryCount){
            for(int j = i + 1; j < entryCount; j++){
                if(score[i] < score[j]){
                    String tmpd = date[i];
                    int tmps = score[i];
                    date[i] = date[j];
                    score[i] = score[j];
                    date[j] = tmpd;
                    score[j] = tmps;
                }
            }
            i++;
        }
        GreenfootImage scoreboard = new GreenfootImage("scoreboard.png");
        BG.scale(BG.getWidth() * getHeight() / BG.getHeight(), getHeight());
        getFont();
        scoreboard.setFont(font.deriveFont(20f));
        scoreboard.setColor(Color.orange);
        scoreboard.drawString("PLACE", 15, 27);
        scoreboard.drawString("SCORE", 101, 27);
        scoreboard.drawString("DATE AND TIME", 437, 27);
        while(i < 20){
            if(i < entryCount){
                scoreboard.drawString((i + 1) + ".", 15, 57 + i * 22);
                scoreboard.drawString(score[i] + "", 101, 57 + i * 22);
                scoreboard.drawString(date[i] + "", 437, 57 + i * 22);
            }
            else{
                scoreboard.drawString((i + 1) + ".", 15, 57 + i * 22);
                scoreboard.drawString("---", 101, 57 + i * 22);
                scoreboard.drawString("---", 437, 57 + i * 22);
            }
            i++;
        }
        BG.drawImage(scoreboard, 0, 0);
        setBackground(BG);
        addObject(new BackButton(), 125, 550);
    }
    
}
