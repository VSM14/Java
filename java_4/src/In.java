import java.io.IOException;

public class In {
    public String InString() throws IOException {
        byte[] b = new byte[100];
        System.in.read(b);
        return new String(b).trim();
    }

    public int InInt() throws IOException {
        try {
            byte[] b = new byte[100];
            System.in.read(b);
            String s = new String(b);
            return Integer.parseInt(s.trim());
        } catch (java.lang.NumberFormatException ex) {
            System.out.print("Неверно задано числовое значение\n");
            throw ex;
        }
    }
}