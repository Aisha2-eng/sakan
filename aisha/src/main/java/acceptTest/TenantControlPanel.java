
package acceptTest;
public class TenantControlPanel {

    private boolean isLoggedIn = false;

    public void login() {
        // Simulate the login process
        isLoggedIn = true;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean updatePersonalInformation(String newInfo) {
        // Simulate updating personal information and return whether changes were saved
        if (isLoggedIn) {
            // Simulate successful changes saving
            return true;
        } else {
            // Not logged in, changes couldn't be saved
            return false;
        }
    }
}