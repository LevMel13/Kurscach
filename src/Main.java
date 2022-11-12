import com.didisoft.pgp.PGPException;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, EmptyMessageException, WrongTelephoneNumberException, PGPException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько аккаунтов Вы намерены внести?");
        boolean logic;
        int n = 0;
        do {
            logic = false;
            try {
                logic = true;
                n = sc.nextInt();
            } catch (ClassCastException e) {
                System.out.println("Число аккаунтов должно быть целым числом. Пожалуйста, перепроверьте введённые данные.");
                logic = false;
            }
        } while (!logic);

        ArrayList<Profil> base;
        base = new ArrayList<>();
        int k = 0;


        while (k < n) {
            System.out.println("Введите имя пользователя и пароль на отдельных строчках:");
            String name = sc.next();
            String password = sc.next();
            int teg = 100000 + (int) (Math.random() * 900000);
            System.out.println("Введите Ваш логин:");
            String login = sc.next();
            Profil example = new Profil(name, login, teg, password, "");
            System.out.println("Создан пользователь:");
            System.out.println(example.getLogin() + " " + example.getTeg());
            boolean flag = false;
            do {
                System.out.println("Введите Ваш номер телефона в любом виде:");
                String number = sc.next();
                try {
                    Telephone cifres = new Telephone(number);
                } catch (WrongTelephoneNumberException e) {
                    System.out.println("Номер не задан. Проверьте правильность ввода");
                    continue;
                }
                example.setTelephone(number);
                System.out.println("Задан номер");
                System.out.println(example.getTelephone());
                flag = true;
            } while (!flag);
            base.add(example);
            k += 1;
        }
        String login = "";
        while (!(login.toLowerCase()).equals("stop")) {
            System.out.println("Введите логин, чтобы залогониться, stop, чтобы прервать переписку");
            login = sc.next();
            if ((login.toLowerCase()).equals("stop")) {
                break;
            }
            Profil log = null;
            int counter = 0;
            for (Profil i : base) {
                counter = 0;
                if (i.getLogin().equals(login)) {
                    System.out.println("Введите пароль:");
                    String passw = sc.next();
                    if (!i.getPassword().equals(passw)) {
                        System.out.println("Пароль неверен, залогиниться не вышло!");
                        break;
                    } else {
                        System.out.println("Вы вошли, можете писать сообщения! logout, чтобы выйти из аккаунта");
                        log = i;
                        break;
                    }
                } else {
                    counter += 1;
                }
            }
            if (counter == base.size()) {
                System.out.println("Пользователь не найден");
                continue;
            }
            String message = "";
            while (!(message.toLowerCase()).equals("logout")) {
                message = sc.nextLine();
                message = message.strip();
                if (!(message.toLowerCase()).equals("logout")) {
                    log.sendMessage(message);
                }
            }
        }
        sc.close();
    }
}