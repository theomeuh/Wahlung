package j4sm1n.wahlung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        listeChoix = new ArrayList<String>();
        ArrayList<String> listeChoix = getIntent().getStringArrayListExtra("liste");

        combatPossible = Traitement.combatPossible(listeChoix);
        nb_duel = combatPossible.length ;

        duel_gagne = new int[nb_duel*2];

        buttonGauche = (Button) findViewById(R.id.buttonGauche);
        buttonGauche.setOnClickListener(this);
        buttonDroite = (Button) findViewById(R.id.buttonDroite);
        buttonDroite.setOnClickListener(this);
        clearbutton = (Button) findViewById(R.id.clearbutton);
        clearbutton.setOnClickListener(this);
        resultbutton = (Button) findViewById(R.id.resultbutton);
        resultbutton.setOnClickListener(this);

        buttonGauche.setText(combatPossible[compteur_duel][0]);
        buttonDroite.setText(combatPossible[compteur_duel][1]);
    }
    public void onClick (View v){
        compteur_duel+=1;
        if (compteur_duel<nb_duel){
            switch(v.getId()){
                case R.id.buttonGauche:
                    duel_gagne[compteur_duel]+=1;
                    buttonGauche.setText(combatPossible[compteur_duel][0]);
                    buttonDroite.setText(combatPossible[compteur_duel][1]);
                break;
                case R.id.buttonDroite:
                    duel_gagne[nb_duel + compteur_duel]+=1;
                    buttonGauche.setText(combatPossible[compteur_duel][0]);
                    buttonDroite.setText(combatPossible[compteur_duel][1]);
                break;
            }
        }
        else{
            switch (v.getId()){
                case R.id.clearbutton:
                    compteur_duel=0;
                    buttonGauche.setText(combatPossible[compteur_duel][0]);
                    buttonDroite.setText(combatPossible[compteur_duel][1]);
                break;
                default:
                    buttonGauche.setText("Vote");
                    buttonDroite.setText("fini");
            }
        }
    }
}
