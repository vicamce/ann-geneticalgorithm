package process;

/**
 * Created by Amadeus on 05/08/14.
 */
public interface Function {

    int calculateCut(int valueMax);
    double calculateProbabilitySelect();
    int[][] calculateFitness(int value, int valueRange);
    double calculateK(int value, int [][] date);
}
