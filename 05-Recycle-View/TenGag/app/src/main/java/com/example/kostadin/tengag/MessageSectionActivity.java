package com.example.kostadin.tengag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

public class MessageSectionActivity extends AppCompatActivity{
    @BindView(R.id.txt_message) TextView txt_message;
    @BindView(R.id.btn_send) Button btn_send;
    @BindView(R.id.btn_goBack) ImageButton goBack;
    @BindView(R.id.enter_message) EditText enter_message;
    private int CommentsSend = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_section);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_goBack)
    public void onBackClicked(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_send)
    public void onSendClick(){
        String message = this.enter_message.getText().toString();
        String currentlyText = this.txt_message.getText().toString();
        if(currentlyText != ""){
            this.txt_message.setText(currentlyText + "\n" + message);
        }
    }
}
