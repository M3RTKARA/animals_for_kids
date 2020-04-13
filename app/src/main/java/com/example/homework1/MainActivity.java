package com.example.homework1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import android.content.Context;

public class MainActivity extends AppCompatActivity {

    public int counter = 0;
    public int level =1;
    TextView leveltextview;
    TextView scoretextview;
    TextView timetextview;
    int butarr[] = new int[5];
    CountDownTimer countDownTimer;
    ImageButton rightanswer;
    int rightindex;


    ImageButton[] imageButtonArray = new ImageButton[8];
    String[] animalArray = new String[20];

    MediaPlayer[] animalSoundArray = new MediaPlayer[20];
    Bitmap[] animalImageArray = new Bitmap[20];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SOME VARIABLE DECLARATIONS

        timetextview = findViewById(R.id.timeview);
        leveltextview =  findViewById(R.id.levelview);
        scoretextview =  findViewById(R.id.scoreview);

        animalArray[0] =  "bird";
        animalArray[1] =  "cat";
        animalArray[2] =  "cow";
        animalArray[3] =  "dog";
        animalArray[4] =  "horse";
        animalArray[5] =  "monkey";
        animalArray[6] =  "bee";
        animalArray[7] =  "lion";
        animalArray[8] =  "duck";
        animalArray[9] =  "pig";
        animalArray[10] =  "sheep";
        animalArray[11] =  "donkey";
        animalArray[12] =  "chicken";
        animalArray[13] =  "rooster";
        animalArray[14] =  "owl";
        animalArray[15] =  "turkey";
        animalArray[16] =  "mosquitoes";
        animalArray[17] =  "cricket";
        animalArray[18] =  "frog";
        animalArray[19] =  "mouse";


        animalSoundArray[0] =  MediaPlayer.create(this, R.raw.find_bird);
        animalSoundArray[1] =  MediaPlayer.create(this, R.raw.find_cat);
        animalSoundArray[2] =  MediaPlayer.create(this, R.raw.find_cow);
        animalSoundArray[3] =  MediaPlayer.create(this, R.raw.find_dog);
        animalSoundArray[4] =  MediaPlayer.create(this, R.raw.find_horse);
        animalSoundArray[5] =  MediaPlayer.create(this, R.raw.find_monkey);
        animalSoundArray[6] =  MediaPlayer.create(this, R.raw.find_bee);
        animalSoundArray[7] =  MediaPlayer.create(this, R.raw.find_lion);
        animalSoundArray[8] =  MediaPlayer.create(this, R.raw.find_duck);
        animalSoundArray[9] =  MediaPlayer.create(this, R.raw.find_pig);
        animalSoundArray[10] =  MediaPlayer.create(this, R.raw.find_sheep);
        animalSoundArray[11] =  MediaPlayer.create(this, R.raw.find_donkey);
        animalSoundArray[12] =  MediaPlayer.create(this, R.raw.find_chicken);
        animalSoundArray[13] =  MediaPlayer.create(this, R.raw.find_rooster);
        animalSoundArray[14] =  MediaPlayer.create(this, R.raw.find_owl);
        animalSoundArray[15] =  MediaPlayer.create(this, R.raw.find_turkey);
        animalSoundArray[16] =  MediaPlayer.create(this, R.raw.find_mosquitoes);
        animalSoundArray[17] =  MediaPlayer.create(this, R.raw.find_cricket);
        animalSoundArray[18] =  MediaPlayer.create(this, R.raw.find_frog);
        animalSoundArray[19] =  MediaPlayer.create(this, R.raw.find_mouse);





        imageButtonArray[0] =  findViewById(R.id.button1);
        imageButtonArray[1] =  findViewById(R.id.button2);
        imageButtonArray[2] =  findViewById(R.id.button3);
        imageButtonArray[3] =  findViewById(R.id.button4);
        imageButtonArray[4] =  findViewById(R.id.button5);
        imageButtonArray[5] =  findViewById(R.id.button6);
        imageButtonArray[6] =  findViewById(R.id.button7);
        imageButtonArray[7] =  findViewById(R.id.button8);

