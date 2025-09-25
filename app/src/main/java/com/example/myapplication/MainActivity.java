package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etAuthor;
    CheckBox cbIsRead;
    Button btnAdd;
    LinearLayout containerBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        cbIsRead = findViewById(R.id.cbIsRead);
        btnAdd = findViewById(R.id.btnAdd);
        containerBooks = findViewById(R.id.containerBooks);

        btnAdd.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String author = etAuthor.getText().toString().trim();
            boolean isRead = cbIsRead.isChecked();

            // Validação
            if (title.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha o título", Toast.LENGTH_SHORT).show();
                return;
            }

            if (author.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha o autor", Toast.LENGTH_SHORT).show();
                return;
            }

            // Criar
            TextView tv = new TextView(this);
            tv.setText("Título: " + title +
                    "\nAutor: " + author +
                    "\nStatus: " + (isRead ? "Lido ✅" : "Não lido ❌"));
            tv.setPadding(16,16,16,16);
            tv.setBackgroundColor(0xFFEFEFEF);
            tv.setTextSize(16);

            containerBooks.addView(tv);

            // Limpar
            etTitle.setText("");
            etAuthor.setText("");
            cbIsRead.setChecked(false);
        });
    }
}