package Erase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EraseOnWINDOWS extends EraseOn {
    String command = "rm -r -Force ";

    @Override
    protected void exec(String path) {
        try {
            Process process = Runtime.getRuntime().exec(command + path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
