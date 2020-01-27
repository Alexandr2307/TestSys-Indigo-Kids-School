package repo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerPOJO {
    @SerializedName("first")
    @Expose
    private boolean first;
    @SerializedName("second")
    @Expose
    private boolean second;
    @SerializedName("third")
    @Expose
    private boolean third;
    @SerializedName("fourth")
    @Expose
    private boolean fourth;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public boolean isThird() {
        return third;
    }

    public void setThird(boolean third) {
        this.third = third;
    }

    public boolean isFourth() {
        return fourth;
    }

    public void setFourth(boolean fourth) {
        this.fourth = fourth;
    }


}
