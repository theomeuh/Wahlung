package j4sm1n.wahlung;

import java.util.ArrayList;

/**
 * Created by Théo on 08/04/2017.
 * Classe correspondant au moteur de l'app. Les calculs "complexes" sont effectués ici
 */

public class Traitement {
    public static String[][] combatPossible(ArrayList<String> choix){
        int n = choix.size();
        String combatPossible[][] = new String[(int) binomial(n,2)][2];
        int i=0;
        for (int pointeur=0; pointeur<n; pointeur++){
            for (int coureur=pointeur+1; coureur<n; coureur++){
                combatPossible[i][0]=choix.get(pointeur);
                combatPossible[i][1]=choix.get(coureur);
                i++;
            }
        }
        return combatPossible;
    }

    private static long binomial(int n, int k)
    {
        if (k>n-k)
            k=n-k;

        long b=1;
        for (int i=1, m=n; i<=k; i++, m--)
            b=b*m/i;
        return b;
    }

    public static void reconstitutionMatrice{

    }
}
