package ru.mirea.belov.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private final int REQUEST_CODE = 143;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView)findViewById(R.id.textViewAnswer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //Отличие от обычного startActivity заключается в том, что MainActivity становится «родителем» для DataActivity и когда DataActivity закрывается, вызывается метод onActivityResult
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            String university = data.getStringExtra("name");
            setUniversityTextView(university);
        }
    }
    public void startDataActivityOnClick(View view) {
        Intent intent = new Intent(this, DataActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
    private void setUniversityTextView(String university){
        textViewResult.setText(university);
    }
}
