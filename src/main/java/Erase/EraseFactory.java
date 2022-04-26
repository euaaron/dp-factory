package Erase;

public class EraseFactory {
    public static IEraseOnTerminal get(String  sistema) {
        Class classe;
        Object objeto = null;
        try {
            classe = Class.forName("Erase.EraseOn" + sistema);
            objeto = classe.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(objeto instanceof IEraseOnTerminal)) {
            throw new IllegalArgumentException("Terminal não suportado.");
        }
        return (IEraseOnTerminal) objeto;
    }

    public static IEraseOnTerminal get() {
        String terminal = System.getProperty("os.name").toUpperCase().split(" ")[0];
        return get(terminal);
    }

}
