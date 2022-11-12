public class WrongTelephoneNumberException extends Exception {
    public void nameWrong() throws WrongTelephoneNumberException {
        throw new WrongTelephoneNumberException();
    }
}
