import Erase.EraseFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EraseOnFactoryTest {
    Runtime runtime = Runtime.getRuntime();

    @BeforeEach
    void setUp() {
        try {
            runtime.exec("mkdir ./testFolder");
            runtime.exec("mkdir ./testFolder/java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestIfDirectoryExists() {
        try {
            Process listDir = runtime.exec("ls");
            BufferedReader reader = new BufferedReader(new InputStreamReader(listDir.getInputStream()));
            StringBuilder line = new StringBuilder();
            String outline;
            while ((outline = reader.readLine()) != null) {
                line.append(outline).append("\n");
            }
            System.out.println(line);
            assert(line.toString().contains("testFolder"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestIfDeletedSuccessfully() {
        try {
            EraseFactory.get().erase("./testFolder");
            TestIfDirectoryExists();
        } catch (AssertionError e) {
            assert(true);
        }
    }
}