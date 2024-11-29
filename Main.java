public class Main {
    public static void main(String[] args) {


        DBlogic db = new DBlogic();

        db.addUser("brunoMajasdarbs", "brunoMajasdarbsParole");

        db.updateUser("testPass2", 5);

        db.deleteUser(2);

        db.getUsers();



    }
}
