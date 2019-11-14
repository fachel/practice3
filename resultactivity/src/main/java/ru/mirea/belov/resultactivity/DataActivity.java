package ru.mirea.belov.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {

    private EditText universityEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        universityEditText = (EditText)findViewById(R.id.editText);
    }

    public void sendResultOnMainActivityOnClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", universityEditText.getText().toString());
        setResult(RESULT_OK, intent); //Метод setResult адресовывает intent в «родительское Activity, в котором был вызван метод startActivityForResult. Также в setResult передаётся константа RESULT_OK, означающая успешное завершение вызова.
        finish(); //методом finish завершается работа DataActivity, чтобы результат ушел в MainActivity.
    }
}
