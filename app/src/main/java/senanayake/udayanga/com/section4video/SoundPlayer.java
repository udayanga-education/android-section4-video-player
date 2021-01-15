package senanayake.udayanga.com.section4video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class SoundPlayer extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_player);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
    }

    public void playAction(View view) {
        mediaPlayer.start();
    }

    public void pauseAction(View view) {
        mediaPlayer.pause();
    }

    public void stopAction(View view) {
        mediaPlayer.stop();
    }
}