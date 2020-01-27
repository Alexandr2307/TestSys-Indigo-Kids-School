package view;

import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;

import java.util.List;

public interface MainContract {

    interface View {

    }

    interface Presenter {
        List<QuestionPOJO> getQuestionList();
        void calculate();

    }

    interface Repository {
        List<QuestionPOJO> getAllQuestions();
    }

}
