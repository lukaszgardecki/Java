package Zad_41_SklepInternetowy;

enum Status {
    NEW("Nowe"),
    PAID("Op³acone"),
    SHIPPED("Wys³ane"),
    DELIVERED("Dostarczone"),
    CANCELLED("Anulowane");

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    static String getStatuses() {
        String allStatuses = "";
        for (Status status : values()) {
            allStatuses += (status.name() + " ");
        }
        return allStatuses.substring(0, allStatuses.length() - 1);
    }
}
