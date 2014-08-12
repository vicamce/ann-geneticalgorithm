package process;

/**
 * Created by Amadeus on 05/08/14.
 */
public interface Reproduction {

    void crossoverOnePoint(int valueCut, int[][]valueParents);

    void crossoverTwoPoint(int valueCut, int[][]valueParents);

    void crossoverUniform(int valueCut, int[][]valueParents);

}
