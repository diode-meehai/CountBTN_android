package com.meehai.btn_meehai;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //--------------Variable-------------//
    TextView textView1;
    int Click_BTN;
    MediaPlayer _Sound;
    Boolean Check_sound = false;
    int[] Sounds_List = {R.raw.dad, R.raw.mai, R.raw.off, R.raw.ploy, R.raw.pon, R.raw.ta};
    //--------------Variable-------------//

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView)findViewById(R.id.TextView1);
    }

    public void CLick_showMessage(View view) {

        stopPlaying();
        //--------------- BTN Random Color -------------------//
        /*Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        BTN_color.setBackgroundColor(color);*/

        //---------------- Vibrator---------------------//
        Vibrator _vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        _vibrator.vibrate(200);

        Click_BTN ++;
        textView1.setText( "Count : " + Integer.toString(Click_BTN));

        //------------------- Sound Random ----------------------//
        if(Check_sound == false) {
            Random r = new Random();
            int Low = 0;
            int High = 5;
            int rndm = r.nextInt(High - Low) + Low;
            //int rndm = r.nextInt(5);
            _Sound = MediaPlayer.create(getApplicationContext(), Sounds_List[rndm]);
            _Sound.start();

        }
    }

    //----------------------- Clear Score ---------------//
    public void ClearMessage(View view) {
        Toast.makeText(this, "Clear Number", Toast.LENGTH_SHORT).show();
        Click_BTN = 0;
        textView1.setText("Count : " + Integer.toString(Click_BTN));
    }

    //----------------------- Sound ---------------//
    public void Sound_btn(View view) {

        if(Check_sound == false)
        {
            Check_sound = true;
            Toast.makeText(this, "Sound Off", Toast.LENGTH_SHORT).show();
        }
        else if(Check_sound == true)
        {
            Check_sound = false;
            Toast.makeText(this, "Sound On", Toast.LENGTH_SHORT).show();
        }
    }

    //--------------- stopPlaying ----------------//
    private void stopPlaying() {
        if (_Sound != null) {
            _Sound.stop();
            _Sound.release();
            _Sound = null;
        }
    }
    //----------------------------------------------------//


}
