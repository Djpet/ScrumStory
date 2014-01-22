package fr.scrumsotry.core.exception;

import lombok.Getter;
import lombok.Setter;

public class ScrumStoryException extends RuntimeException {
	
	public static final String DEFAULT_EXCEPTION = "0";
	public static final String VALIDATION_EXCEPTION = "1";
	

	private static final long serialVersionUID = 5472444143402391996L;
	
	@Getter @Setter
	private String code;

	public ScrumStoryException(String code) {
		super();
		this.code = code;
	}
	
	public ScrumStoryException(String code, String message) {
		super(message);
		this.code = code;
	}

	public ScrumStoryException(String code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
	}
}
