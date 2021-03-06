package j4sm1n.wahlung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class voteDCActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> listeChoix;
    private Button buttonGauche = null;
    private Button buttonDroite = null;
    private Button clearbutton = null;
    private Button resultbutton = null;
    private String[][] combatPossible = null;
    private int nb_duel;
    private int compteur_duel;
    private int[] duel_gagne = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_dc);

        listeChoix = getIntent().getStringArrayListExtra("liste");

        combatPossible = Traitement.combatPossible(listeChoix);
        nb_duel = combatPossible.length ;

        duel_gagne = new int[nb_duel];

        buttonGauche = (Button) findViewById(R.id.buttonGauche);
        buttonGauche.setOnClickListener(this);
        buttonDroite = (Button) findViewById(R.id.buttonDroite);
        buttonDroite.setOnClickListener(this);
        clearbutton = (Button) findViewById(R.id.clearbutton);
        clearbutton.setOnClickListener(this);
        resultbutton = (Button) findViewById(R.id.resultbutton);
        resultbutton.setOnClickListener(this);

        this.Initialize();
    }
    public void onClick (View v){
        compteur_duel+=1;
        if (compteur_duel<nb_duel){
            switch(v.getId()){
                case R.id.buttonGauche:
                    duel_gagne[compteur_duel]+=1;
                break;
                case R.id.buttonDroite:
                    duel_gagne[compteur_duel]-=1;
                break;
            }
            buttonGauche.setText(combatPossible[compteur_duel][0]);
            buttonDroite.setText(combatPossible[compteur_duel][1]);
        }
        else{
            switch (v.getId()){
                case R.id.clearbutton:
                    this.Initialize();
                break;
                case R.id.resultbutton:
                    int nb_winner = Traitement.findingWinner(duel_gagne);
                    Intent intent = new Intent(voteDCActivity.this, AffichageResult.class);
                    intent.putExtra("winner", listeChoix.get(nb_winner));
                    startActivity(intent);
                break;
                default:
                    buttonGauche.setText("Vote");
                    buttonDroite.setText("fini");
            }
        }
    }
    private void Initialize(){
        compteur_duel = 0;
        buttonGauche.setText(combatPossible[0][0]);
        buttonDroite.setText(combatPossible[0][1]);
    }
}
