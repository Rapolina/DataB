package DAY9;

public class Main {
    public static void main(String[] args) {
        DataB dataBase = new DataB();
        dataBase.deleteTable();
        dataBase.createTable();
        dataBase.addUsers();
        dataBase.read();
    }

}
