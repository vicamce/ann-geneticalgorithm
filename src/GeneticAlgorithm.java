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


    public GeneticAlgorithm(double[] parameters)
    {
        numIndividuals = (int)parameters[0];
        numGenerations = (int)parameters[1];
        factorMutation = parameters[2];
        typeReproduction = (int)parameters[3];

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
                        crossoverOnePoint();
                        break;
                    case 2://crossoverTwoPoint
                        crossoverTwoPoints();
                        break;
                    case 3://crossoverUniform
                        crossoverUniform();
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

    private void crossoverOnePoint()
    {

    }

    private void crossoverTwoPoints()
    {

    }

    private void crossoverUniform()
    {

    }

    private void mutation()
    {

    }

    private void addNewPopulation()
    {

    }

    private void getBestChromosome() {

    }

    private void calculateModularity() {
        
    }

    private void generatePopulation() {
        
    }
}
