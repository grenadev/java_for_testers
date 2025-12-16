package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

//    @Test
//    void canRegisterUser(String username) {
//        var email = String.format("%s@localhost", username);
//        //1создать пользователя (адрес) на почтовом сервере (JamesHelper)
//        //2заполняем форму создания и отправляем (браузер) - создать класс помощник с этими действиями
//        //3ждем почту (MailHelper)
//        //4извлекаем ссылку из письма
//        //5проходим по ссылке и завершаем регистрацию (браузер) - создать класс помощник из шага 2
//        //6проверяем, что пользователь может залогиниться (HttpSessionHelper)
//
//    }

    @Test
    void canRegisterUser() {
        var name = CommonFunctions.randomString(8);
        try {
            app.jamesCli().addUser(name + "@localhost", "password");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        app.session().registration(name, name+"@localhost");
        var messages = app.mail().receive(name + "@localhost", "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        String url = null;
        if (matcher.find()) {
            url = text.substring(matcher.start(), matcher.end()); // присваиваем
        }
        if (url != null) {
            app.driver().get(url);
        } else {
            throw new RuntimeException("Ссылка не найдена");
        }
        app.session().submitRegistration(name, "password", "password");
        app.http().login(name, "password");
        app.http().isLoggedIn();
    }
}
