public class Main {
    public static void main(String[] args) {
        Password_Id passwordId = new Password_Id();
        LoginPage loginPage = new LoginPage(passwordId.returnMap());
    }
}

