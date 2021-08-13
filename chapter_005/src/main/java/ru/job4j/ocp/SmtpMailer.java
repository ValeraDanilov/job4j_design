package ru.job4j.ocp;

public class SmtpMailer {

    class Logger {
        public void Log(String logText) {
            // сохранить лог в файле
        }
    }

    private Logger logger;

    public SmtpMailer() {
        logger = new Logger();
    }

    public void SendMessage(String message) {
        // отсылка сообщения
        logger.Log(String.format("Отправлено '{0}'", message));
    }
}

// 3 - й пример. У нас есть класс SmtpMailer. Для логирования своих действий он использует Logger, который записывает информацию в текстовые файлы.
// Если мы решим записать лог SmptMailer в базу данных. То нам придется нам надо создать класс, который будет записывать все логи не в текстовый файл, а в базу данных. Для этого нам придется изменить класс SmtpMailer.
// Решение использовать интерфейс для логера.
