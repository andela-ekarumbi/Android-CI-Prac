package com.andela.continuousintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showName;
    private EditText enterName;
    private Button nameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setButtonHandler();
    }

    private void setButtonHandler() {
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(enterName.getText())) {
                    showName.setText("Please enter your name.");
                } else {
                    showName.setText("Hello, " + enterName.getText().toString());
                }
            }
        });
    }

    private void initializeViews() {
        showName = (TextView) findViewById(R.id.nameDisplay);
        enterName = (EditText) findViewById(R.id.enterName);
        nameButton = (Button) findViewById(R.id.nameButton);
    }
}
