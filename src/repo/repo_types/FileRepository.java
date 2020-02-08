package repo.repo_types;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import other.FileHelper;
import repo.pojo.AnswerListPOJO;
import repo.pojo.AnswerPOJO;
import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;
import other.MainContract;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * todo переделать, нужно чтобы класс возвращал строку, а json парсил другой класс
 * */

public class FileRepository implements MainContract.Repository {

    private File answerFile;
    private File questionFile;
    private File resultFile;

    public FileRepository(File answerFile, File questionFile, File resultFile) {
        this.answerFile = answerFile;
        this.questionFile = questionFile;
        this.resultFile = resultFile;
    }



    @Override
    public List<QuestionPOJO> loadQuestions() {
        try {
            FileReader reader = new FileReader(answerFile);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(reader);
            String json = "";
            if (object != null) {
                json = object.toJSONString();
            }
            Gson gson = new Gson();
            QuestionListPOJO listPOJO = gson.fromJson(json, QuestionListPOJO.class);
            reader.close();
            return listPOJO.getQuestionPOJO();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void writeAnswer(String content) {
        FileHelper.writeToFile(content, resultFile);
    }

    @Override
    public List<AnswerPOJO> loadAnswers() {
        try {
            FileReader reader = new FileReader(questionFile);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(reader);
            String json = "";
            if (object != null) {
                json = object.toJSONString();
            }
            Gson gson = new Gson();
            AnswerListPOJO listPOJO = gson.fromJson(json, AnswerListPOJO.class);
            reader.close();
            return listPOJO.getAnswerListPOJO();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
