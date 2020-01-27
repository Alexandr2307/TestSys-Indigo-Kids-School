package controllers;

import repo.pojo.QuestionPOJO;
import repo.repo_types.FileRepository;
import repo.Repository;
import repo.pojo.QuestionListPOJO;
import view.MainContract;

import java.io.File;
import java.util.List;

public class WindowsController implements MainContract.Presenter {

    private Repository repository;

    public WindowsController() {
        File file = new File("/home/alexandr/Документы/questions.json");
        repository = new Repository(new FileRepository(file));
    }

    @Override
    public List<QuestionPOJO> getQuestionList() {
        return repository.getAllQuestions();
    }

    @Override
    public void calculate() {

    }
}
