package Erase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EraseOn implements IEraseOnTerminal {
    String command = "rm -rf ";

    public void erase(String path) {
        String[] paths = path.split(", ");
        for (String p : paths) {
            this.exec(p);
        }
    }

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
