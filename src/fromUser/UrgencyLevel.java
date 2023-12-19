package fromUser;

public enum UrgencyLevel {
	LOW, MED, HIGH;

	public static UrgencyLevel fromString(String str) {
		switch (str.toUpperCase()) {
        case "LOW":
            return LOW;
        case "MED":
            return MED;
        case "HIGH":
            return HIGH;
        default:
            throw new IllegalArgumentException("Invalid urgency level: " + str);
    }
	}

	
}