        animalImageArray[0] = BitmapFactory.decodeResource(getResources(),R.drawable.bird);
        animalImageArray[1] = BitmapFactory.decodeResource(getResources(),R.drawable.cat);
        animalImageArray[2] = BitmapFactory.decodeResource(getResources(),R.drawable.cow);
        animalImageArray[3] = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
        animalImageArray[4] = BitmapFactory.decodeResource(getResources(),R.drawable.horse);
        animalImageArray[5] = BitmapFactory.decodeResource(getResources(),R.drawable.monkey);
        animalImageArray[6] = BitmapFactory.decodeResource(getResources(),R.drawable.rabbit);
        animalImageArray[7] = BitmapFactory.decodeResource(getResources(),R.drawable.lion);
        animalImageArray[8] = BitmapFactory.decodeResource(getResources(),R.drawable.duck);
        animalImageArray[9] = BitmapFactory.decodeResource(getResources(),R.drawable.pig);
        animalImageArray[10] = BitmapFactory.decodeResource(getResources(),R.drawable.sheep);
        animalImageArray[11] = BitmapFactory.decodeResource(getResources(),R.drawable.donkey);
        animalImageArray[12] = BitmapFactory.decodeResource(getResources(),R.drawable.chicken);
        animalImageArray[13] = BitmapFactory.decodeResource(getResources(),R.drawable.rooster);
        animalImageArray[14] = BitmapFactory.decodeResource(getResources(),R.drawable.owl);
        animalImageArray[15] = BitmapFactory.decodeResource(getResources(),R.drawable.turkey);
        animalImageArray[16] = BitmapFactory.decodeResource(getResources(),R.drawable.mosquitoes);
        animalImageArray[17] = BitmapFactory.decodeResource(getResources(),R.drawable.cricket);
        animalImageArray[18] = BitmapFactory.decodeResource(getResources(),R.drawable.frog);
        animalImageArray[19] = BitmapFactory.decodeResource(getResources(),R.drawable.mouse);




        butarr[0]=2;
        butarr[1]=3;
        butarr[2]=4;
        butarr[3]=6;
        butarr[4]=8;



        //READ THE BEST POINT
        String alltext="";
        try{
            Scanner scan = new Scanner(
                    openFileInput("out.txt")
            );
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                alltext+=line;
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }



        //IF THIS IS NOT THE FIRST TIME PLAYING THIS GAME
        if (alltext!="")
        {
            level = Integer.parseInt(alltext);
            if(butarr[0] != butarr[level-1])
            {
                for(int i=butarr[0];i<butarr[level-1];i++)
                {
                    imageButtonArray[i].setVisibility(Button.VISIBLE);
                }

            }

        }



        //IF THERE IS NOTHING WRITTEN IN THE OUT.TXT FILE
        else
        {

            level=1;
            counter=0;
            FileOutputStream outputStream;
            try{
                outputStream = openFileOutput("out.txt", Context.MODE_PRIVATE);

                outputStream.write(String.valueOf(level).getBytes());
                outputStream.flush();
                outputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();

            }

        }






        //imageButtonArray[0].setVisibility(Button.VISIBLE);
        //imageButtonArray[1].setVisibility(Button.VISIBLE);

        //imageButtonArray[0].setImageBitmap(animalImageArray[5]);

