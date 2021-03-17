package Enums;

public enum Categories {

    Оргтехника("Оргтехника и расходники",12),
    По_умолчанию("По умолчанию",11),
    Телефоны("Телефоны",5),
    Дороже("Дороже",1),
    Дешевле("Дешевле",6),
    По_дате("По дате",3);
    private String value;
    private int id;

    Categories(String value, int id) {
        this.value = value;
        this.id=id;
    }
    public String getValue(){
        return this.value;
    }
    public int getId(){
        return this.id;
    }



}
