package Response;

import lombok.Data;

@Data
public class SignupResponse {
	
	private boolean success;
	private String failureReason;
	
	public SignupResponse() {
	}
	
	public SignupResponse(boolean success, String failureReason) {
		this.success = success;
		this.failureReason = failureReason;
	}
	
}
