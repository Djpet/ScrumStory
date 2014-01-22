package fr.scrumsotry.core.exception;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

public class ValidationException extends ScrumStoryException {

	private static final long serialVersionUID = 5966571557562666069L;

	@Getter
	private List<String> listViolations;

	public ValidationException() {
		super(VALIDATION_EXCEPTION);
		listViolations = new LinkedList<>();
	}

	public void add(String violation) {
		listViolations.add(violation);
	}
	
	@Deprecated
	@Override
	public String getMessage() {
		StringBuffer message = new StringBuffer();
		message.append("Number of violation : ").append(listViolations.size());
		for (String violation : listViolations) {
			message.append("\n    - ").append(violation);
		}
		return message.toString();
	}
}
