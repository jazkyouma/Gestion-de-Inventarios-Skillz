package view;

import controller.InventoryManager;
import model.InventoryItem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryApp extends JFrame {
    private InventoryManager inventoryManager;
    private DefaultTableModel tableModel;
    private JTable table;

    public InventoryApp() {
        inventoryManager = new InventoryManager();
        setTitle("Sistema de Inventario de Materiales");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar la tabla para visualizar el inventario
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Cantidad", "Umbral"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel de controles para agregar, actualizar y verificar alertas
        JPanel controlPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel lblName = new JLabel("Nombre:");
        JTextField txtName = new JTextField();
        JLabel lblQuantity = new JLabel("Cantidad:");
        JTextField txtQuantity = new JTextField();
        JLabel lblThreshold = new JLabel("Umbral:");
        JTextField txtThreshold = new JTextField();

        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar Selección");
        JButton btnCheck = new JButton("Verificar Alertas");

        controlPanel.add(lblName);
        controlPanel.add(txtName);
        controlPanel.add(lblQuantity);
        controlPanel.add(txtQuantity);
        controlPanel.add(lblThreshold);
        controlPanel.add(txtThreshold);
        controlPanel.add(btnAdd);
        controlPanel.add(btnUpdate);
        controlPanel.add(btnCheck);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Acción para agregar un nuevo ítem
        btnAdd.addActionListener(e -> {
            try {
                String name = txtName.getText();
                int quantity = Integer.parseInt(txtQuantity.getText());
                int threshold = Integer.parseInt(txtThreshold.getText());
                InventoryItem item = new InventoryItem(name, quantity, threshold);
                inventoryManager.addItem(item);
                updateTable();
                JOptionPane.showMessageDialog(null, "Ítem agregado exitosamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para cantidad y umbral.");
            }
        });

        // Acción para actualizar el ítem seleccionado
        btnUpdate.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    String name = txtName.getText();
                    int quantity = Integer.parseInt(txtQuantity.getText());
                    int threshold = Integer.parseInt(txtThreshold.getText());
                    InventoryItem item = new InventoryItem(name, quantity, threshold);
                    inventoryManager.updateItem(selectedRow, item);
                    updateTable();
                    JOptionPane.showMessageDialog(null, "Ítem actualizado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para cantidad y umbral.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un ítem a actualizar.");
            }
        });

        // Acción para verificar alertas de inventario bajo
        btnCheck.addActionListener(e -> {
            StringBuilder alerts = new StringBuilder();
            for (InventoryItem item : inventoryManager.getItems()) {
                if (item.getQuantity() < item.getThreshold()) {
                    alerts.append("El ítem '").append(item.getName())
                            .append("' está por debajo del umbral.\n");
                }
            }
            if (alerts.length() > 0) {
                JOptionPane.showMessageDialog(null, alerts.toString(), "Alertas de Inventario", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay alertas en el inventario.");
            }
        });
    }

    // Actualiza la tabla con los datos actuales del inventario
    private void updateTable() {
        tableModel.setRowCount(0);
        for (InventoryItem item : inventoryManager.getItems()) {
            tableModel.addRow(new Object[]{item.getName(), item.getQuantity(), item.getThreshold()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryApp().setVisible(true));
    }
}