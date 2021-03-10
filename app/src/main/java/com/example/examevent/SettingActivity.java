package com.example.examevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    private LinearLayout layoutEntire;
    private EditText idETXT;
    private RadioGroup radioGroup;
    int check_Modify;
    private Button btn_save;
    private Button btn_cancel;
    private CheckBox checkbox_save;
    private CheckBox checkbox_wifi;

    private String editTextValue = "";
    private String radiobuttonValue;
    private String checkboxValue;
    private String TAG = "SettingActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        init();
    }

    public void init() {
        check_Modify = 0; // 0 : 클릭 X, 1 : 클릭
        layoutEntire = findViewById(R.id.layout_entire);
        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_cancel);
        idETXT = findViewById(R.id.idETXT);
        checkbox_save = findViewById(R.id.checkbox_save);
        checkbox_wifi = findViewById(R.id.checkbox_wifi);

        idETXT.setText(editTextValue);

        radiobuttonValue = "";
        checkboxValue = "";

        radioGroup = findViewById(R.id.radio_thema);
        set_RadioGroupListenter();

        checkbox_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxValue = ((CheckBox)v).getText().toString();
                Log.i(TAG, checkboxValue);
            }
        });
    }

    public void set_RadioGroupListenter() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadio = findViewById(checkedId);
                radiobuttonValue = selectedRadio.getText().toString();
            }
        });
    }

    public void click_ModifiyBtn(View v) {
        if(check_Modify == 0) {
            idETXT.setEnabled(true);
            check_Modify = 1;
        } else {
            idETXT.setEnabled(false);
            check_Modify = 0;
        }
    }

    public void clickSaveBtn(View v) {
        if(editTextValue != "" && radiobuttonValue != "" && checkboxValue != "") {
            editTextValue = idETXT.getText().toString();
            idETXT.setEnabled(true);
            check_Modify = 1;

            switch(radiobuttonValue) {
                case "White":
                    layoutEntire.setBackgroundColor(Color.WHITE);
                    break;
                case "Dark":
                    layoutEntire.setBackgroundColor(Color.BLACK);
                    break;
                case "Blue":
                    layoutEntire.setBackgroundColor(Color.BLUE);
                    break;
                default:
                    return;
            }
            Toast.makeText(this, checkboxValue, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "'모든 값이 선택되지 않았습니다", Toast.LENGTH_LONG).show();
        }
    }

    public void checkboxSaveClick(View v) {
        if(((CheckBox)v).isChecked())
            checkboxValue = checkbox_save.getText().toString();
        else
            checkboxValue = "";
    }

    public void checkboxWifiClick(View v) {
        if(((CheckBox)v).isChecked())
            checkboxValue = checkbox_wifi.getText().toString();
        else
            checkboxValue = "";
    }

    public void clickCancelBtn(View v) {

    }


}