package repo.repo_types;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import repo.pojo.QuestionListPOJO;
import repo.pojo.QuestionPOJO;
import view.MainContract;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * todo переделать, нужно чтобы класс возвращал строку, а json парсил другой класс
 * */

public class FileRepository implements MainContract.Repository {

    private File file;

    public FileRepository(File file) {
        this.file = file;
    }

    @Override
    public List<QuestionPOJO> getAllQuestions() {
        try {
            FileReader reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(reader);
            String json = "";
            if (object != null) {
                json = object.toJSONString();
            }
            Gson gson = new Gson();
            QuestionListPOJO listPOJO = gson.fromJson(json, QuestionListPOJO.class);
            return listPOJO.getQuestionPOJO();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
