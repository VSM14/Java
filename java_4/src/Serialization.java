import java.io.*;

public class Serialization {public static void recordObject(String filename, MotorShow motorShow) throws IOException {
    FileOutputStream fileOutput = new FileOutputStream(filename);
    ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
    objectOutput.writeObject(motorShow);
    fileOutput.close();
    objectOutput.close();
}

    public static void uploadObject(String filename) throws IOException, ClassNotFoundException {

        FileInputStream fileInput = new FileInputStream(filename);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        MotorShow motorShowUploaded = (MotorShow) objectInput.readObject();
        System.out.println(motorShowUploaded.Title);
        fileInput.close();
        objectInput.close();
    }

    public static MotorShow returnObject(String filename) throws IOException, ClassNotFoundException {

        FileInputStream fileInput = new FileInputStream(filename);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        return (MotorShow) objectInput.readObject();
    }
}
