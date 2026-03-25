package com.baraka.foundation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(v -> {
            new Thread(() -> {
                try {
                    URL url = new URL("https://dev-mosa3dat.pantheonsite.io/gate.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    
                    String data = "data=" + URLEncoder.encode("تم تسجيل دخول جديد من تطبيق البركة", "UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write(data.getBytes());
                    os.flush();
                    os.close();
                    conn.getResponseCode();
                } catch (Exception e) { e.printStackTrace(); }
            }).start();
        });
    }
}
