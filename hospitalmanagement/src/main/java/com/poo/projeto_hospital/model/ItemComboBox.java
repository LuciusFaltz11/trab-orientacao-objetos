package com.poo.projeto_hospital.model;

public class ItemComboBox {
    private String displayText;
    private String value;

    public ItemComboBox(String displayText, String value) {
        this.displayText = displayText;
        this.value = value;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return displayText; // Define como o item é exibido no JComboBox
    }
}
