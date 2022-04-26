package Erase;

public interface IEraseOnTerminal {
    String command = "rm -rf ";
    void erase(String path);
}
