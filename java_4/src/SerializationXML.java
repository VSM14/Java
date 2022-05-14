import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class SerializationXML {
    public void recordObject(String filename, MotorShow motorShow) throws IOException {

        FileOutputStream fileOutput = new FileOutputStream(filename);
        XMLEncoder objectOutput = new XMLEncoder(new BufferedOutputStream(fileOutput));
        objectOutput.writeObject(motorShow);
        objectOutput.close();
        fileOutput.close();
    }

    public MotorShow uploadObject(String filename) throws IOException {

        FileInputStream fileInput = new FileInputStream(filename);
        XMLDecoder objectInput = new XMLDecoder(new BufferedInputStream(fileInput));
        MotorShow motorShow = (MotorShow) objectInput.readObject();
        objectInput.close();
        fileInput.close();
        return motorShow;
    }
}
