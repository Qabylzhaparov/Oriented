package fromUser;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Message {
    private List<String> messageHistory; 
    private static Integer ID = 0; 
    private Date DateOfSend;
    private String Text;
    private User Author;
    private int receiverid;
    private MessageType Category;
    private StatusType Status;
    private UrgencyLevel UrgencyLevel;

    {
        ID++; // Increment ID
    }

    // Default constructor
    public Message() {
        
    }

    // Constructor with parameters
    public Message(String text, User author, int receiverid, MessageType category,
                   StatusType status, UrgencyLevel urgencyLevel) {
        this.DateOfSend = new Date();
        this.Text = text;
        this.Author = author;
        this.receiverid = receiverid;
        this.Category = category;
        this.Status = status;
        this.UrgencyLevel = urgencyLevel;
    }

    // Getters and setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        Message.ID = ID;
    }

   

    public void setCategory(MessageType category) {
        this.Category = category;
    }

    // Method to show messages of high urgency
    public List<String> showHighUrgencyMessages() {
        return messageHistory.stream()
                .filter(msg -> msg.startsWith("HIGH"))
                .collect(Collectors.toList());
    }

  
}
