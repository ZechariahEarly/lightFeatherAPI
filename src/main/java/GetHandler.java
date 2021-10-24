import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class GetHandler {

    List<Manager> managers = new ArrayList<Manager>();

    public List<String> organizedManagers() throws Exception{
        this.managers = getManagers();
        managers.sort(Comparator.comparing(Manager::getJurisdiction)
                .thenComparing(Manager::getLastName));
        List<String> managerList = new ArrayList<String>();
        for (Manager manager : managers){
            if(isNumeric(manager.getJurisdiction()) == false) {
                managerList.add(manager.getJurisdiction() + " - " + manager.getLastName() +" "+ manager.getFirstName());
            }
        }


        return managerList;
    }

    public List<Manager> getManagers() throws Exception {
        Gson gson = new Gson();
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        Type listType = new TypeToken<List<Manager>>() {}.getType();
        return gson.fromJson(result.toString(), listType);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


}
