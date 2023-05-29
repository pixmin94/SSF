import java.io.Serializable;
import com.google.gson.JsonObject;
import jakarta.json.JsonNumber;

public class Rulebook implements Serializable{
    private int total_count;
    private String file;

    public int getTotal_count() {
        return total_count;
    }
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }

    public static Type createJson(JsonObject o){
        Rulebook r = new Rulebook();
        JsonNumber totalCount = o.getJsonNumber("total_count");
        r.setTotal_count(totalCount.intValue());
        r.setFile(o.getString("file"));
    }
    
}
