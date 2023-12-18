package manager;

public class Request {
	private String content;
	private boolean signedByDean;
	
	/// empty cons
	
	public Request(String content, boolean signedByDean) {
		this.content = content;
		this.signedByDean = signedByDean;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isSignedByDean() {
		return signedByDean;
	}

	public void setSignedByDean(boolean signedByDean) {
		this.signedByDean = signedByDean;
	}
	
}