        produce();


    }

    private void produce() {



        Random generate = new Random();

        //PRINT THE CURRENT LEVEL AND SCORE
        //scoretextview.setText(Integer.toString(counter + ((level-1))*5));
        scoretextview.setText(Integer.toString(counter));
        leveltextview.setText(Integer.toString(level));

        int chosenImg;
        int chosenBtn;
        long Sec=(long) (20000 - ((level-1)*3000));




        //int temp[] = new int[butarr[level-1]];

        String alltext="";
        try{
            Scanner scan = new Scanner(
                    openFileInput("out.txt")
            );
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                alltext+=line;
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }



        chosenImg = generate.nextInt(20);
        chosenBtn = generate.nextInt(butarr[level-1]);



        for(int i=0;i<butarr[level-1];i++)
        {
            if(i==chosenBtn)
            {
                rightanswer=imageButtonArray[i];
                rightindex=chosenImg;
                imageButtonArray[i].setImageBitmap(animalImageArray[chosenImg]);


                System.out.println("chosenimg"+ chosenImg);
                System.out.println("chosenbtn"+ chosenBtn);

            }
            else
            {
                int tempimg = generate.nextInt(20);
                while(tempimg==chosenImg)
                {
                    tempimg = generate.nextInt(20);
                }

                imageButtonArray[i].setImageBitmap(animalImageArray[tempimg]);
            }

        }
        animalSoundArray[chosenImg].start();





        //THE COUNTDOWN FOR BONUS
        countDownTimer = new CountDownTimer(Sec , 1000) {

            public void onTick(long millisUntilFinished) {
                timetextview.setText(" " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                counter=0;
                level=1;
                try{
                    PrintStream output = new PrintStream(
                            openFileOutput("out.txt",MODE_PRIVATE)
                    );
                    output.println(level);
                    output.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }



                //WHEN TIME IS UP
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        // When timer is finished
                        System.exit(0);
                        // Execute your code here
                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                        builder.setTitle("TIME IS UP!!");
                        builder.setMessage("Exits in " + millisUntilFinished/1000 + " seconds");
                        AlertDialog dialog =builder.create();
                        dialog.show();
                    }
                }.start();

                AlertDialog dialog =builder.create();
                dialog.show();

            }

        }.start();


    }

    //FUNCTION TO COMPARE BUTTONS
    public void compare(View view) {

        /*for(int i=0;i<20;i++)
        {
            if(animalSoundArray[i].isPlaying()==true)
            {
                animalSoundArray[i].stop();
            }
        }
*/
        countDownTimer.cancel();

        if(view.getId()==rightanswer.getId())
        {
            animalSoundArray[rightindex].stop();

            MediaPlayer got_it =  MediaPlayer.create(this, R.raw.gotit);

            got_it.start();

            while(got_it.isPlaying()==true)
            {
                //wait
            }
            got_it.stop();



            if(counter!=3)
            {
                counter++;
            }
            else
            {
                if(level==5)
                {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("YOU WON!!");
                    builder.setMessage("Congratulations!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            new CountDownTimer(5000, 1000) {
                                public void onFinish() {

                                    // When timer is finished
                                    counter=0;
                                    level=1;
                                    try{
                                        PrintStream output = new PrintStream(
                                                openFileOutput("out.txt",MODE_PRIVATE)
                                        );
                                        output.println(level);
                                        output.close();
                                    }
                                    catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    System.exit(0);
                                    // Execute your code here
                                }

                                public void onTick(long millisUntilFinished) {
                                    // millisUntilFinished    The amount of time until finished.
                                    builder.setMessage("Exits in " + millisUntilFinished/1000 + " seconds");
                                    AlertDialog dialog =builder.create();
                                    dialog.show();
                                }
                            }.start();
                        }
                    });
                    AlertDialog dialog =builder.create();
                    dialog.show();
                }
                else
                {
                    counter=0;
                    ++level;
                    FileOutputStream outputStream;
                    try{
                        outputStream = openFileOutput("out.txt", Context.MODE_PRIVATE);

                        outputStream.write(String.valueOf(level).getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();

                    }

                }
                if(butarr[level-1] != butarr[level-2])
                {
                    for(int i=butarr[level-2];i<butarr[level-1];i++)
                    {
                        imageButtonArray[i].setVisibility(View.VISIBLE);
                    }

                }
            }
            produce();
        }
        //IF WRONG BUTTON IS PRESSED
        else
        {
            counter=0;
            level=1;

            FileOutputStream outputStream;
            try{
                outputStream = openFileOutput("out.txt", Context.MODE_PRIVATE);

                outputStream.write(String.valueOf(level).getBytes());
                outputStream.flush();
                outputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();

            }



            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            new CountDownTimer(5000, 1000) {
                public void onFinish() {
                    // When timer is finished
                    //System.exit(0);
                    Bundle tempBundle = new Bundle();
                    onCreate(tempBundle);
                    // Execute your code here
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                    builder.setTitle("YOU LOSE!!");
                    builder.setMessage("Exits in " + millisUntilFinished/1000 + " seconds");
                    AlertDialog dialog =builder.create();
                    dialog.show();
                }
            }.start();

            AlertDialog dialog =builder.create();
            dialog.show();
        }





    }
}
