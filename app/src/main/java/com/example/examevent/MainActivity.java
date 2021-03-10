package com.example.examevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member Variable --------------------------------------

    private final boolean       D           = true;
    private final String        TAG         = "ExamEvent";
    private Button              leftBTN;
    private TextView            msgTXT;
    private CheckBox            checkBox;
    private RadioGroup          radioGroup;
    private RadioButton         redRBTN, blueRBTN;
    private LinearLayout        layout;

    // Member Method - Activity's override -------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정
        setContentView(R.layout.activity_main);

        // 초기화
        init();
        if(D)
            Log.i(TAG, "OnCreate()");
    }

    // Member Method - Custom ---------------------------------
    // 초기화 메서드
    private void init() {
        // View 객체 가져오기
        leftBTN     = findViewById(R.id.leftBTN);
        msgTXT      = findViewById(R.id.msgTXT);
        checkBox    = findViewById(R.id.checkBox);
        redRBTN     = findViewById(R.id.redRBTN);
        blueRBTN    = findViewById(R.id.blueRBTN);
        radioGroup  = findViewById(R.id.radioGroup);
        layout      = findViewById(R.id.mainActivity);

        // View 이벤트 리스너(클릭 리스터는 인터페이스이기 때문에 미구현 되어있음)
        leftBTN.setOnClickListener(new View.OnClickListener() {
            @Override // 클릭
            public void onClick(View v) {
                Log.i(TAG, "leftBTN - onClick()");
            }
        });

        msgTXT.setOnClickListener(new View.OnClickListener() {
            @Override // 클릭
            public void onClick(View v) {
                Log.i(TAG, "msgBTN - onClick()");
            }
        });

        // 일반 한 번 누르는 것이 아닌 길게 클릭하면 동작하도록(길게 누르고 있으면 곧 실행)
        leftBTN.setOnLongClickListener(new View.OnLongClickListener() {
            @Override // 클릭
            public boolean onLongClick(View v) {
                Log.i(TAG, "leftBTN - Long onClick()");
                return true; // 길게 클릭하게 끝냄(false면 LongClick 후 또 클릭한 것으로 인식)
            }
        });

        // CheckBox의 check 여부에 따른 동작
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "checkbox - CheckedChange");
                layout.setBackgroundColor((isChecked) ? Color.CYAN : Color.WHITE);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { // 여러 개 중 체크된 것의 아이디
                Log.i(TAG, "radioGroup - checkedId : " +
                        ((RadioButton)findViewById(checkedId)).getText());
            }
        });

        redRBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "radioButton - checkedId : " + buttonView.getText());
            }
        });

    }

}