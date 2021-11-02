package Exception;

import java.io.IOException;

public class DBManagerException extends Exception {

	private static final long serialVersionUID = -8728538619836179905L;

	public DBManagerException(IOException e) {
	}

	public DBManagerException(String message) {
		super(message);
	}

	public DBManagerException(Throwable cause) {
		super(cause);
	}

	public DBManagerException(String message, Throwable cause) {
		super(message, cause);
	}
}
