
package controller;

import model.InventoryItem;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<InventoryItem> items;

    public InventoryManager() {
        items = new ArrayList<>();
    }

    // Agrega un ítem al inventario
    public void addItem(InventoryItem item) {
        items.add(item);
    }

    // Actualiza un ítem en una posición dada
    public void updateItem(int index, InventoryItem item) {
        if (index >= 0 && index < items.size()) {
            items.set(index, item);
        }
    }

    // Obtiene la lista completa de ítems
    public ArrayList<InventoryItem> getItems() {
        return items;
    }
}
