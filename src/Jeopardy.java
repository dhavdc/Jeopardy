import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.io.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.audio.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;

public class Jeopardy extends EasyApp {
    public static void main(String[] args) {
        new Jeopardy();
    }

    //Topic buttons and score declaration
    private final TextField tScoreteam1 = addTextField("0", 1720, 50, 200, 30, this); //Score counter for team one
    private final TextField tScoreteam2 = addTextField(0, 1720, 50, 200, 30, this); //Score counter for team two
    private final Button bLeaders = addButton("Leaders", 274, 100, 250, 100, this); //Topic button for Leaders category
    private final Button bReligion = addButton("Religion", 548, 100, 250, 100, this); //Topic button for Religion category
    private final Button bTimeperiods = addButton("Time Periods", 822, 100, 250, 100, this); //Topic button for Timeperiods category
    private final Button bTechnology = addButton("Technology", 1096, 100, 250, 100, this);
    private final Button bImportantdates = addButton("Important Dates", 1370, 100, 250, 100, this);
    private final Button bPlayAgain = addButton("Play again", 822, 850, 250, 100, this);
    //Buttons under the topics
    private final Button bLeaders1 = addButton("100", 274, 225, 250, 100, this);
    private final Button bLeaders2 = addButton("200", 274, 350, 250, 100, this);
    private final Button bLeaders3 = addButton("300", 274, 475, 250, 100, this);
    private final Button bLeaders4 = addButton("400", 274, 600, 250, 100, this);
    private final Button bLeaders5 = addButton("500", 274, 725, 250, 100, this);
    private final Button bReligion1 = addButton("100", 548, 225, 250, 100, this);
    private final Button bReligion2 = addButton("200", 548, 350, 250, 100, this);
    private final Button bReligion3 = addButton("300", 548, 475, 250, 100, this);
    private final Button bReligion4 = addButton("400", 548, 600, 250, 100, this);
    private final Button bReligion5 = addButton("500", 548, 725, 250, 100, this);
    private final Button bTechnology1 = addButton("100", 1096, 225, 250, 100, this);
    private final Button bTechnology2 = addButton("200", 1096, 350, 250, 100, this);
    private final Button bTechnology3 = addButton("300", 1096, 475, 250, 100, this);
    private final Button bTechnology4 = addButton("400", 1096, 600, 250, 100, this);
    private final Button bTechnology5 = addButton("500", 1096, 725, 250, 100, this);
    private final Button bTimeperiods1 = addButton("100", 822, 225, 250, 100, this);
    private final Button bTimeperiods2 = addButton("200", 822, 350, 250, 100, this);
    private final Button bTimeperiods3 = addButton("300", 822, 475, 250, 100, this);
    private final Button bTimeperiods4 = addButton("400", 822, 600, 250, 100, this);
    private final Button bTimeperiods5 = addButton("500", 822, 725, 250, 100, this);
    private final Button bImportantdates1 = addButton("100", 1370, 225, 250, 100, this);
    private final Button bImportantdates2 = addButton("200", 1370, 350, 250, 100, this);
    private final Button bImportantdates3 = addButton("300", 1370, 475, 250, 100, this);
    private final Button bImportantdates4 = addButton("400", 1370, 600, 250, 100, this);
    private final Button bImportantdates5 = addButton("500", 1370, 725, 250, 100, this);
    private final Button blitmode = addButton("Lit Mode",20,100,200,100,this );
    boolean buttonOn = true;


    private int score = 0;

