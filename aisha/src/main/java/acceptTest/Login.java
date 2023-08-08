package acceptTest;

import java.util.ArrayList;
import java.util.List;

public class Login {
    public Object username;
    public Object email;
    public Object passw;

    public List<UserInfo> userinfo;
    public boolean isLog;

    public Login() {
        userinfo = new ArrayList<>();
        // Assuming some initial data for userinfo
        userinfo.add(new UserInfo("aishaishtayeh112@gmail.com", "2002","Aisha"));
        userinfo.add(new UserInfo("areesnobani@gmail.com", "2003","Arees"));
        userinfo.add(new UserInfo("tala@gmail.com", "2005","Tala"));
        userinfo.add(new UserInfo("rozmalter@gmail.com", "2000","roz"));
        userinfo.add(new UserInfo("alexsmith@gmail.com", "2001","alex"));
        userinfo.add(new UserInfo("howyoudoin@gmail.com", "2006","joey"));
        userinfo.add(new UserInfo("rachrach@gmail.com", "2007","Rachel Green"));
        userinfo.add(new UserInfo("chandlermonica@gmail.com", "2008","chandler"));




        
        
        
        
        
        
    }
    public boolean isUserExists(String email, String password) {
        for (UserInfo user : userinfo) {
            if (user.getUseremail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public UserInfo getUserInfoByEmail(String email) {
        for (UserInfo user : userinfo) {
            if (user.getUseremail().equals(email)) {
                return user;
            }
        }
        return null;
    }
    

    public void arrayValues() {
        // Assuming this method is used for some setup or initialization
        // For example, loading user info from a database or external source
    }
    public void setUsername(Object username) {
		return ;
	}
    public Object getUsername() {
		return username;
	}
    
/*
	public Object getPassword() {
		// TODO Auto-generated method stub
		return passw;
	}
	public Object getUseremail() {
		return email;
	}



	public void setPassword(Object passw) {
		// TODO Auto-generated method stub
		return;
	}
	public void setUseremail(Object email ) {
		return ;
	}*/


    public static class UserInfo {
    	private String email;
        private String password;
        private String name;

        public UserInfo(String email, String password,String name) {
            this.setEmail(email);
            this.password = password;
            this.name = name;
        }

        String getUseremail() {
            return getEmail();
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
    }

	public void UserInfo(Object username, Object password) {
		// TODO Auto-generated method stub
		
	}
}
