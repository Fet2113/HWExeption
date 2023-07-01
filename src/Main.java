public class Main {

    public static void main(String[] args) {

        checkLoginAndPassword("Test", "1Test", "Test");
    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) {

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Все по домам!");
        }
    }

    // Проверяем login
    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches("^[a-zA-Z0-9_]{1,20}$")) {
            throw new WrongLoginException("Ошибка!Используются недопустимые для логина символы: " + login);
        }
    }
    // Проверяем password

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("^[a-zA-Z0-9_]{1,20}$")) {
            throw new WrongPasswordException("Ошибка!Используются недопустимые для пароля символы: " + password);
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }
}
