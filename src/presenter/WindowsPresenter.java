package presenter;

import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionPOJO;
import repo.repo_types.FileRepository;
import repo.Repository;
import view.MainContract;

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
        return repository.getAllQuestions();
    }

    @Override
    public List<AnswerPOJO> getAnswerList() {
        return repository.getAllAnswer();
    }

    @Override
    public void calculate() {

    }

    @Override
    public void setFiles(File questionFile, File answerFile) {
        repository = new Repository(new FileRepository(questionFile, answerFile));
    }
}
