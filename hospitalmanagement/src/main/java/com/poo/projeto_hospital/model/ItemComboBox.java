/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
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
