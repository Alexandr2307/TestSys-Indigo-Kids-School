package other;

import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;
import view.frames.QuestionPanel;

import javax.swing.*;
import java.io.File;
import java.util.List;

public interface MainContract {

    interface View {
    }

    interface Presenter {
        List<QuestionPOJO> getQuestionList();
        List<AnswerPOJO> getAnswerList();
        void calculate(JPanel mainPanel,
                       List<QuestionPanel> jPanelList,
                       List<AnswerPOJO> answerList,
                       String studentsName);
        void setFiles(File questionFile, File answerFile, File resultFile);
        void writeResult(String result);


    }

    interface Repository {
        List<QuestionPOJO> loadQuestions();
        List<AnswerPOJO> loadAnswers();
        void writeAnswer(String content);
    }

}