    private Jeopardy()   // Constructor - change window appearance
    {
        setSize(1920, 1080);
        setTitle("AP World History ");
        Label lJeopardy = addLabel("Jeopardy", 860, 30, 200, 60, this);
        Label lScore = addLabel("Score:", 1670, 50, 50, 30, this);
        lJeopardy.setFont(new Font("Arial", Font.BOLD, 36));
        lJeopardy.setBackground(new Color(255, 255, 180));
        lJeopardy.setForeground(Color.blue);
        lScore.setBackground(new Color(255, 255, 180));
        setBackground(new Color(255, 255, 180));
        bImportantdates.setFont(new Font("Arial", Font.BOLD, 16));
        bImportantdates.setBackground(new Color(64, 120, 209));
        bTechnology.setFont(new Font("Arial", Font.BOLD, 16));
        bTechnology.setBackground(new Color(64, 120, 209));
        bLeaders.setFont(new Font("Arial", Font.BOLD, 16));
        bLeaders.setBackground(new Color(64, 120, 209));
        bTimeperiods.setFont(new Font("Arial", Font.BOLD, 16));
        bTimeperiods.setBackground(new Color(64, 120, 209));
        bReligion.setFont(new Font("Arial", Font.BOLD, 16));
        bReligion.setBackground(new Color(64, 120, 209));
        bPlayAgain.setFont(new Font("Arial", Font.BOLD, 16));
        bLeaders1.setBackground(new Color(66,244,149));
        bLeaders2.setBackground(new Color(66,244,149));
        bLeaders3.setBackground(new Color(66,244,149));
        bLeaders4.setBackground(new Color(66,244,149));
        bLeaders5.setBackground(new Color(66,244,149));
        bReligion1.setBackground(new Color(66,244,149));
        bReligion2.setBackground(new Color(66,244,149));
        bReligion3.setBackground(new Color(66,244,149));
        bReligion4.setBackground(new Color(66,244,149));
        bReligion5.setBackground(new Color(66,244,149));
        bTechnology1.setBackground(new Color(66,244,149));
        bTechnology2.setBackground(new Color(66,244,149));
        bTechnology3.setBackground(new Color(66,244,149));
        bTechnology4.setBackground(new Color(66,244,149));
        bTechnology5.setBackground(new Color(66,244,149));
        bTimeperiods1.setBackground(new Color(66,244,149));
        bTimeperiods2.setBackground(new Color(66,244,149));
        bTimeperiods3.setBackground(new Color(66,244,149));
        bTimeperiods4.setBackground(new Color(66,244,149));
        bTimeperiods5.setBackground(new Color(66,244,149));
        bImportantdates1.setBackground(new Color(66,244,149));
        bImportantdates2.setBackground(new Color(66,244,149));
        bImportantdates3.setBackground(new Color(66,244,149));
        bImportantdates4.setBackground(new Color(66,244,149));
        bImportantdates4.setBackground(new Color(66,244,149));
        bImportantdates5.setBackground(new Color(66,244,149));
        boolean buttonOn = true;
        playSound();









    }

    public void actions(Object source, String command) {
        if (source == bLeaders) {
            leaders();
        }
        if (source == bLeaders1) {
            leaders1();
        }
        if (source == bLeaders2) {
            leaders2();
        }
        if (source == bLeaders3) {
            leaders3();
        }
        if (source == bLeaders4) {
            leaders4();
        }
        if (source == bLeaders5) {
            leaders5();
        }
        if (source == bReligion) {
            religion();
        }
        if (source == bReligion1) {
            religion1();
        }
        if (source == bReligion2) {
            religion2();
        }
        if (source == bReligion3) {
            religion3();
        }
        if (source == bReligion4) {
            religion4();
        }
        if (source == bReligion5) {
            religion5();
        }
        if (source == bTechnology) {
            technology();
        }
        if (source == bTechnology1) {
            technology1();
        }
        if (source == bTechnology2) {
            technology2();
        }
        if (source == bTechnology3) {
            technology3();
        }
        if (source == bTechnology4) {
            technology4();
        }
        if (source == bTechnology5) {
            technology5();
        }
        if (source == bTimeperiods) {
            timeperiods();
        }
        if (source == bTimeperiods1) {
            timeperiods1();
        }
        if (source == bTimeperiods2) {
            timeperiods2();
        }
        if (source == bTimeperiods3) {
            timeperiods3();
        }
        if (source == bTimeperiods4) {
            timeperiods4();
        }
        if (source == bTimeperiods5) {
            timeperiods5();
        }
        if (source == bImportantdates) {
            importantdates();
        }
        if (source == bImportantdates1) {
            importantdates1();
        }
        if (source == bImportantdates2) {
            importantdates2();
        }
        if (source == bImportantdates3) {
            importantdates3();
        }
        if (source == bImportantdates4) {
            importantdates4();
        }
        if (source == bImportantdates5) {
            importantdates5();
        }
        if (source == blitmode)
        {
            litmode();
        }
        if (source == bPlayAgain) {
            bImportantdates1.setEnabled(true);
            bImportantdates2.setEnabled(true);
            bImportantdates3.setEnabled(true);
            bImportantdates4.setEnabled(true);
            bImportantdates5.setEnabled(true);
            bTechnology1.setEnabled(true);
            bTechnology2.setEnabled(true);
            bTechnology3.setEnabled(true);
            bTechnology4.setEnabled(true);
            bTechnology5.setEnabled(true);
            bLeaders1.setEnabled(true);
            bLeaders2.setEnabled(true);
            bLeaders3.setEnabled(true);
            bLeaders4.setEnabled(true);
            bLeaders5.setEnabled(true);
            bTimeperiods1.setEnabled(true);
            bTimeperiods2.setEnabled(true);
            bTimeperiods3.setEnabled(true);
            bTimeperiods4.setEnabled(true);
            bTimeperiods5.setEnabled(true);
            bReligion1.setEnabled(true);
            bReligion2.setEnabled(true);
            bReligion3.setEnabled(true);
            bReligion4.setEnabled(true);
            bReligion5.setEnabled(true);
            bPlayAgain.setEnabled(false);
            score = 0;
        }
        tScore.setText(score + "");
    }

