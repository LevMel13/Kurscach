public class Telephone {
    private String number;

    public Telephone(String s) throws WrongTelephoneNumberException {
        WrongTelephoneNumberException wrong = new WrongTelephoneNumberException();
        s = s.trim();
        //String[] wrong = new String[]{"a", "b", "c", "d", "e", "f", "g", "e", "k", "l", "m", "n", "o", "p", "r", "s", "r", "t", "u", "q",
        //      "x", "z", "w", "v", "h", "j", "(", ")", "-", " ", "?", ".",
        //    ",", ":", ";", "@", "#", "$", "!", "%", "^", "&", "*", "~", "<", ">"};
        s = s.replaceAll("(\\D)", "");
        if (s.length() == 11 || s.length() == 10) {
            s = s.substring(s.length() - 10);
            s = "+7" + s;
            this.number = s;
        }
        else wrong.nameWrong();
    }

    public String getNumber() {
        return number;
    }
}
