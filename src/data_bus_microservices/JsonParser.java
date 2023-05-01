package data_bus_microservices;

public class JsonParser {
    public Record parse(String json) {
//        json = json.replaceAll("\\s", "");
        Record record = new Record();
        String[] tokens = json.split("[,:{}\"]+");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("account")) {
                record.setAccount(Long.parseLong(tokens[i + 2]));
            } else if (tokens[i].equals("name")) {
                record.setName(tokens[i + 2]);
            } else if (tokens[i].equals("value")) {
                record.setValue(Double.parseDouble(tokens[i + 2]));
            }
        }
        return record;
    }
}
