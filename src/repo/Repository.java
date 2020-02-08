package repo;

import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionPOJO;
import other.MainContract;

import java.util.List;

public class Repository implements MainContract.Repository {

    private MainContract.Repository repository;

    public Repository(MainContract.Repository repository) {
        this.repository = repository;

    }
    @Override
    public List<QuestionPOJO> loadQuestions() {
        return repository.loadQuestions();
    }

    @Override
    public List<AnswerPOJO> loadAnswers() {
        return repository.loadAnswers();
    }

    @Override
    public void writeAnswer(String content) {
        repository.writeAnswer(content);
    }
}
