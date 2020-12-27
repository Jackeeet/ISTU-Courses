package steps;

public enum SortOptions {
    ПоУмолчанию("101"),
    Дешевле("1"),
    Дороже("2"),
    ПоДате("104");

    public String value;

    SortOptions(String value){
        this.value = value;
    }
}