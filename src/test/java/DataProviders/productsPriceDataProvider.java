package DataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.productPriceData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class productsPriceDataProvider {
    @DataProvider(name = "getProductsPriceFromJson")
    public Object[] getProductsPriceFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/DataFiles/productPriceData.json"));
        JsonElement productsPriceDataSet = jsonData.getAsJsonObject().get("dataset");

        List<productPriceData> productPriceData = new Gson().fromJson(productsPriceDataSet, new TypeToken<List<productPriceData>>(){}.getType());

        Object[][] returnValue = new Object[productPriceData.size()][1];

        int index = 0;

        for (Object[] each: returnValue) {
            each[0] = productPriceData.get(index++);
        }

        return returnValue;
    }
}