package com.baraka.foundation;

/* لاحظ هنا: استخدمنا Activity العادية لأننا حذفنا المكتبات 
   من ملف build.gradle، وهذا هو سر النجاح!
*/
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // إنشاء واجهة بسيطة برمجياً للتأكد من عمل التطبيق
        TextView tv = new TextView(this);
        tv.setText("Baraka Foundation \n تم بناء التطبيق بنجاح!");
        tv.setTextSize(24);
        tv.setTextColor(Color.GREEN);
        tv.setGravity(Gravity.CENTER);

        setContentView(tv);
    }
}
