
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.ProtocolException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception
    {
        if(args[0].equals("GET/api/supervisors")) {
            List<String> managers = (ArrayList<String>) new GetHandler().organizedManagers();
            for (String manager : managers) {
                System.out.println(manager);
            }
        }
        else if(args[0].equals("POST/api/submit")){

        }
    }
}
