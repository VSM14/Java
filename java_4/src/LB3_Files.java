import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class LB3_Files {
    public static void main(String[] args) throws IOException {

        String path1 = "lb3_f1";
        String path2 = "lb3_f2";
        String path3 = "lb3_f3";
        String path4 = "lb3_f4";

        FileInputStream f1_in = new FileInputStream(path1);

        byte[] b = new byte[f1_in.available()];
        f1_in.read(b);
        String str = new String(b);
        str = str.trim();
        String[] lines = str.split("\n");

        FileOutputStream f2_out = new FileOutputStream(path2);
        FileOutputStream f3_out = new FileOutputStream(path3);

        for (String line : lines) {
            int signs = line.length() - 1;
            int words = 1;

            if (signs == 0) {
                words = 0;
            } else {
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == ' ') words++;
                }
                for (int j = 0; j < line.length() - 1; j++) {
                    if ((line.charAt(j) == ' ') && ((line.charAt(j + 1) == '-') || (line.charAt(j + 1) == '—')))
                        words--;
                }
            }

            f2_out.write(Integer.toString(signs).getBytes());
            f2_out.write('\r');
            f2_out.write('\n');

            f3_out.write(Integer.toString(words).getBytes());
            f3_out.write('\r');
            f3_out.write('\n');

        }

        FileInputStream f2_in = new FileInputStream(path2);
        FileInputStream f3_in = new FileInputStream(path3);

        FileOutputStream f4_out = new FileOutputStream(path4);


        byte[] b2 = new byte[f2_in.available()];
        f2_in.read(b2);
        String s2 = new String(b2);
        s2 = s2.trim();
        String[] lines2 = s2.split("\n");

        byte[] b3 = new byte[f3_in.available()];
        f3_in.read(b3);
        String s3 = new String(b3);
        s3 = s3.trim();
        String[] lines3 = s3.split("\n");

        for (int i = 0; i < lines.length; i++) {
            f4_out.write(lines[i].trim().getBytes());
            f4_out.write(" ".getBytes());
            f4_out.write(lines2[i].trim().getBytes());
            f4_out.write(" ".getBytes());
            f4_out.write(lines3[i].trim().getBytes());
            f4_out.write(File.separator.getBytes());

            System.out.println(lines[i].trim() + " " + lines2[i].trim() + " " + lines3[i].trim());

        }

    }
}
