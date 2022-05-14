public class MyException {

    static class KolvoAvtomobileyException extends Exception {
        public KolvoAvtomobileyException(String Message) {
            super(Message);
        }
    }

    static class FIOException extends Exception {
        public FIOException(String Message) {
            super(Message);
        }
    }
}
