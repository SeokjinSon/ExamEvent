package com.example.examevent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Event2Activity extends AppCompatActivity {

    // Member Variable --------------------------------------

    private final boolean       D           = true;
    private final String        TAG         = "ExamEvent";

    private Button              okBTN;
    private EditText            nameETXT;
    private long                initTime;

    private InputMethodManager  imm;

    // Member Method - Activity's override -------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정
        setContentView(R.layout.event2_main);

        // 초기화
        init();
        if(D) Log.i(TAG, "OnCreate()");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "TOUCH DOWN : " + keyCode);

        switch(keyCode) {
            case KeyEvent.KEYCODE_BACK:
                key_backFunction(keyCode);


                break;
            case KeyEvent.KEYCODE_HOME:
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "TOUCH DOWN ( " + event.getX() + ", " + event.getY() + ")");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "TOUCH MOVE ( " + event.getX() + ", " + event.getY() + ")");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "TOUCH UP ( " + event.getX() + ", " + event.getY() + ")");
                break;
        }
        return super.onTouchEvent(event);
    }

    // Member Method - Custom ---------------------------------
    // 초기화 메서드
    private void init() {
        // System 서비스 객체 가져오기
        imm         = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        // View 객체 가
        okBTN       = findViewById(R.id.okBTN);
        nameETXT    = findViewById(R.id.nameETXT);

        // View 이벤트 리스너 설정
        nameETXT.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d(TAG, "onEditorAction() actionId" + actionId);
                if(actionId == EditorInfo.IME_ACTION_DONE) { // DONE키가 완료 버튼
                    imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0);
                }
                return false;
            }
        });
    }

    // Member Method - XML onClick Method ---------------------------------
    public void click(View v) {
        // Softkeyboard 숨기기 설정
        imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0); // token ; 각 창에 대한 고유 번호?
    }

    public void key_backFunction(int keyCode) {
        if(System.currentTimeMillis() - initTime > 3000) {
            showToast("종료하려면 한 번 더 누르세요");
            initTime = System.currentTimeMillis();
        } else {
            finish();
        }

    }

    private void showToast(String msg) {
        Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}