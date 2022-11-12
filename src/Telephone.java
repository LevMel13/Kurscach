public class Telephone {
    private boolean valid = true;
    private String number;

    public Telephone(String s) throws WrongTelephoneNumberException {
        WrongTelephoneNumberException wrong = new WrongTelephoneNumberException();
        s.trim();
        //String[] wrong = new String[]{"a", "b", "c", "d", "e", "f", "g", "e", "k", "l", "m", "n", "o", "p", "r", "s", "r", "t", "u", "q",
        //      "x", "z", "w", "v", "h", "j", "(", ")", "-", " ", "?", ".",
        //    ",", ":", ";", "@", "#", "$", "!", "%", "^", "&", "*", "~", "<", ">"};
        s = s.replaceAll("(\\D)", "");
        if (s.length() != 11) wrong.nameWrong();
        else s.concat("+7");
        this.number = s;
    }

    public boolean getValid() {
        return valid;
    }

    public String getNumber() {
        return number;
    }
}
