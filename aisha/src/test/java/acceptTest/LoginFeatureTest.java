package acceptTest;


import static org.junit.Assert.assertTrue;

import acceptTest.Login.UserInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureTest {

    private Login log = new Login();
    private boolean emailFlag;
    private boolean passwordFlag;
    private boolean isLogged;

    @Given("{string} status log is {int}")
    public void status_log_is(String string, Integer state) {
        // Assuming initialization of userinfo in the Login class
        log.arrayValues();
        if (state == 0) {
            log.isLog = false;
        } else {
            log.isLog = true;
        }
    }

    @Given("the password is {string}")
    public void the_password_is(String passw) {
        log.arrayValues();
        for (UserInfo userInfo : log.userinfo) {
            if (userInfo.getPassword().equals(passw)) {
                passwordFlag = true;
                break;
            }
            
        }
    }

    @Given("the email is {string}")
    public void the_email_is(String email) {
        log.arrayValues();
        for (UserInfo userInfo : log.userinfo) {
            if (userInfo.getEmail().equals(email)) {
                emailFlag = true;
                break;
            }
        }
    }

    @Given("status_log is equal {int}")
    public void status_log_is_equal(Integer state) {
        log.arrayValues();
        if (passwordFlag && emailFlag) {
            state = 1;
            log.isLog = true;
        } else {
            state = 0;
            log.isLog = false;
        }
    }

    @When("press the login button")
    public void press_the_login_button() {
        log.arrayValues();
        if (passwordFlag && emailFlag) {
            log.isLog = true;
        } else {
            log.isLog = false;
        }
    }

    @Then("login success")
    public void login_success() {
        log.arrayValues();
        assertTrue("Login success", log.isLog);
    }
}
