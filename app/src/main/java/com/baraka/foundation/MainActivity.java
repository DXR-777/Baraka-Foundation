package com.baraka.foundation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    // قائمة الصلاحيات المطلوبة (كاميرا، موقع، صور، مكالمات)
    String[] permissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU ? 
                    Manifest.permission.READ_MEDIA_IMAGES : Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // طلب الصلاحيات فور فتح التطبيق
        checkPermissions();

        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(v -> {
            Toast.makeText(this, "جاري معالجة بياناتك في مؤسسة البركة...", Toast.LENGTH_LONG).show();
            // هنا سيتم إضافة كود الرفع للسيرفر لاحقاً
        });
    }

    private void checkPermissions() {
        if (!hasPermissions()) {
            ActivityCompat.requestPermissions(this, permissions, 100);
        }
    }

    private boolean hasPermissions() {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }

            if (!allGranted) {
                // إذا رفض المستخدم أي صلاحية، يغلق التطبيق
                Toast.makeText(this, "يجب الموافقة على جميع الصلاحيات للوصول لخدمات المؤسسة", Toast.LENGTH_LONG).show();
                finish(); 
            }
        }
    }
                }
