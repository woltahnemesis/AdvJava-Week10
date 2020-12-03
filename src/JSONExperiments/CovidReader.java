package JSONExperiments;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class CovidReader {
    public static void main(String[] args) {

        try(
                FileReader fileReader = new FileReader("./src/JSONExperiments/covid.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            Gson gson = new Gson();
            CovidHighLevel covidHighLevel = gson.fromJson(jsonReader, CovidHighLevel.class);
            System.out.println(covidHighLevel);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