    private void importantdates() {
        output("The answers are below, this is the title!");
        // String guess = inputString("");
        //if (guess.equals("")) {
            //score = score + 100;
            //output("Right!");
       // } else {
          //  score = score - 100;
            //output("Wrong...");
       // }
    }

    private void importantdates1() {
        String importantdateansw1 = "Beginning of Mongol Conquests";
        String guess = inputString(importantdateansw1);
        if (
                guess.equalsIgnoreCase("1211 CE")
                        || guess.equalsIgnoreCase("1211 ce")
                        || guess.equalsIgnoreCase("1211")
                        || guess.equalsIgnoreCase("1200 CE")
                        || guess.equalsIgnoreCase("1200")
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is 1211 CE");
        }
        reset();
        bImportantdates1.setEnabled(false);
        
        
        

    }

    private void importantdates2() {
        String importantdateansw2 = "Beginning of Protestant Reformation";
        String guess = inputString(importantdateansw2);
        if (
                guess.equalsIgnoreCase("1517 CE")
                        || guess.equalsIgnoreCase("1517")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is 1517 CE");
        }
        reset();
        bImportantdates2.setEnabled(false);

    }

    private void importantdates3() {
        String importantdateansw3 = "Beginning of the Industrial Revolution";
        String guess = inputString(importantdateansw3);
        if (
                guess.equalsIgnoreCase("1750 CE")
                        || guess.equalsIgnoreCase("1750")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is 1750 CE");
        }
        reset();
        bImportantdates2.setEnabled(false);
        

    }

    private void importantdates4() {

    }

    private void importantdates5()
    {

    }

    private void technology()
    {
        output("The answers are below, this is the title!");
        /*String guess = inputString("");
        if (
                guess.equalsIgnoreCase("")
                        || guess.equalsIgnoreCase("")
                        || guess.equalsIgnoreCase("")
                )   // || or
        {
            score = score + 100;
            output("Right!");
        }

        else
        {
            score = score - 100;
            output("Wrong...");
        }
        bTechnology.setEnabled(false);
        */
    }
    private void technology1()
    {

    }
    private void technology2()
    {

    }
    private void technology3()
    {

    }
    private void technology4()
    {

    }
    private void technology5()
    {

    }

    private void timeperiods()
    {
        output("The answers are below, this is the title!");
        int guess = inputInt("What year did WW II end?");
        if (guess == 1945)
        {
            score = score + 100;
            output("Right!");
        }
        else
        {
            score = score - 100;
            output("Wrong... ");
        }
        bTimeperiods.setEnabled(false);

    }
    private void timeperiods1()
    {

    }
    private void timeperiods2()
    {

    }
    private void timeperiods3()
    {

    }
    private void timeperiods4()
    {

    }
    private void timeperiods5()
    {

    }

