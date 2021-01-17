package senanayake.udayanga.com.section4video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class SoundPlayer extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    SeekBar volumeController, scrubber;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_player);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound);


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeController = (SeekBar) findViewById(R.id.seekBar);
        volumeController.setMax(maxVolume);
        volumeController.setProgress(currentVolume);

        volumeController.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        scrubber = (SeekBar) findViewById(R.id.scrubber);
        scrubber.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 100);

        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Log.i("Scrubber ", Integer.toString(progress));

                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


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