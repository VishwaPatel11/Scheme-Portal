import java.util.HashMap;

public class Password_Id {
    HashMap<String,String> map = new HashMap<String, String>();
    Password_Id()
    {
        map.put("kunj", "first");
        map.put("robert", "first");
    }


    protected HashMap returnMap()
    {
        return map;
    }
}
