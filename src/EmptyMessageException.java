public class EmptyMessageException extends Exception {
    public void nameEmpty() throws EmptyMessageException {
        throw new EmptyMessageException();
    }
}
