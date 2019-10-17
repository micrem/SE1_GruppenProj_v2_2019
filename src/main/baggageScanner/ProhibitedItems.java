package baggageScanner;

public enum ProhibitedItems {
    knife("kn!fe"),
    explosive("exp|os!ve"),
    gun("glock|7"),
    none("");

    private String itemString;

    ProhibitedItems(String itemString) {
        this.itemString = itemString;
    }

    String getItemString() {
        return itemString;
    }
}


