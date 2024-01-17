package demo;

public enum PetTypeEnum {
    DOG("Dog", "Canine"), CAT("Cat", "Feline");

    private PetTypeEnum(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public final String getId() {
        return id;
    }

    public final String getDesc() {
        return desc;
    }

    //public static Map getMap() {
    //    return map;
    //}

    private final String id;
    private final String desc;
    //private static final Map map;
}
