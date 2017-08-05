package j4sm1n.wahlung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capture our button from layout
        Button button1 = (Button) findViewById(R.id.button1);

        // Register the onClick listener with the implementation above
        button1.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                //do something when button1 is clicked
                Intent intent = new Intent(MainActivity.this, ListageAlternativesActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}