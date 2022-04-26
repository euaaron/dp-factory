import java.util.List;

public class EraseOnBash implements IEraseOnTerminal {

    public void erase(String path) {
        try(var writer = System.console().writer() ) {
            writer.println("rm -rf " + path);
        } catch (Exception e) {
            System.out.println("EraseOnBash.erase: " + e.getMessage());
        }
    }

    public void erase(List<String> paths) {
        try(var writer = System.console().writer() ) {
            for (String path : paths) {
                writer.println("rm -rf " + path);
            }
        } catch (Exception e) {
            System.out.println("EraseOnBash.erase: " + e.getMessage());
        }
    }
}