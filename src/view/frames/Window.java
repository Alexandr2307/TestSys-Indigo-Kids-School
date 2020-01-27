package view.frames;

import presenter.WindowsPresenter;
import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionPOJO;
import repo.repo_types.FileRepository;
import view.MainContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements ActionListener, MainContract.View {

    private JPanel mainPanel;
    private JButton submitButton;
    private JScrollPane scrollPane;
    private List<QuestionPanel> jPanelList;
    private String pathToQuestion;
    private String pathToAnswer;
    private MainContract.Presenter presenter;
    private List<AnswerPOJO> answerList;

    public Window(String pathToQuestion, String pathToAnswer) {
        super("Kanat - sexy boy");
        this.setBounds(250, 50, 650, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.pathToAnswer = pathToAnswer;
        this.pathToQuestion = pathToQuestion;
        initComponents();

        List<QuestionPOJO> list = presenter.getQuestionList();
        answerList = presenter.getAnswerList();
        for (QuestionPOJO questionListPOJO : list) {
            mainPanel.add(new QuestionPanel(questionListPOJO));
        }

        add(scrollPane);
        add(submitButton, BorderLayout.SOUTH);
    }

    private void initComponents() {
        File questionFile = new File(pathToQuestion);
        File answerFile = new File(pathToAnswer);

        jPanelList = new ArrayList<>();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        mainPanel = new JPanel(new GridLayout(0, 1));

        scrollPane = new JScrollPane(mainPanel);

        presenter = new WindowsPresenter(this);
        presenter.setFiles(questionFile, answerFile);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Submit":
                presenter.calculate();
                Component[] components = mainPanel.getComponents();
                for (Component component : components) {
                    jPanelList.add((QuestionPanel) component);
                }
                int res = 0;
                for (int i = 0; i < jPanelList.size(); i++) {
                    if (answerList.get(i).isFirst() == jPanelList.get(i).getFirstRBtn().isSelected()
                    && answerList.get(i).isSecond() == jPanelList.get(i).getSecondRBtn().isSelected()
                    && answerList.get(i).isThird() == jPanelList.get(i).getThirdRBtn().isSelected()
                    && answerList.get(i).isFourth() == jPanelList.get(i).getFourthRBtn().isSelected()) {
                        res ++;
                    }
                }
                System.out.println(res);
                submitButton.setEnabled(false);
                break;
            case "":
                break;
        }
    }
}
