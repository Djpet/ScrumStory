package fr.scrumstory.tools;

import fr.scrumstory.core.exception.ScrumStoryException;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Matcher pour le test d'
 */
public class ScrumStoryExceptionMatcher extends TypeSafeMatcher<ScrumStoryException> {

    private String expectedCode;
    private String actualCode;

    public ScrumStoryExceptionMatcher(String expectedCode) {
        this.expectedCode = expectedCode;
    }

    public static Matcher<ScrumStoryException> hasCode(String expectedCode) {
        return new ScrumStoryExceptionMatcher(expectedCode);
    }

    @Override
    protected boolean matchesSafely(ScrumStoryException item) {
        actualCode = item.getCode();
        return expectedCode.equals(item.getCode());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(expectedCode).appendText(" but was : ").appendText(actualCode);
    }

}
