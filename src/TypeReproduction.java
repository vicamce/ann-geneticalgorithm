
import process.Reproduction;
/**
 * Created by Amadeus on 05/08/14.
 */
public class TypeReproduction implements Reproduction {

    int[][] children;
    FunctionCalculates cut;
    int valueCut;

    public TypeReproduction()
    {
        cut = new FunctionCalculates();
    }


    @Override
    public void crossoverOnePoint(int valueCut, int[][]valueParents) {

       this.valueCut = cut.calculateCut(valueCut);
       children = valueParents.clone();
       for(int i = 0; i < valueCut; i++)
       {
           if(i < valueCut)
           {
               children[i][0] = valueParents[i][0];
               children[i][1] = valueParents[i][1];
           }
           else
           {
               children[i][0] = valueParents[i][0];
               children[i][1] = valueParents[i][1];
           }
       }

    }

    @Override
    public void crossoverTwoPoint(int valueCut, int[][] valueParents) {

        this.valueCut = cut.calculateCut(valueCut);
        int valueCut1 = cut.calculateCut(valueCut);
        children = valueParents.clone();
        for(int i = 0; i < valueCut; i++)
        {

            if(i < valueCut)
            {
                children[i][0] = valueParents[i][0];
                children[i][1] = valueParents[i][1];
            }
            else
            {
                if(i > valueCut && i > valueCut1)
                {
                    children[i][0] = valueParents[i][0];
                    children[i][1] = valueParents[i][1];
                }
                else
                {
                    children[i][0] = valueParents[i][0];
                    children[i][1] = valueParents[i][1];
                }


            }
        }
    }

    @Override
    public void crossoverUniform(int valueCut, int[][] valueParents) {

        int[] mask = new int[valueCut];
        for(int j = 0; j < valueCut; j++)
        {
            double random = Math.random();
            if(random < 0.5)
            {
                mask[j] = 0;
            }
            else
            {
                mask[j] = 1;
            }
        }
        this.valueCut = cut.calculateCut(valueCut);
        int valueCut1 = cut.calculateCut(valueCut);
        children = valueParents.clone();
        for(int i = 0; i < valueCut; i++)
        {

            if(mask[i] == 1)
            {
                children[i][0] = valueParents[i][0];
                children[i][1] = valueParents[i][1];
            }
            else
            {
                    children[i][0] = valueParents[i][0];
                    children[i][1] = valueParents[i][1];
            }
        }
    }


}
