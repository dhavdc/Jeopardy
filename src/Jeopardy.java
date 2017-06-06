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
    private final TextField tScoreteam2 = addTextField("0", 1720, 50, 200, 30, this); //Score counter for team two
    private final Button bLeaders = addButton("Leaders", 210, 100, 150, 100, this); //Topic button for Leaders category
    private final Button bReligion = addButton("Religion", 397, 100, 150, 100, this); //Topic button for Religion category
    private final Button bTimeperiods = addButton("Time Periods", 584, 100, 150, 100, this); //Topic button for Timeperiods category
    private final Button bTechnology = addButton("Technology", 771, 100, 150, 100, this);
    private final Button bImportantdates = addButton("NTN Dates", 958 , 100, 150, 100, this);
    //private final Button bCulture = addButton("Culture", LEFT,TOP , WIDTH, HEIGHT, this)
    private final Button bCulture = addButton("Culture", 1145, 100, 150, 100, this);
    private final Button bArtlit = addButton("Art/Arc", 1332, 100, 150, 100, this);
    private final Button bSocialstructure = addButton("Social Structure", 1519, 100, 150, 100, this);
    private final Button bPlayAgain = addButton("Play again", 822, 850, 250, 100, this);
    //Buttons under the topics
    private final Button bLeaders1 = addButton("100", 210, 225, 150, 100, this);
    private final Button bLeaders2 = addButton("200", 210, 350, 150, 100, this);
    private final Button bLeaders3 = addButton("300", 210, 475, 150, 100, this);
    private final Button bLeaders4 = addButton("400", 210, 600, 150, 100, this);
    private final Button bLeaders5 = addButton("500", 210, 725, 150, 100, this);
    private final Button bReligion1 = addButton("100", 397, 225, 150, 100, this);
    private final Button bReligion2 = addButton("200", 397, 350, 150, 100, this);
    private final Button bReligion3 = addButton("300", 397, 475, 150, 100, this);
    private final Button bReligion4 = addButton("400", 397, 600, 150, 100, this);
    private final Button bReligion5 = addButton("500", 397, 725, 150, 100, this);
    private final Button bTimeperiods1 = addButton("100", 584, 225, 150, 100, this);
    private final Button bTimeperiods2 = addButton("200", 584, 350, 150, 100, this);
    private final Button bTimeperiods3 = addButton("300", 584, 475, 150, 100, this);
    private final Button bTimeperiods4 = addButton("400", 584, 600, 150, 100, this);
    private final Button bTimeperiods5 = addButton("500", 584, 725, 150, 100, this);
    private final Button bTechnology1 = addButton("100", 771, 225, 150, 100, this);
    private final Button bTechnology2 = addButton("200", 771, 350, 150, 100, this);
    private final Button bTechnology3 = addButton("300", 771, 475, 150, 100, this);
    private final Button bTechnology4 = addButton("400", 771, 600, 150, 100, this);
    private final Button bTechnology5 = addButton("500", 771, 725, 150, 100, this);
    private final Button bImportantdates1 = addButton("100", 958, 225, 150, 100, this);
    private final Button bImportantdates2 = addButton("200", 958, 350, 150, 100, this);
    private final Button bImportantdates3 = addButton("300", 958, 475, 150, 100, this);
    private final Button bImportantdates4 = addButton("400", 958, 600, 150, 100, this);
    private final Button bImportantdates5 = addButton("500", 958, 725, 150, 100, this);
    private final Button bCulture1 = addButton("100", 1145, 225, 150, 100, this);
    private final Button bCulture2 = addButton("200", 1145, 350, 150, 100, this);
    private final Button bCulture3 = addButton("300", 1145, 475, 150, 100, this);
    private final Button bCulture4 = addButton("400", 1145, 600, 150, 100, this);
    private final Button bCulture5 = addButton("500", 1145, 725, 150, 100, this);
    private final Button bArtlit1 = addButton("100",1332, 225, 150, 100, this);
    private final Button bArtlit2 = addButton("200",1332, 350, 150, 100, this);
    private final Button bArtlit3 = addButton("300",1332, 475, 150, 100, this);
    private final Button bArtlit4 = addButton("400",1332, 600, 150, 100, this);
    private final Button bArtlit5 = addButton("500",1332, 725, 150, 100, this);
    private final Button bSocialstructure1 = addButton("100", 1519, 225, 150, 100, this);
    private final Button bSocialstructure2 = addButton("200", 1519, 350, 150, 100, this);
    private final Button bSocialstructure3 = addButton("300", 1519, 475, 150, 100, this);
    private final Button bSocialstructure4 = addButton("400", 1519, 600, 150, 100, this);
    private final Button bSocialstructure5 = addButton("500", 1519, 725, 150, 100, this);

 
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
        bCulture1.setBackground(new Color(66,244,149));
        bCulture2.setBackground(new Color(66,244,149));
        bCulture3.setBackground(new Color(66,244,149));
        bCulture4.setBackground(new Color(66,244,149));
        bCulture5.setBackground(new Color(66,244,149));
        bArtlit1.setBackground(new Color(66,244,149));
        bArtlit2.setBackground(new Color(66,244,149));
        bArtlit3.setBackground(new Color(66,244,149));
        bArtlit4.setBackground(new Color(66,244,149));
        bArtlit5.setBackground(new Color(66,244,149));
        bSocialstructure1.setBackground(new Color(66,244,149));
        bSocialstructure2.setBackground(new Color(66,244,149));
        bSocialstructure3.setBackground(new Color(66,244,149));
        bSocialstructure4.setBackground(new Color(66,244,149));
        bSocialstructure5.setBackground(new Color(66,244,149));
        
       
        bCulture.setBackground(new Color(64, 120, 209));
        bCulture.setFont (new Font("Arial", Font.BOLD, 16));
        bArtlit.setBackground(new Color(64,120,209));
        bArtlit.setFont(new Font("Arial", Font.BOLD, 16));
        bSocialstructure.setBackground(new Color(64,120,209));
        bSocialstructure.setFont(new Font("Arial", Font.BOLD, 16));
        
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
        if (source == bCulture) {
            culture();
        }
        if (source == bCulture1) {
            culture1();
        }
        if (source == bCulture2) {
            culture2();
        }
        if (source == bCulture3) {
            culture3();
        }
        if (source == bCulture4) {
            culture4();
        }
        if (source == bCulture5) {
           culture5();
        }
         if (source == bArtlit) {
            artlit();
        }
        if (source == bArtlit1) {
            artlit1();
        }
        if (source == bArtlit2) {
            artlit2();
        }
        if (source == bArtlit3) {
            artlit3();
        }
        if (source == bArtlit4) {
            artlit4();
        }
        if (source == bArtlit5) {
           artlit();
        }
         if (source == bSocialstructure) {
            culture();
        }
        if (source == bSocialstructure1) {
            culture1();
        }
        if (source == bSocialstructure2) {
            culture2();
        }
        if (source == bSocialstructure3) {
            culture3();
        }
        if (source == bSocialstructure4) {
            culture4();
        }
        if (source == bSocialstructure5) {
           culture5();
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
        tScoreteam1.setText(score + "");
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
        String importantdateansw4 = "The Battle of Tours (Europeans defeat Muslim Moors)";
        String guess = inputString(importantdateansw4);
        if (
                guess.equalsIgnoreCase("732 CE")
                        || guess.equalsIgnoreCase("732")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is 732 CE");
        }
        reset();
        bImportantdates2.setEnabled(false);

    }

    private void importantdates5()
    {
         String importantdateansw5 = "Neolithic Agricultural Revolution";
        String guess = inputString(importantdateansw5);
        if (
                guess.equalsIgnoreCase("8000 BCE")
                        || guess.equalsIgnoreCase("8000")
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer is 8000 BCE");
        }
        reset();
        bImportantdates2.setEnabled(false);

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
        String technologyansw1 = "Developed 600 BCE - 600 CE in India. ";
        String guess = inputString(technologyansw1);
        if (
                guess.equalsIgnoreCase("Arabic Numerals")
                        || guess.equalsIgnoreCase("Numbers")
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is arabic numerals or numbers");
        }
        reset();
        bTechnology1.setEnabled(false);

    }
    private void technology2()
    {
          String technologyansw3 = "Name one of the technologies developed in China through 600 CE - 1450.";
         String guess = inputString(technologyansw3);
        if (
                guess.equalsIgnoreCase("Paper Money")
                        || guess.equalsIgnoreCase("Block Printing")
                 || guess.equalsIgnoreCase("Gunpowder")
                 || guess.equalsIgnoreCase("Firearms")
                
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answers include paper money, block printing, gunpowder, firearms, etc.");
        }
        reset();
        bTechnology2.setEnabled(false);

    }
    private void technology3()
    {
        String technologyansw3 = "Developed 600 BCE - 600 CE in Persia. ";
        String guess = inputString(technologyansw3);
        if (
                guess.equalsIgnoreCase("Coins")
                        || guess.equalsIgnoreCase("Money")
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer is coins");
        }
        reset();
        bTechnology3.setEnabled(false);

    }
    private void technology4()
    {
        String technologyansw5 = "Developed 600 CE - 1450 in North Africa. ";
        String guess = inputString(technologyansw5);
        if (
                guess.equalsIgnoreCase("University")
                        || guess.equalsIgnoreCase("Schools")
                || guess.equalsIgnoreCase("School")
                || guess.equalsIgnoreCase("Universities")
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer is university or school");
        }
        reset();
        bTechnology5.setEnabled(false);

    }
    private void technology5()
    {
         String technologyansw5 = "Technologies developed in 1900 to the present (Europe and US). ";
        String guess = inputString(technologyansw5);
        if (
                guess.equalsIgnoreCase("Airplanes")
                || guess.equalsIgnoreCase("Airplane")
                        || guess.equalsIgnoreCase("Satellites")
                || guess.equalsIgnoreCase("Nuclear Power")
                || guess.equalsIgnoreCase("Television")
                || guess.equalsIgnoreCase("TV")
                || guess.equalsIgnoreCase("Internet")
                || guess.equalsIgnoreCase("Computers")
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! I don't even know how you got this wrong");
        }
        reset();
        bTechnology5.setEnabled(false);
        

    }

    private void timeperiods()
    {
        output("The answers are below, this is the title!");
       // int guess = inputInt("What year did WW II end?");
       // if (guess == 1945)
       // {
       //     score = score + 100;
       //     output("Right!");
       // }
       // else
       // {
       //     score = score - 100;
       //     output("Wrong... ");
       // }
       // bTimeperiods.setEnabled(false);

    }
    private void timeperiods1()
    {
         String timeperiodansw1 = "Which period? Technological and Environmental Transformation, to c. 600 B.C.E.";
        String guess = inputString(timeperiodansw1);
        if (
                guess.equalsIgnoreCase("1")
                        || guess.equalsIgnoreCase("One")
                || guess.equalsIgnoreCase("Period 1")
                || guess.equalsIgnoreCase("Period one")
                
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is period 1");
        }
        reset();
        bTimeperiods1.setEnabled(false);

    }
    private void timeperiods2()
    {
         String timeperiodansw2 = "Which period? Industrialization and Global Integration, c. 1750 to c. 1900.";
        String guess = inputString(timeperiodansw2);
        if (
                guess.equalsIgnoreCase("5")
                        || guess.equalsIgnoreCase("Five")
                || guess.equalsIgnoreCase("Period 5")
                || guess.equalsIgnoreCase("Period five")
                
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is period 5");
        }
        reset();
        bTimeperiods5.setEnabled(false);

    }
    private void timeperiods3()
    {
          String timeperiodansw2 = "Which period? Accelerating Global Change and Realignments, c. 1900 to the present.";
        String guess = inputString(timeperiodansw2);
        if (
                guess.equalsIgnoreCase("6")
                        || guess.equalsIgnoreCase("Six")
                || guess.equalsIgnoreCase("Period 6")
                || guess.equalsIgnoreCase("Period six")
                
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer is period 6");
        }
        reset();
        bTimeperiods3.setEnabled(false);
        

    }
    private void timeperiods4()
    {
           String timeperiodansw2 = "Which period? Regional and Transregional Interactions, c. 600 C.E. to c. 1450.";
        String guess = inputString(timeperiodansw2);
        if (
                guess.equalsIgnoreCase("3")
                        || guess.equalsIgnoreCase("Three")
                || guess.equalsIgnoreCase("Period 3")
                || guess.equalsIgnoreCase("Period three")
                
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer is period 3");
        }
        reset();
        bTimeperiods4.setEnabled(false);

    }
    private void timeperiods5()
    {
           String timeperiodansw2 = "Which period? Organization and Reorganization of Human Societies, c. 600 B.C.E. to c. 600 C.E.";
        String guess = inputString(timeperiodansw2);
        if (
                guess.equalsIgnoreCase("2")
                        || guess.equalsIgnoreCase("Two")
                || guess.equalsIgnoreCase("Period 2")
                || guess.equalsIgnoreCase("Period Two")
                
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer is period 2");
    }
        reset();
        bTimeperiods4.setEnabled(false);
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
        String religionansw1 = "Follow the laws of God as put forth in Torah; includes Ten Commandments and hundreds of other laws; purpose of life is to do God's work here; no \"promise\" of an afterlife";
        String guess = inputString(religionansw1);
        if (
                guess.equalsIgnoreCase("Judaism ")
                        || guess.equalsIgnoreCase("judism")
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer was Judaism");
        }
        bLeaders5.setEnabled(false);
        reset();

    }
    private void religion2()
    {
         String religionansw2 = "0ne God, Jesus Messiah Started in Middle East (2000 years old) as a sect of Judaism Spread through Mediterranean world through missionaries and Roman army and trade Church/Cathedral Bible";
        String guess = inputString(religionansw2);
        if (
                guess.equalsIgnoreCase("Christianity ")
                        || guess.equalsIgnoreCase("Christian")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer was Christianity");
        }
        bLeaders5.setEnabled(false);
        reset();

    }
    private void religion3()
    {
          String religionansw3 = "One God, many prophets (including Jesus) but Muhammad is the most important Started in Middle East (1400 years old) Spread through Mediterranean and Arab world through missionaries, traders, and conquest.";
        String guess = inputString(religionansw3);
        if (
                guess.equalsIgnoreCase("Islam ")
                        || guess.equalsIgnoreCase("Islam")
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer was Islam");
        }
        bLeaders5.setEnabled(false);
        reset();

    }
    private void religion4()
    {
         String religionansw4 = "Starts in India but spreads along trade routes; most common in China and Japan today";
        String guess = inputString(religionansw4);
        if (
                guess.equalsIgnoreCase("Buddhism ")
                        || guess.equalsIgnoreCase("Buddism")
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer was Buddhism");
        }
        bLeaders5.setEnabled(false);
        reset();
        

    }
    private void religion5()
    {
         String religionansw5 = "Caste System - reincarnation important to reward or punish past behavior, women were expected to be subservient to men; sati";
        String guess = inputString(religionansw5);
        if (
                guess.equalsIgnoreCase("Hinduism ")
                        || guess.equalsIgnoreCase("Hindu")
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer was Hinduism");
        }
        bLeaders5.setEnabled(false);
        reset();
    }
        private void culture()
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
    private void culture1()
    {
        String cultureansw1 = "In which continent was Christianity rooted in during the early modern era?";
        String guess = inputString(cultureansw1);
        if (
                guess.equalsIgnoreCase("Europe")
                        
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is Judaism");
        }
        bCulture1.setEnabled(false);
        reset();

    }
    private void culture2()
    {
         String cultureansw2 = "Which two African places were first to have a lot of Christian influence? Use and or &";
        String guess = inputString(cultureansw2);
        if (
                guess.equalsIgnoreCase("Ethiopia and Egypt")
                        || guess.equalsIgnoreCase("Ethiopia & Egypt")
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is Ethiopia and Egy[t");
        }
        bCulture2.setEnabled(false);
        reset();

    }
    private void culture3()
    {
          String cultureansw3 = "Which other religion posed a huge threat to Christianity?";
        String guess = inputString(cultureansw3);
        if (
                guess.equalsIgnoreCase("Islam")
                        
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer is Islam");
        }
        bCulture3.setEnabled(false);
        reset();

    }
    private void culture4()
    {
         String cultureansw4 = "For most of the 15th century, what provided a sense of unity in Europe?";
        String guess = inputString(cultureansw4);
        if (
                guess.equalsIgnoreCase("Roman Catholic Christianity")
                        || guess.equalsIgnoreCase("Catholic Christianity")
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer is Roman Catholic Christianity");
        }
        bCulture4.setEnabled(false);
        reset();
        

    }
    private void culture5()
    {
         String cultureansw5 = "Who was the first person to translate the New Testament into a language that common people could read?";
        String guess = inputString(cultureansw5);
        if (
                guess.equalsIgnoreCase("Martin Luther ")
                        || guess.equalsIgnoreCase("Luther")
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer is Martin Luther");
        }
        bCulture5.setEnabled(false);
        reset();
    }
     private void artlit()
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
    private void artlit1()
    {
        String artlitansw1 = "A form of writing developed by the Sumerians using a wedge shaped stylus and clay tablets.";
        String guess = inputString(artlitansw1);
        if (
                guess.equalsIgnoreCase("cuneiform")
                        
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is cuneiform");
        }
        bArtlit1.setEnabled(false);
        reset();

    }
    private void artlit2()
    {
         String artlitansw2 = "Massive pyramidal stepped tower made of mudbricks. It is associated with religious complexes in ancient Mesopotamian cities, but its function is unknown.";
        String guess = inputString(artlitansw2);
        if (
                guess.equalsIgnoreCase("Ziggurat")
                        
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is Ziggurat");
        }
        bArtlit2.setEnabled(false);
        reset();

    }
    private void artlit3()
    {
          String artlitansw3 = "Beautiful mausoleum at Agra built by the Mogul emperor Shah Jahan (completed in 1649) in memory of his favorite wife.";
        String guess = inputString(artlitansw3);
        if (
                guess.equalsIgnoreCase("Taj Mahal")
                        
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer is Taj Mahal");
        }
        bArtlit3.setEnabled(false);
        reset();

    }
    private void artlit4()
    {
         String artlitansw4 = "The Cathedral of Holy Wisdom in Constantinople, built by order of the Byzantine emperor Justinian";
        String guess = inputString(artlitansw4);
        if (
                guess.equalsIgnoreCase("Hagia Sophia")
                       
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer is Hagia Sophia");
        }
        bArtlit4.setEnabled(false);
        reset();
        

    }
    private void artlit5()
    {
         String artlitansw5 = "Muslim shrine containing the rock from which Mohammad is believed to have risen to heaven; Jews believe Abraham prepared to sacrifice his son Isaac on the rock.";
        String guess = inputString(artlitansw5);
        if (
                guess.equalsIgnoreCase("Dome of the rock ")
                        
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer is Dome of the rock");
        }
        bArtlit5.setEnabled(false);
        reset();
    }
         private void socialstructure()
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
    private void socialstructure1()
    {
        String socialstructureansw1 = "A person of noble or high rank; \"father figure\" to the people of Rome; aristocrat";
        String guess = inputString(socialstructureansw1);
        if (
                guess.equalsIgnoreCase("Patrician")
                || guess.equalsIgnoreCase("Patricians")
                
                        
                )   // || or
        {
            score = score + 100;
            output("Correct!");
        }

        else
        {
            score = score - 100;
            output("Incorrect! The answer is Patrician");
        }
        bSocialstructure1.setEnabled(false);
        reset();

    }
    private void socialstructure2()
    {
         String artlitansw2 = "Name belonging or pertaining to the common people of the Roman Republic";
        String guess = inputString(artlitansw2);
        if (
                guess.equalsIgnoreCase("Plebian")
                || guess.equalsIgnoreCase("Plebians")
                        
                )   // || or
        {
            score = score + 200;
            output("Correct!");
        }

        else
        {
            score = score - 200;
            output("Incorrect! The answer is Plebian");
        }
        bSocialstructure2.setEnabled(false);
        reset();

    }
    private void socialstructure3()
    {
          String artlitansw3 = "Spaniards born in the Americas were called this. Often resented those born in Spain who thought they were better.";
        String guess = inputString(artlitansw3);
        if (
                guess.equalsIgnoreCase("Creoles")
                   || guess.equalsIgnoreCase("Creole")

              
  
                        
                )   // || or
        {
            score = score + 300;
            output("Correct!");
        }

        else
        {
            score = score - 300;
            output("Incorrect! The answer is Creoles");
        }
        bArtlit3.setEnabled(false);
        reset();

    }
    private void socialstructure4()
    {
         String artlitansw4 = "People in the new colonial societies in Mexico and Peru who were mixed-race of Spanish and Indian decent./Spaniards often looked down on them as illegitimate.";
        String guess = inputString(artlitansw4);
        if (
                guess.equalsIgnoreCase("Mestizos")
                       
                )   // || or
        {
            score = score + 400;
            output("Correct!");
        }

        else
        {
            score = score - 400;
            output("Incorrect! The answer is Mestizo");
        }
        bArtlit4.setEnabled(false);
        reset();
        

    }
    private void socialstructureit5()
    {
         String artlitansw5 = "A member of the lowest caste; untouchables";
        String guess = inputString(artlitansw5);
        if (
                guess.equalsIgnoreCase("Dalit")
                || guess.equalsIgnoreCase("Dalits")
                        
                )   // || or
        {
            score = score + 500;
            output("Correct!");
        }

        else
        {
            score = score - 500;
            output("Incorrect! The answer is Dalit");
        }
        bArtlit5.setEnabled(false);
        reset();
    }
    private void reset() //Checks to see if the game has ended and allows the Play Again button to be enabled (resets the game)
    {
       //Do nothing it's redundant because I had to finish this quick.
     
    }

    private void playSound() {

      
    }
    private void turnOff(){

    }
    private void litmode()
    {
        
    }
}



