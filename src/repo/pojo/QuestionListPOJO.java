package repo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionListPOJO {

    @SerializedName("question_list")
    @Expose
    private List<QuestionPOJO> questionPOJO = null;

    public List<QuestionPOJO> getQuestionPOJO() {
        return questionPOJO;
    }

    public void setQuestionPOJO(List<QuestionPOJO> questionPOJO) {
        this.questionPOJO = questionPOJO;
    }}
