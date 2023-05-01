package data_bus_microservices;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        Record testRecord = objectGenerator();
        System.out.println(testRecord.toString());
        Database DB = new Database();

        //=========Проверка добавления===========
        System.out.println("=========Проверка добавления===========");
        DB.addRecord(testRecord); //добавление объекта
        System.out.println(DB.find(testRecord.getAccount()).toString());
        //добавление json строки, превращаемой в объект
        DB.addRecord("{\"account\": \"234678\",\"name\": \"Иванов Иван Иванович\",\"value\": \"2035.34\"}");

        //========Проверка поиска=========
        System.out.println("========Проверка поиска=========");
        System.out.println(DB.find(234678).toString());
        System.out.println(DB.find("Иванов Иван Иванович").toString());
        System.out.println(DB.find(2035.34).toString());

        //========Проверка изменения==========
        System.out.println("========Проверка изменения==========");
        System.out.println("до изменения");
        System.out.println(DB.find(234678));
        Record forChange = new Record(234678,"Harry James Potter",34.04);
        DB.change(234678,forChange);
        System.out.println("после изменения");
        System.out.println(DB.find(234678));

        //========Проверка удаления==========
        System.out.println("========Проверка удаления==========");
        DB.delete(234678);
        DB.delete(testRecord.getName());
        System.out.println(DB.find(234678).toString());
        System.out.println(DB.find(testRecord.getName()).toString());


    }
    public static Record objectGenerator(){
        final int MAX_ACCOUNT_NUMBER = 1000000000;
        final String[] FIRST_NAMES = {"John", "Emily", "David", "Alice", "Olivia", "Jacob", "Emma", "Michael", "Daniel"}; // Массив имен
        final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez"}; // Массив фамилий
        final double MAX_VALUE = 100000.00;

        Random random = new Random();
        long account = random.nextInt(MAX_ACCOUNT_NUMBER);
        String name = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + " " + LAST_NAMES[random.nextInt(LAST_NAMES.length)]; // Генерируем случайное имя и фамилию
        double value = random.nextDouble() * MAX_VALUE;
        return new Record(account, name, value);
    }
}
