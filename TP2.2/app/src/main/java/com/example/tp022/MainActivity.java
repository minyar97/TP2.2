package com.example.tp022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private int mCount=0;
    private TextView mShowCount;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mShowCount.getText().toString());
        }
   
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.Count);
        editText = findViewById(R.id.editText);

        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                mShowCount.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                mShowCount.setText(savedInstanceState
                        .getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
                editText.setText(savedInstanceState
                        .getString("reply_text"));
                editText.setVisibility(View.VISIBLE);
            }
        }

    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}
