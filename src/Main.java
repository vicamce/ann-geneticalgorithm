/**
 * Created by Amadeus on 25/07/14.
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        String inputNet = "input/qns04_d.net";
        String outputNet = "output/qns04_d.net.clu";

        String[] file = new String[2];
        file[1] =inputNet;
        file[0] = outputNet;

        int numIndividuals =5000;
        int numGenerations = 500;
        double factorMutation = 0.03;
        int typeReproduction =1; // 1=crossoverOnePoint, 2=crossoverTwoPoint, 3=crossoverUniform


        double[] parameters = new double[4];
        parameters[0] = numIndividuals;
        parameters[1] = numGenerations;
        parameters[2] = factorMutation;
        parameters[3] = typeReproduction;
        Data dates = new Data(file);
        GeneticAlgorithm GA = new GeneticAlgorithm(parameters);


    }

}
