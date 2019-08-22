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



    public static String test(Boolean istrue) {
        if (istrue != null)
            if (istrue) {
                return "a";
            } else if (!istrue) {
                return "b";
            }
        return "c";
    }

    public void testGit(){
        Log.d(TAG, "testGit: ");
    }
    
    public void test2(){
        Log.d(TAG, "test2: git conflict temt");
    }
    

}
