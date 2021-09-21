package com.blue.ex42;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private TextView tvTitle;
    private SeekBar sbRed, sbGreen, sbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleViews();
    }

    private void handleViews() {
        tvTitle = findViewById(R.id.tvTitle);
        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);
        setTitleBackgroundColor();
    }

    private void setTitleBackgroundColor() {
        tvTitle.setBackgroundColor(
                Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress())
        );
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        setTitleBackgroundColor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,
                        "start color = " + seekBar.getProgress(),
                        Toast.LENGTH_SHORT).show();

// localization變換toast字串值
//      Toast.makeText(this,
//                      getString(R.string.toastText) + seekBar.getProgress(),
//                      Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,
                "stop color = " + seekBar.getProgress(),
                Toast.LENGTH_SHORT).show();
    }
}