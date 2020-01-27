package repo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionPOJO {
    @SerializedName("questionName")
    @Expose
    private String questionName;
    @SerializedName("firstVariant")
    @Expose
    private String firstVariant;
    @SerializedName("secondVariant")
    @Expose
    private String secondVariant;
    @SerializedName("thirdVariant")
    @Expose
    private String thirdVariant;
    @SerializedName("fourthVariant")
    @Expose
    private String fourthVariant;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getFirstVariant() {
        return firstVariant;
    }

    public void setFirstVariant(String firstVariant) {
        this.firstVariant = firstVariant;
    }

    public String getSecondVariant() {
        return secondVariant;
    }

    public void setSecondVariant(String secondVariant) {
        this.secondVariant = secondVariant;
    }

    public String getThirdVariant() {
        return thirdVariant;
    }

    public void setThirdVariant(String thirdVariant) {
        this.thirdVariant = thirdVariant;
    }

    public String getFourthVariant() {
        return fourthVariant;
    }

    public void setFourthVariant(String fourthVariant) {
        this.fourthVariant = fourthVariant;
    }
}
