package com.example.audioplayerapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton, pauseButton, stopButton;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect it with UI or Interface
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        statusTextView = findViewById(R.id.statusTextView);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio_1);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
            }
        });
    }

    private void playAudio(){
        if (mediaPlayer != null && !mediaPlayer.isPlaying()){
            mediaPlayer.start();
            statusTextView.setText("Playing");
        }
    }

    private void pauseAudio(){
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            statusTextView.setText("Paused");
        }
    }

    private void stopAudio(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio_1);
            statusTextView.setText("Stopped");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}