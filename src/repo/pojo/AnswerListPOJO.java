package repo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnswerListPOJO {
    @SerializedName("answer_list")
    @Expose
    private List<AnswerPOJO> answerListPOJO = null;

    public List<AnswerPOJO> getAnswerListPOJO() {
        return answerListPOJO;
    }

    public void setAnswerListPOJO(List<AnswerPOJO> answerListPOJO) {
        this.answerListPOJO = answerListPOJO;
    }

}
