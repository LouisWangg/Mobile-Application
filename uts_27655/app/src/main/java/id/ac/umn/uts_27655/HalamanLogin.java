package id.ac.umn.uts_27655;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HalamanLogin extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginIn;
    private TextView close;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_login);
        dialog = new Dialog(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginIn = findViewById(R.id.loginInButton);

        loginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String username, String password) {
        if(username.equals("uasmobile") && password.equals("uasmobilegenap")) {
            Intent loginInIntent = new Intent(HalamanLogin.this,
                                               HalamanListLagu.class);
            startActivityForResult(loginInIntent, 1);
        } else {
            dialog.setContentView(R.layout.failed_login);
            dialog.show();
        }
    }
}
