package data_bus_microservices;

public class Record {

    private long account;
    private String name;
    private double value;

    public Record(){}
    public Record(long account, String name, double value) {
        this.account = account;
        this.name = name;
        this.value = value;
    }

    public long getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
    public void setAccount(long account){
        this.account = account;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValue(double value){
        this.value = value;
    }

    public String toString() {
        return String.format("""
            {
                "account":"%s",
                "name":"%s",
                "value":"%.2f"
            }
            """,
                this.account,
                this.name,
                this.value);
    }
}
