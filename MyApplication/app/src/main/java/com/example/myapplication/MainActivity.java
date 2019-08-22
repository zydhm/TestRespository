package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button button;
    BadView badView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double d=999.90;
        Log.d(TAG, "onCreate: "+new BigDecimal(999.90).setScale(1, BigDecimal.ROUND_DOWN)
        +"    "+new DecimalFormat("000.0").format(d-0.05) + "");

        button=findViewById(R.id.clear_btn);
        badView=findViewById(R.id.paint_dv);

        Integer intRef=new Integer(10);
        final SoftReference<Integer> intWRef=new SoftReference<Integer>(intRef);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                badView.clear();
                if(intWRef.get()==null){
                    Log.d(TAG, "onClick: null");
                }else{
                    Log.d(TAG, "onClick: not null");
                }
            }
        });
        
    }


    public static String formatKCBVol(long vol) {
        double dVol = vol;
        if (true) {
            dVol = vol / 100.0;
            if (vol > 0 && vol < 10000) {
                return new DecimalFormat("#0.00").format(dVol) + "";
            } else if (vol >= 10000 && vol < 100000) {
                return new BigDecimal(dVol).setScale(1,BigDecimal.ROUND_DOWN)+"";
            }
        }
        return vol+"";
    }

    public static double parse(long vol) {
        return (double) 100 / 100 / 2;
    }

    public static String formatVol(long vol) {
        String totalhand;
        totalhand = String.valueOf(vol);
        if (vol <= 0)
            return "--";
        else if (totalhand.length() > 6)
            if (vol % 10000 >= 5000) {
                return (vol / 10000 + 1) + "万";
            } else {
                return (vol / 10000) + "万";
            }
        else if (totalhand.length() == 6) {
            DecimalFormat df = new DecimalFormat("#0.0");
            return df.format(vol / 10000.0) + "万";
        } else {
            return totalhand;
        }
    }

    public static String test(Boolean istrue) {
        if (istrue != null)
            if (istrue) {
                return "a";
            } else if (!istrue) {
                return "b";
            }
        return "c";
    }

    public static String formatVolumnNew(long vol, boolean isKCB, int formatType) {
        double dVol = vol;
        if (isKCB) {
//            return "科创板";
            dVol = vol / 100.0;
            if (vol > 0 && vol < 10000) {
                return new DecimalFormat("#0.00").format(dVol) + "";
            } else if (vol >= 10000 && vol < 100000) {
                return new BigDecimal(""+dVol).setScale(1,BigDecimal.ROUND_DOWN)+"";
            }
        }
        // 手 不足一手部分直接舍去
        vol = (long) dVol;
        switch (formatType) {
//            case FORMAT_LEFT_VOLUMN:
//                return formatLeftVolumn(vol);
//            case FORMAT_VOLUMN1:
//                return formatVolumn1(vol);
//            case FORMAT_MONEYOUTER2:
//                return formatMoneyOuter2(vol);
//            case FORMAT_STR_VOLUMN:
//                return "" + vol;
//            case FORMAT_MONEYOUTER:
//                return formatMoneyOuter(vol);
//            case FORMAT_VOLUMN2:
//            case FORMAT_VOLUMN:
//                return formatVolumn2(vol);
//            case FORMAT_VOL:
//                return formatVol(vol);
//            case FORMAT_VOLUMN:
//                return formatVolumn(vol);
        }

        return "" + vol;
    }

    

}
