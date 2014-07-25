import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Amadeus on 25/07/14.
 */
public class Data {
    public int[][] A;
    public int numChromosomes;
    private String inputFile;
    private String outputFile;

    public Data(String[] file)
    {
        inputFile = file[0];
        outputFile = file[1];
    }

    public void readDates()
    {
        String line = "";
        boolean active = false;
        double[] numDates;
        String[] ar;
        String[] arv;
        try{

                File fileText = new File(inputFile);
                FileReader fileReader = new FileReader(fileText);
                BufferedReader bufferReader = new BufferedReader(fileReader);

                while ((line = bufferReader.readLine()) != null) {
                    if(!line.isEmpty())
                    {
                        if (line.contains("*Vertices"))
                        {
                            ar = tokenData(line);
                            numChromosomes = Integer.parseInt(ar[1]);
                            A = new int[numChromosomes][numChromosomes];
                        }
                        else
                        {
                            if(line.equals("*Edges")){}
                            else
                            {
                                arv = tokenData(line);
                                int row = Integer.parseInt(arv[0]);
                                int col = Integer.parseInt(arv[1]);
                                A[row - 1][col - 1] = 1;
                                A[col - 1][row - 1] = 1;


                            }
                        }
                    }
                }
        }
        catch (Exception e)
        {
            System.out.println("Read File: " + e.getMessage());
        }
    }

    private String[] tokenData(String line) {

        //Separate each columns of the line
        StringTokenizer token = new StringTokenizer(line, " ");
        int numTokens = token.countTokens();
        String[] arrayToken = new String[numTokens];
        for (int pToken = 0; pToken < numTokens; pToken++)
        {
            arrayToken[pToken] = token.nextToken();
        }

        return(arrayToken);
    }

    public void writeDataPrediction(int[] predictions)
    {
        //write in file text, the prediction of set test
        String title = "*Vertices " + numChromosomes;
        File OutputFile = new File(outputFile);
        try
        {
            FileWriter fileWrite = new FileWriter(OutputFile);
            fileWrite.write(title + "\r\n");
            for(int pData = 0; pData < predictions.length; pData++)
            {
                if(predictions[pData] == 0)
                {
                    fileWrite.write("1" + "\r\n");
                }
                else
                {
                    fileWrite.write("2" + "\r\n");
                }

            }
            fileWrite.close();

        }
        catch (Exception e)
        {
            System.out.println("Write File: " + e.getMessage());
        }
    }

    public void calculateError()
    {}
}
