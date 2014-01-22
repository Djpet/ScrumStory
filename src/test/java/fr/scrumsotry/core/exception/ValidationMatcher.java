package fr.scrumsotry.core.exception;

import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ValidationMatcher extends TypeSafeMatcher<ValidationException> {

	private List<String> expectedViolations;
	private List<String> actualViolations;
	private StringBuffer stringBuffer;

	public ValidationMatcher() {
		expectedViolations = new LinkedList<>();
		stringBuffer = new StringBuffer();
	}

	public void addViolation(String violation) {
		expectedViolations.add(violation);
	}

	@Override
	protected boolean matchesSafely(ValidationException item) {
		// TODO Auto-generated method stub
		actualViolations = item.getListViolations();

		if (expectedViolations.size() != actualViolations.size()) {
			stringBuffer.append("Number violation incorrect : excepted=")
					.append(expectedViolations.size()).append(" actual=")
					.append(actualViolations.size());
			return false;
		}

		for (String expectedViolation : expectedViolations) {
			if (!actualViolations.contains(expectedViolation)) {
				stringBuffer.append("The expected violation '")
						.append(expectedViolation).append("' not found");
				return false;
			}
		}
		return true;
	}
	@Override
	public void describeTo(Description description) {
		stringBuffer.append(" : \nExpected violation : ");
		for (String expectedViolation : expectedViolations) {
			stringBuffer.append("\n    - ").append(expectedViolation);
		}
		description.appendText(stringBuffer.toString());
	}


}
