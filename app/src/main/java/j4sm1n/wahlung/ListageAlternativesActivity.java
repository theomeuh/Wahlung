package j4sm1n.wahlung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListageAlternativesActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTxtField;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listeChoix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listage_alternatives);

        editTxtField = (EditText) findViewById(R.id.editTxt);
        ListView listV = (ListView) findViewById(R.id.listV);
        listeChoix = new ArrayList<String>();
        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.liste_item, listeChoix);
        // Here, you set the data in your ListView
        listV.setAdapter(adapter);

        //set of buttons
        Button addBtn = (Button) findViewById(R.id.addBtn);
        Button continueBtn = (Button) findViewById(R.id.continueBtn);
        addBtn.setOnClickListener(this);
        continueBtn.setOnClickListener(this);
    }
    // actions of buttons
    public void onClick(View v){
        switch(v.getId()){
            case R.id.addBtn:
                // this line adds the data of your EditText and puts in your array
                listeChoix.add(editTxtField.getText().toString());
                // next thing you have to do is check if your adapter has changed
                adapter.notifyDataSetChanged();
                //clear the field after click
                editTxtField.setText("");

                break;
            case R.id.continueBtn:
                Intent intent = new Intent(ListageAlternativesActivity.this, voteDCActivity.class);
                intent.putStringArrayListExtra("liste", listeChoix);
                startActivity(intent);
            default:
                break;
        }
    }
}