
import process.Function;
import java.util.Random;

/**
 * Created by Amadeus on 05/08/14.
 */
public class FunctionCalculates implements Function {


    public FunctionCalculates()
    {

    }

    @Override
    public int calculateCut(int valueMax) {

        int rangeMin = 0, rangeMax =valueMax - 1;
        Random valueRandom = new Random();
        int valueCut = rangeMin + (rangeMax - rangeMin) * valueRandom.nextInt();
        if(valueCut < 0 )
            valueCut *= -1;
        valueCut %= rangeMax -1;
        return valueCut;

    }

    @Override
    public double calculateProbabilitySelect() {

        return 0;
    }

    @Override
    public double calculateK(int value, int [][] date) {
        double twoL = 0.0;
        int [] k = new int[value];
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                k[i] = k[i] + date[i][j];
            }
            twoL += k[i];
        }
        return twoL;
    }

    @Override
    public int[][] calculateFitness(int value, int valueRange) {

        int [] S = new int[value];
        double [][] QFit= new double[2][valueRange];
        double  sumafit1;
        double  sumafit2;
        double  delta;

        for (int p = 0; p < valueRange; p++)
        {
            S = selectionCromosoma(p);
            sumafit1 = 0.0;
            sumafit2 = 0.0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++)
                {
                    //sumafit1 += (A[i][j] - ((k[i]*k[j])/twoL)) * (S[i]*S[j] + ((1-S[i]) * (1-S[j])));
                    delta = (S[i]*S[j]) + ((1-S[i]) * (1-S[j]));
                    sumafit1 += (A[i][j]*delta) ;
                    sumafit2 += (((k[i]*k[j])/twoL)*delta) ;

                }

            }
            QFit[0][p]=(1/twoL) * sumafit1 - (1/twoL) * sumafit2; //Q
            QFit[1][p]=(1 + QFit[0][p]);     //Fit
            sumFitness += QFit[1][p];

        }
        return new int[0][];
    }
}
