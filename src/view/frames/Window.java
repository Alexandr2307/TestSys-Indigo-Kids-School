package view.frames;

import controllers.WindowsController;
import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;
import view.MainContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Window extends JFrame implements ActionListener, MainContract.View {

    private JPanel mainPanel;
    private JButton submitButton;
    private WindowsController controller;
    private JScrollPane scrollPane;
    private List<QuestionPanel> jPanelList;

    public Window() {
        super("Kanat - sexy boy");
        this.setBounds(250, 50, 650, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        initComponents();

        List<QuestionPOJO> list = controller.getQuestionList();
        for (QuestionPOJO questionListPOJO : list) {
            mainPanel.add(new QuestionPanel(questionListPOJO));
        }

        add(scrollPane);
        add(submitButton, BorderLayout.SOUTH);
    }

    private void initComponents() {
        jPanelList = new ArrayList<>();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        mainPanel = new JPanel(new GridLayout(0, 1));

        scrollPane = new JScrollPane(mainPanel);

        controller = new WindowsController();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Submit":
                controller.calculate();
                Component[] components = mainPanel.getComponents();
                for (Component component : components) {
                    jPanelList.add((QuestionPanel) component);
                }
                for (QuestionPanel panel : jPanelList) {
                    System.out.println(panel.getFirstRBtn().isSelected());
                    System.out.println(panel.getSecondRBtn().isSelected());
                    System.out.println(panel.getThirdRBtn().isSelected());
                    System.out.println(panel.getFourthRBtn().isSelected());
                    System.out.println("----------------------");
                }
                submitButton.setEnabled(false);
                break;
            case "":
                break;
        }
    }
}
