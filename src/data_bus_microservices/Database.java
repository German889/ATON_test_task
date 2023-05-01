package data_bus_microservices;

import java.util.TreeMap;

public class Database {
    private TreeMap<Long, Record> accountMap = new TreeMap<>();
    private TreeMap<String, Record> nameMap = new TreeMap<>();
    private TreeMap<Double, Record> valueMap = new TreeMap<>();

    public Record find(long account){
        Record record = accountMap.get(account);
        if(record == null) record = new Record(0,"null",0.0);
        return record;
    }
    public Record find(String name){
        Record record = nameMap.get(name);
        if(record == null) record = new Record(0,"null",0.0);
        return record;
    }
    public Record find(double value){
        Record record = valueMap.get(value);
        if(record == null) record = new Record(0,"null",0.0);
        return record;
    }
    public void addRecord(String JSON_record){
        JsonParser parser = new JsonParser();
        Record record = parser.parse(JSON_record);
        accountMap.put(record.getAccount(),record);
        nameMap.put(record.getName(), record);
        valueMap.put(record.getValue(), record);
    }
    public void addRecord(Record record){
        accountMap.put(record.getAccount(),record);
        nameMap.put(record.getName(), record);
        valueMap.put(record.getValue(), record);
    }
    public void delete(long account){
        Record record = accountMap.get(account);
        accountMap.remove(record.getAccount());
        nameMap.remove(record.getName());
        valueMap.remove(record.getValue());
    }
    public void delete(String name){
        Record record = nameMap.get(name);
        accountMap.remove(record.getAccount());
        nameMap.remove(record.getName());
        valueMap.remove(record.getValue());
    }
    public void delete(double value){
        Record record = valueMap.get(value);
        accountMap.remove(record.getAccount());
        nameMap.remove(record.getName());
        valueMap.remove(record.getValue());
    }
    public void change(long account, Record newRecord){
        delete(account);
        addRecord(newRecord);
    }
    public void change(String name, Record newRecord){
        delete(name);
        addRecord(newRecord);
    }
    public void change(double value, Record newRecord){
        delete(value);
        addRecord(newRecord);
    }
    public void deleteWithTypeCheck(String s){// на вход любой параметр в виде строки
        // функция определит что это, и вызовет нужный метод удаления
        long account = 0;
        String name = "";
        double value = 0.0;
        String typeCheck = "";

        if (s == null || s.isEmpty()) {
            System.out.println("string is null");;
        }
        if (!Character.isDigit(s.charAt(0))){
            name = s;
            typeCheck = "string";
        }
        boolean isLong = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                isLong = false;
                break;
            }
        }
        if (isLong) {// long
            account = Long.parseLong(s);
            typeCheck = "long";
        }
        try {// double
            value = Double.parseDouble(s);
            typeCheck = "double";
        } catch (NumberFormatException e) {// некорректный формат
            System.out.println("string is null");;
        }
        switch(typeCheck){
            case "long": delete(account);
            case "string": delete(name);
            case "double": delete(value);
        }
    }

}
