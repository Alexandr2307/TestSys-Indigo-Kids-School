package repo;

import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;
import view.MainContract;

import java.util.List;

public class Repository implements MainContract.Repository {

    private MainContract.Repository repository;

    public Repository(MainContract.Repository repository) {
        this.repository = repository;

    }
    @Override
    public List<QuestionPOJO> getAllQuestions() {
        return repository.getAllQuestions();
    }
}
