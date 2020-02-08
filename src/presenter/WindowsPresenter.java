package presenter;

import other.FileHelper;
import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionPOJO;
import repo.repo_types.FileRepository;
import repo.Repository;
import other.MainContract;
import view.frames.QuestionPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class WindowsPresenter implements MainContract.Presenter {

    private Repository repository;
    private MainContract.View view;
    public WindowsPresenter(MainContract.View view) {
        //File file = new File("/home/alexandr/Документы/questions.json");
        this.view = view;
    }

    @Override
    public List<QuestionPOJO> getQuestionList() {
        return repository.loadQuestions();
    }

    @Override
    public List<AnswerPOJO> getAnswerList() {
        return repository.loadAnswers();
    }

    @Override
    public void calculate(JPanel mainPanel,
                          List<QuestionPanel> jPanelList,
                          List<AnswerPOJO> answerList,
                          String studentsName) {
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
        //FileHelper.writeToFile(studentsName + " \n Score : " + res, new File("C:\Users\User\Download\res.txt"));
        writeResult(studentsName + " \nScore: " + res);
    }

    @Override
    public void writeResult(String content) {
        repository.writeAnswer(content);
    }

    @Override
    public void setFiles(File questionFile, File answerFile, File resultFile) {
        repository = new Repository(new FileRepository(questionFile, answerFile, resultFile));
        int i = 0;
    }
}
