package client.shipping;

// Bara fyrir JSON shipping á boolean breytu.
// Ágætt að hafa ef við viljum bæta við t.d. expiration time.
public class TokenInfo {
	private boolean isValid;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValidity(boolean validity) {
		this.isValid = validity;
	}
}
