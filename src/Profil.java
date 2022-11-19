/* Данный класс предназначен для создания пользователя чата
У пользователя есть его имя в чате и пароль, которые он может менять, а также тег - число, которое изменить невозможно
Пользователь имеет возможность изменять имя и свой пароль, а также отправлять в чат сообщения
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Profil {
    private String name_user;
    private final String login;
    private final int teg;
    private String password;
    private String telephone;

    public Profil(String name_user, String login, int teg, String password, String telephone) {
        //Конструктор: создаёт конкретного пользователя с введённым им именем и паролем и сгенерированным тегом
        this.name_user = name_user;
        this.login = login;
        this.teg = teg;
        this.password = password;
        this.telephone = telephone;
    }

    public String getNameUser() {
        //Метод позволяет получить имя данного пользователя
        return name_user;
    }

    public String getLogin() {
        return login;
    }

    public int getTeg() {
        //Метод позволяет получить тег данного пользователя
        return teg;
    }

    public String getPassword() {
        //Метод позволяет получить пароль для проверки при входе в аккаунт
        return password;
    }

    public void setNameUser(String new_name) {
        //Метод позволяет изменить имя данного пользователя
        this.name_user = new_name;
    }

    public void setPassword(String new_password) {
        //Метод позволяет изменить пароль данного пользователя
        this.password = new_password;
    }

    public void sendMessage(String message) throws Exception {
        //Метод осуществляет отправку вообщения (пока что запись в файл)
        BufferedWriter fw;
        boolean is_empty = false;
        EncryptPGP encrypter = new EncryptPGP();

        EmptyMessageException space = new EmptyMessageException();
        if (message.equals("")) {
            space.nameEmpty();
            is_empty = true;
        }
        try {
            FileWriter writer = new FileWriter("Reading.txt", true);
            FileWriter encrypt_write = new FileWriter("Encrypted.txt", true);
            fw = new BufferedWriter(writer);
            if (!is_empty) {
                fw.write(this.getNameUser() + " " + new Date() + ": " + message);
                fw.write("\n");
                try {
                    encrypt_write.write(this.getNameUser() + " " + new Date() + ": " + encrypter.encrypt(message));
                    encrypt_write.write("\n");
                    encrypt_write.close();
                } catch (Exception e) {
                    System.out.println("Возникла ошибка шифрования" + "\n" + e);
                }
            } else {
                fw.write(this.getNameUser() + " " + new Date() + " попытался отправить пустое сообщение.");
                fw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Произошла ошибка: нет нужного файла, чтобы записать сообщение. Сорри");
        } catch (IOException e) {
            System.out.println("Возникла какая-то ошибка ввода. Попробуйте ещё раз отправить сообщение");
        }
    }

    public void setTelephone(String number) {
        try {
            Telephone number_test;
            number_test = new Telephone(number);
            this.telephone = number_test.getNumber();
        } catch (WrongTelephoneNumberException e) {
            System.out.println("Формат номера неверен, задать его невозможно");
        }
    }

    public String getTelephone() {
        return telephone;
    }
}