    private void leaders()
    {
        output("The answers are below, this is the title!");

    }
    private void leaders1()
    {
        String leaderansw1 = "King of Macedonia in northern Greece, Between 334 and 323 BCE, he conquered the Persian Empire, reached the Indus Valley, founded many Greek-style cities, and spread Greek culture across the Middle East.";
        String guess = inputString(leaderansw1);
        if (
                guess.equalsIgnoreCase("Alexander The Great")
                        || guess.equalsIgnoreCase("Alexandor the great")
                        || guess.equalsIgnoreCase("Alex the great")
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer was Alexander the Great");
        }
        reset();
        bLeaders1.setEnabled(false);

    }
    private void leaders2()
    {
        String leaderansw2 = "Bolshevik revolutionary, head of the Soviet Communist Party after 1924, and dictator of the Soviet Union from 1928-1953. He led the Soviet Union with an iron fist, using Five-Year Plans to increase industrial production and terror to crush all opposition.";
        String guess = inputString(leaderansw2);
        if (
                guess.equalsIgnoreCase("Josef Stalin")
                        || guess.equalsIgnoreCase("Joseph Stalin")
                        || guess.equalsIgnoreCase("Stalin")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer was Josef Stalin");
        }
        bLeaders2.setEnabled(false);
        reset();

    }


    private void leaders3()
    {
        String leaderansw3 = "Leader of the Bolshevik (later Communist) Party. He lived in exile in Switzerland until 1917, then returned to Russia to lead the Bolsheviks to victory during the Russian Revolution and the civil wars that followed.";
        String guess = inputString(leaderansw3);
        if (
                guess.equalsIgnoreCase("Vladamir Lenin")
                        || guess.equalsIgnoreCase("Lenin")
                        || guess.equalsIgnoreCase("Vladomir Lenin")
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer was Vladamir Lenin");
        }
        bLeaders3.setEnabled(false);
        reset();

    }
    private void leaders4()
    {
        String leaderansw4 = "Leader of Egyptian modernization in the early 19th century. He ruled Egypt as an Ottoman governor, but had imperial ambitions. His descendants ruled Egypt until overthrown in 1952.";
        String guess = inputString(leaderansw4);
        if (
                guess.equalsIgnoreCase("Muhammad Ali")
                        || guess.equalsIgnoreCase("mahammad ali")
                        || guess.equalsIgnoreCase("Muhammad")
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer was Muhammad Ali");
        }
        bLeaders4.setEnabled(false);
        reset();

    }
    private void leaders5()
    {
        String leaderansw5 = "Born in Austria, he became a radical German nationalist during World War I. He led the Nazi party in the 1920s and became dictator of Germany in 1933. He led Europe into World War II.";
        String guess = inputString(leaderansw5);
        if (
                guess.equalsIgnoreCase("Adolf Hilter ")
                        || guess.equalsIgnoreCase("Adolf Hitler")
                        || guess.equalsIgnoreCase("Hitler")
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer was Adolf Hitler");
        }
        bLeaders5.setEnabled(false);
        reset();
    }

    private void religion()
    {
        output("The answers are below, this is the title!");
        /*int guess = inputInt("What is a perfect score in bowling?");
        if ( guess == 300 )
        {
            score = score + 200;
            output("Right!");
        }
        else
        {
            score = score - 200;
            output("Wrong... " );
        }
        bReligion.setEnabled(false);
        */
    }
    private void religion1()
    {

    }
    private void religion2()
    {

    }
    private void religion3()
    {

    }
    private void religion4()
    {

    }
    private void religion5()
    {
    }
    private void reset() //Checks to see if the maximum score is reached and allows the Play Again button to be enabled (resets the game)
    {
        if (score == 7500){
            bPlayAgain.setEnabled(true);
        }
    }

    private void playSound() {

      
    }
    private void turnOff(){

    }
    private void litmode()
    {
        
    }
}



