package view.frames;

import presenter.WindowsPresenter;
import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionPOJO;
import other.MainContract;

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
    private String pathToResultFile;
    private MainContract.Presenter presenter;
    private List<AnswerPOJO> answerList;
    private LabelInputPanel labelInputPanel;

    public Window(String pathToQuestion, String pathToAnswer, String pathToResultFile) {
        super("Kanat - sexy boy");
        this.setBounds(250, 50, 650, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.pathToAnswer = pathToAnswer;
        this.pathToQuestion = pathToQuestion;
        this.pathToResultFile = pathToResultFile;
        initComponents();

        List<QuestionPOJO> list = presenter.getQuestionList();
        answerList = presenter.getAnswerList();
        for (QuestionPOJO questionListPOJO : list) {
            mainPanel.add(new QuestionPanel(questionListPOJO));
        }

        add(labelInputPanel, BorderLayout.NORTH);
        add(scrollPane);
        add(submitButton, BorderLayout.SOUTH);
    }

    public Window() {
        super("Kanat - sexy boy");
        this.setBounds(250, 50, 650, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        /**init*/
        presenter = new WindowsPresenter(this);

        jPanelList = new ArrayList<>();

        LabelInputPanel pathInputPanel = new LabelInputPanel("Путь к файлу : ");

        add(pathInputPanel, BorderLayout.NORTH);

        add(new LabelInputPanel("ST name: "), BorderLayout.NORTH);
        pathInputPanel.getApplyBtn().addActionListener(a -> {
            String filePathRoot = pathInputPanel.getField().getText();
            File questionFile = new File(filePathRoot + "questions.json");
            File answerFile = new File(filePathRoot + "answ.json");
            File resultFile = new File(filePathRoot + "res.txt");

            presenter.setFiles(questionFile, answerFile, resultFile);
            mainPanel = new JPanel(new GridLayout(0, 1));

            scrollPane = new JScrollPane(mainPanel);

            /***/

            List<QuestionPOJO> list = presenter.getQuestionList();
            answerList = presenter.getAnswerList();
            for (QuestionPOJO questionListPOJO : list) {
                mainPanel.add(new QuestionPanel(questionListPOJO));
            }


            add(scrollPane);
            submitButton = new JButton("Submit");
            submitButton.addActionListener(this);
            add(submitButton, BorderLayout.SOUTH);

            this.validate();
            this.repaint();
        });


    }



    private void initComponents() {
        File questionFile = new File(pathToQuestion);
        File answerFile = new File(pathToAnswer);
        File resultFile = new File(pathToResultFile);

        presenter = new WindowsPresenter(this);
        presenter.setFiles(questionFile, answerFile, resultFile);

        jPanelList = new ArrayList<>();

        labelInputPanel = new LabelInputPanel("Имя студента : ");

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        mainPanel = new JPanel(new GridLayout(0, 1));

        scrollPane = new JScrollPane(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Submit":
                String studentsName = labelInputPanel.getField().getText();
                presenter.calculate(mainPanel, jPanelList, answerList, studentsName);
                submitButton.setEnabled(false);
                break;
            case "":
                break;
        }
    }
}
