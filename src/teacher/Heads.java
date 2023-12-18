package teacher;
import java.util.Vector;

import fromUser.Message;

public interface Heads {
    public Vector<String> getSchoolReports();
    public void signToRequest(Message message);
}
