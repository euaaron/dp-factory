import Erase.EraseFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String path = reader.readLine();
            if (path.equals("")) {
                System.out.println("Usage: erase ./path or erase ./path, ./other/Path");
            } else {
                EraseFactory.get().erase(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
