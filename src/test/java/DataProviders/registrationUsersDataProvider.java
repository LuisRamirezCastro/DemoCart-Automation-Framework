package DataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.registrationUserData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class registrationUsersDataProvider {

    @DataProvider(name = "getRegistrationUsersDataFromJson")
    public Object[] getRegistrationUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/DataFiles/registrationUserData.json"));
        JsonElement registrationUsersDataSet = jsonData.getAsJsonObject().get("dataset");

        List<registrationUserData> registrationUsersData = new Gson().fromJson(registrationUsersDataSet, new TypeToken<List<registrationUserData>>(){}.getType());

        Object[][] returnValue = new Object[registrationUsersData.size()][1];

        int index = 0;

        for (Object[] each: returnValue) {
            each[0] = registrationUsersData.get(index++);
        }

        return returnValue;
    }
}
