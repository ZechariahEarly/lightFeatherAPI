import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostHandler {

    public class FieldsEnteredIncorrectly extends Exception{
        FieldsEnteredIncorrectly(String msg){
            super(msg);
        }
    }

    public void sendPOST(String newEmployee) throws IOException{

        Gson gson = new Gson();
        try {
            String[] attributes = newEmployee.split("\\s+");
            if (attributes.length == 5) {
                Employee employee = new Employee(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);
                String POST_PARAMS = gson.toJson(employee);

                URL url = new URL("https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/submit");
                HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
                postConnection.setRequestMethod("POST");
                postConnection.setRequestProperty("Content-Type", "applilcation/json");

                postConnection.setDoOutput(true);
                OutputStream os = postConnection.getOutputStream();
                os.write(POST_PARAMS.getBytes());
                os.flush();
                os.close();

                int responseCode = postConnection.getResponseCode();
                System.out.println("POST Response Code: "+responseCode);
                System.out.println("POST Response Message: "+postConnection.getResponseMessage());

                if(responseCode == HttpURLConnection.HTTP_OK){
                    BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
                    String intputLine;
                    StringBuffer response = new StringBuffer();

                    while((intputLine = in .readLine()) != null){
                        response.append(intputLine);
                    } in .close();

                    System.out.println(response.toString());
                    System.out.println(POST_PARAMS);
                } else {
                    System.out.println("POST NOT WORKED");
                }
            } else {
                String msg = "Error Fields not Entered Correctly.\nNote: email and supervisor fields can be entered as null.\nPlease try again in format: \"*firstName* *lastName* *email* *phoneNumber* *supervisor*\"";
                FieldsEnteredIncorrectly ex = new FieldsEnteredIncorrectly(msg);
                throw ex;
            }
        } catch (FieldsEnteredIncorrectly e){
            e.printStackTrace();
        }
    }
}
