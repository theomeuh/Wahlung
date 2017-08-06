package j4sm1n.wahlung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AffichageResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_result);

        Intent intent = getIntent();

        String winner = intent.getStringExtra("winner");
        TextView resultText = (TextView) findViewById(R.id.resultText);
        resultText.setText(winner);
    }
}
