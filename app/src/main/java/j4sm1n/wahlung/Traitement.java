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

    public static int[][] reconstitutionMatrice (int[] duel_gagne){
        int n = duel_gagne.length;
        int rang = 1;
        while (rang*(rang+1)/2 != n){
            rang+=1;
        }
        int rangTriang = rang+1;
        int[][] matrice = new int[rangTriang][rangTriang];

        int compteur_duel = 0;
        for (int ligne = 0;ligne<rangTriang;ligne++){
            for (int colonne = 0;colonne<rangTriang;colonne++){
                if (ligne < colonne){
                    matrice[ligne][colonne]=duel_gagne[compteur_duel];
                    matrice[colonne][ligne]=-duel_gagne[compteur_duel];
                    compteur_duel+=1;
                }
            }
        }
        return(matrice);
    }
    public static int findingWinner(int[] duel_gagne){
        int[][] matrice = reconstitutionMatrice(duel_gagne);
        int winner = -1;
        for (int ligne = 0; ligne<matrice.length;ligne++){
            boolean allPositive = true;
            for (int colonne=0;colonne<matrice.length;colonne++){
                if (matrice[ligne][colonne]<0){
                    allPositive=false;
                }
            }
            if (allPositive){
                winner = ligne;
            }
        }
        return winner;
    }
}
