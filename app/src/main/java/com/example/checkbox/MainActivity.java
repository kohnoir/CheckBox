package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViews();
        resetCheckBoxes();
        Button();
    }
    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }
    private void init(){
        mInputInfo = findViewById(R.id.input_info);
        mInputMoney = findViewById(R.id.input_money);
        mBtnOk = findViewById(R.id.btn_ok);
        mBankCardChkBx = findViewById(R.id.bank_card_chk_bx);
        mMobilePhoneChkBx = findViewById(R.id.mobile_phone_chk_bx);
        mCashAddressChkBx = findViewById(R.id.cash_address_chk_bx);
    }
    private void initViews() {
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    switch (compoundButton.getId()) {
                        case R.id.bank_card_chk_bx:
                            resetCheckBoxes();
                            mBankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        case R.id.mobile_phone_chk_bx:
                            resetCheckBoxes();
                            mMobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.cash_address_chk_bx:
                            resetCheckBoxes();
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            mCashAddressChkBx.setChecked(true);
                            break;
                        default:
                    }
                }
            }
        };
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }
    private void Button(){
        mBtnOk= findViewById(R.id.btn_ok);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.all_ok, Toast.LENGTH_LONG).show();
            }
        });
    }
}
