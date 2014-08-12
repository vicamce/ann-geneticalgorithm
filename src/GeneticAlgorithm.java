import java.util.Random;

/**
 * Created by Amadeus on 25/07/14.
 */
public class GeneticAlgorithm {

    private int [][] population;
    private int [][] newPopulation;
    private double[][] bestChromosomes;

    private int[][] A;
    private int[] k;
    private int[] S;
    private double[][] QFit;
    private int[]bestChromosome;
    private double[] fitnessArray;
    private int[] childOne;
    private int[] childTwo;

    private double twoL;
    private double sumFitness;
    private double sumProbability;
    private int indexP1;
    private int indexP2;
    private int numChromosomes;

    private int numIndividuals;
    private int numGenerations;
    private double factorMutation;
    private int typeReproduction;
    Data dates;
    TypeReproduction tReproduction;



    public GeneticAlgorithm(double[] parameters)
    {
        numIndividuals = (int)parameters[0];
        numGenerations = (int)parameters[1];
        factorMutation = parameters[2];
        typeReproduction = (int)parameters[3];
        tReproduction =  new TypeReproduction();

    }
    
    private void GeneticAlgorithm()
    {
        generatePopulation();
        
        for(int indexGeneration = 0; indexGeneration < numGenerations; indexGeneration++)
        {
            calculateModularity();
            
            for(int indexPopulation = 0; indexPopulation < population.length; indexPopulation ++)
            {
                //Selection Individuals
                indexP1 = rouletteWheelSelect();
                indexP2 = rouletteWheelSelect();
                
                //Reproduction Individuals
                switch (typeReproduction)
                {
                    case 1://crossoverOnePoint
                        tReproduction.crossoverOnePoint();
                        break;
                    case 2://crossoverTwoPoint
                        tReproduction.crossoverTwoPoint();
                        break;
                    case 3://crossoverUniform
                        tReproduction.crossoverUniform();
                }
                
                //Mutation
                mutation();
                
                //save new population
                addNewPopulation();
            }
            //get the best chromosome of the generation
            getBestChromosome();
            population = newPopulation;
        }
        dates.writeDataPrediction(k);
    }

    private int rouletteWheelSelect()
    {
        return 0;
    }


    private void mutation()
    {
        for (int m =0;m<child2.length;m++)
        {
            Random r = new Random();
            double randomValue = r.nextDouble();
            if(randomValue < 0) randomValue *= -1;
            randomValue %= 1;

            if(randomValue <= pMutation)
            {
                if (child1[m] == 0) {
                    child1[m] = 1;
                }
                else {
                    child1[m] = 0;
                }
                if (child2[m] == 0) {
                    child2[m] = 1;
                }
                else {
                    child2[m] = 0;
                }
            }
        }
    }

    private void addNewPopulation()
    {

    }

    private void getBestChromosome() {
        int index = getBestParent();
        bestChromosoma = selectionCromosoma(index);
        for(int b=0;b< bestChromosoma.length;b++)
        {
            bestCromoGeneration[cont][b] = bestChromosoma[b];
        }
        bestCromoGeneration[cont][bestCromoGeneration[cont].length -2]= QFit[1][index];
        bestCromoGeneration[cont][bestCromoGeneration[cont].length -1]= QFit[0][index];
        cont = cont+1;
    }

    private void calculateModularity() {

        S = new int[numCromosomas];
        QFit= new double[2][population.length];
        double  sumafit1;
        double  sumafit2;
        double  delta;

        double sumafitness;
        for (int p = 0; p < population.length; p++)
        {
            S = selectionCromosoma(p);
            sumafit1 = 0.0;
            sumafit2 = 0.0;
            delta = 0.0;
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
    }

    private void generatePopulation() {
        population = new int[numIndividuos][numCromosomas];
        newpopulation = new int[numIndividuos][numCromosomas];

        bestCromoGeneration = new double[numGenerations][numCromosomas + 2];

        for (int i = 0; i < numIndividuos; i++) {
            for (int j = 0; j < numCromosomas; j++) {
                double aleatorio = Math.random();
                if (aleatorio < 0.5)
                    population[i][j] = 0;
                else
                    population[i][j] = 1; //Cambiar por uno
            }

        }
    }
}
