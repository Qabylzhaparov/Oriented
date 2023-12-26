package fromUser;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Message class represents a communication message within the educational institution management system.
 * It contains information about the message history, ID, date of send, text, author, receiver ID, category,
 * status, and urgency level.

 */
public class Message {

    // List to store the message history
    private List<String> messageHistory;

    // Static ID counter for unique identification
    private static Integer ID = 0;

    // Date when the message is sent
    private Date DateOfSend;

    // Text content of the message
    private String Text;

    // Author of the message
    private User Author;

    // Receiver ID of the message
    private int receiverId;

    // Category of the message (e.g., REQUEST, ANNOUNCEMENT)
    private MessageType Category;

    // Status of the message (e.g., PENDING, APPROVED, REJECTED)
    private StatusType Status;

    // Urgency level of the message (e.g., LOW, MEDIUM, HIGH)
    private UrgencyLevel UrgencyLevel;

    // Initialization block to increment ID
    {
        ID++;
    }

    // Default constructor
    public Message() {
    }

    /**
     * Constructor with parameters to create a new Message object.
     *
     * @param text         The text content of the message.
     * @param author       The author of the message.
     * @param receiverId   The receiver ID of the message.
     * @param category     The category of the message.
     * @param status       The status of the message.
     * @param urgencyLevel The urgency level of the message.
     */
    public Message(String text, User author, int receiverId, MessageType category,
                   StatusType status, UrgencyLevel urgencyLevel) {
        this.DateOfSend = new Date();
        this.Text = text;
        this.Author = author;
        this.receiverId = receiverId;
        this.Category = category;
        this.Status = status;
        this.UrgencyLevel = urgencyLevel;
    }

    /**
     * Gets the unique ID of the message.
     *
     * @return The unique ID of the message.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Sets the unique ID of the message.
     *
     * @param ID The unique ID to be set.
     */
    public void setID(Integer ID) {
        Message.ID = ID;
    }

    /**
     * Gets the receiver ID of the message.
     *
     * @return The receiver ID of the message.
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     * Sets the category of the message.
     *
     * @param category The category to be set.
     */
    public void setCategory(MessageType category) {
        this.Category = category;
    }

    /**
     * Method to show messages of high urgency from the message history.
     *
     * @return List of high urgency messages.
     */
    public List<String> showHighUrgencyMessages() {
        return messageHistory.stream()
                .filter(msg -> msg.startsWith("HIGH"))
                .collect(Collectors.toList());
    }
}
