package com.baraka.foundation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("مؤسسة البركة ترحب بكم - تم بناء التطبيق بنجاح!");
        setContentView(tv);
    }
}
