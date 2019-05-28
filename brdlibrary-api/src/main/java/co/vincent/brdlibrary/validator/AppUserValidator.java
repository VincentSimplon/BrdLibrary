package co.vincent.brdlibrary.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.service.AppUserService;

@Component
public class AppUserValidator implements Validator {
    @Autowired
    private AppUserService appUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AppUser appUser = (AppUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (appUser.getUsername().length() < 6 || appUser.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (appUserService.findByUsername(appUser.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (appUser.getPassword().length() < 8 || appUser.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!appUser.getPasswordConfirm().equals(appUser.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

	public void validate(AppUser userForm) {
		// TODO Auto-generated method stub
		
	}
}