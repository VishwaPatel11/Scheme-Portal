public class Main {

    // DataBase:- SE_project.
    // Having Two Tables, One For Sign-Up Details, and Another For Card Details.
    // Tables are Named as:- firstTable, secondTable_.

    public static void main(String[] args) {
        Password_Id passwordId = new Password_Id();
        LoginPage loginPage = new LoginPage();
        loginPage.logicPageClass(passwordId.returnMap());
    }
}

