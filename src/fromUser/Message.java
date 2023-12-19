package fromUser;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Message{
	private List<String> messageHistory;     /// eto dolzho byt' v DB
	private Integer ID;
    private Date DateOfSend;
    private String Text;
    private User Author;
    private MessageType Category;
    private StatusType Status;
    private UrgencyLevel UrgencyLevel;     /// kishi arip

    {
    	ID++;                            /// initil. block           
    }
    
    public Message() {
    	
    }
    
    /// constr with text, status, urgencyLevel(kak ya pokazal)
    
    public Message(String text, User author, MessageType category,
    		UrgencyLevel urgencyLevel) {
		super();
		DateOfSend = new Date();
		Text = text;
		Author = author;
		Category = category;
		Status = status;
		UrgencyLevel = urgencyLevel;
	}

	public boolean addMessage(Message m) {
    	messageHistory.addAll(messageHistory);         /// v DB dolzhen hranit'
	    return true;                                   

    	
    }

	public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDateOfSend() {
        return this.DateOfSend;
    }

    public void setDateOfSend(Date DateOfSend) {
        this.DateOfSend = DateOfSend;
    }

    public String getText() {
        return this.Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public User getAuthor() {
        return this.Author;
    }

    public void setAuthor(User Author) {
        this.Author = Author;
    }

    public String getCategory() {
        return this.Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public StatusType getStatus() {
        return this.Status;
    }

    public void setStatus(StatusType Status) {
        this.Status = Status;
    }

    public UrgencyLevel getUrgencyLevel() {
        return this.UrgencyLevel;
    }

    public void setUrgencyLevel(UrgencyLevel UrgencyLevel) {
        this.UrgencyLevel = UrgencyLevel;
    }

    public double calculateRating() {
        return 0.0;
    }

    public List<String> showMessage() {
        List<String> result = Arrays.stream(UrgencyLevel.values())
                .filter(urgencyLevel -> urgencyLevel.name().startsWith("HIGH"))
                .map(Enum::name)
                .collect(Collectors.toList());
        return result;
    }
    


}