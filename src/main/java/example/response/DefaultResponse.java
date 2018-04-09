package example.response;

import lombok.Data;

@Data
public class DefaultResponse {
	
	private boolean success;
	private String failureReason;
	
	public DefaultResponse() {
	}
	
	public DefaultResponse(boolean success, String failureReason) {
		this.success = success;
		this.failureReason = failureReason;
	}
	
}
