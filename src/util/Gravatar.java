package util;

public class Gravatar {
	//private static String gravatarUrl;
	
	public Gravatar(){
		
	}
//	public static  String setGravatarUser(User user, int size) {
//		// TODO Auto-generated method stub
//		String email=user.getEmail();
//		return "https://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "=" + size;
//	}
	public static  String setGravatarURL(String  email, int size) {
		// TODO Auto-generated method stub
		return "https://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "=" + size;
	}
}
