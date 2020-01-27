package view;

import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;

import java.io.File;
import java.util.List;

public interface MainContract {

    interface View {
    }

    interface Presenter {
        List<QuestionPOJO> getQuestionList();
        List<AnswerPOJO> getAnswerList();
        void calculate();
        void setFiles(File questionFile, File answerFile);


    }

    interface Repository {
        List<QuestionPOJO> getAllQuestions();
        List<AnswerPOJO> getAllAnswer();
    }

}
