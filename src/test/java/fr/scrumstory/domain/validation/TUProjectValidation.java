package fr.scrumstory.domain.validation;

import org.junit.Test;

import fr.scrumstory.domain.Project;

public class TUProjectValidation extends AbstractValidationTest {

	@Test
	public void validProject() {
		Project project = new Project();
		project.setCode("code");
		project.setName("name");
		project.setDescription("description");

		validatorBean.validate(project);
	}
	
	@Test
	public void violationNullMadatoryFields() {
		Project project = new Project();
		project.setCode(null);
		project.setName(null);
		project.setDescription(null);

		validationMatcher.addViolation("project.code.mandatory");
		validationMatcher.addViolation("project.name.mandatory");
		validationMatcher.addViolation("project.description.mandatory");

		assertException.expect(validationMatcher);

		validatorBean.validate(project);
	}

	@Test
	public void violationBlankMadatoryFields() {
		Project project = new Project();
		project.setCode(" ");
		project.setName(" ");
		project.setDescription(" ");

		validationMatcher.addViolation("project.code.mandatory");
		validationMatcher.addViolation("project.name.mandatory");
		validationMatcher.addViolation("project.description.mandatory");

		assertException.expect(validationMatcher);

		validatorBean.validate(project);
	}
}
