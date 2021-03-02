package com.example.numbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    private EditText numberOne;
    private EditText numberTwo;
    private Button generateNumbers;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
        generateNumbers = findViewById(R.id.generateNumbers);
        result = findViewById(R.id.result);

        generateNumbers.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
                try{
                    if(numberOne.getText().toString().equals("") | numberTwo.getText().toString()){
                        String messageText = "Please enter number!";
                        generateMessage(messageText);
                    }else{
                        int numOne= Integer.parseInt(numberOne.getText().toString());
                        int numTwo= Integer.parseInt(numberTwo.getText().toString());

                        String luckyNumbers = generateNum(numOne, numTwo);
                        result.setText(LuckyNumbers);
                    }
                }catch (NumberFormatException ignored){

                }
           }

            private String generateNum(int numOne, int numTwo) {
               ArrayList<Integer> numberList = new ArrayList<>();
               for(int i = 1; i <= numTwo; i++){
                    numberList.add(i);
               }
               Collections.shuffle(numberList);
               ArrayList<Integer> selectedNumbers = new ArrayList<>();
               for(int i = 0; i <numOne; i++) selectedNumbers.add(numberList.get(i));
               Collections.sort(selectedNumbers);
               StringBuilder stringBuilder = new StringBuilder();
               for (int element : selectedNumbers){
                   stringBuilder.append(String.valueOf(element));
                   stringBuilder.append(", ");
               }
               return stringBuilder.toString().replaceAll(", $", "");
            }
        });
    }

    private void generateMessage(String messageText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, messageText, duration);
        toast.show();
    }
}