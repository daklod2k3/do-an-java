package GUI;
import javax.swing.*;
import java.awt.*;

public class hdview extends JPanel {
    private JTextField invoiceCodeField;
    private JTextField customerNameField;
    private JTextField employeeNameField;
    private JTextArea billItemsArea;

    public hdview() {
        setLayout(new BorderLayout());

        // Create and add components
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        billItemsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(billItemsArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));

        // Invoice Code
        JLabel invoiceCodeLabel = new JLabel("Invoice Code:");
        invoiceCodeField = new JTextField();
        topPanel.add(invoiceCodeLabel);
        topPanel.add(invoiceCodeField);

        // Customer Name
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField();
        topPanel.add(customerNameLabel);
        topPanel.add(customerNameField);

        // Employee Name
        JLabel employeeNameLabel = new JLabel("Employee Name:");
        employeeNameField = new JTextField();
        topPanel.add(employeeNameLabel);
        topPanel.add(employeeNameField);

        return topPanel;
    }

    public String getInvoiceCode() {
        return invoiceCodeField.getText();
    }

    public void setInvoiceCode(String invoiceCode) {
        invoiceCodeField.setText(invoiceCode);
    }

    public String getCustomerName() {
        return customerNameField.getText();
    }

    public void setCustomerName(String customerName) {
        customerNameField.setText(customerName);
    }

    public String getEmployeeName() {
        return employeeNameField.getText();
    }

    public void setEmployeeName(String employeeName) {
        employeeNameField.setText(employeeName);
    }

    public String getBillItems() {
        return billItemsArea.getText();
    }

    public void setBillItems(String billItems) {
        billItemsArea.setText(billItems);
    }
}
