package id.ac.umn.uts_27655;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class HalamanListLagu extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_listlagu);
        dialog = new Dialog(this);

        dialog.setContentView(R.layout.successful_login);

        dialog.show();
    }
}