package view.frames;

import javax.swing.*;
import java.awt.*;

public class LabelInputPanel extends JPanel {

    private JLabel label;
    private JTextField field;
    private JButton applyBtn;

    private String labelValue;

    LabelInputPanel(String labelValue) {
        this.labelValue = labelValue;
        initComponents();
        this.setLayout(new GridLayout(0, 3));
        add(label);
        add(field);
        add(applyBtn);

        applyBtn.addActionListener(actionEvent -> {
            if (!field.getText().isEmpty()) {
                field.setEnabled(false);
                applyBtn.setEnabled(false);
            }
        });
    }

    private void initComponents() {
        label = new JLabel(labelValue);
        field = new JTextField();
        applyBtn = new JButton("Подтвердить");
    }

    public JButton getApplyBtn() {
        return applyBtn;
    }

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }

}
