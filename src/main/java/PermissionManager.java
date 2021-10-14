enum PermissionLevel{
    ADMIN,
    DEVELOPER,
    USER
}

public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel(){
        String clevel = "";
        if (mCurrentLevel == PermissionLevel.ADMIN){
            clevel = "Admin";
        }
        if (mCurrentLevel == PermissionLevel.DEVELOPER){
            clevel = "Developer";
        }
        if (mCurrentLevel == PermissionLevel.USER){
            clevel = "User";
        }
        return clevel;
    }

    public void setPermissionLevel(PermissionLevel pLevel){
        mCurrentLevel = pLevel;
    }

    public static void main(String[] args) {
        PermissionManager pmanager = new PermissionManager();
        System.out.println(pmanager.getPermissionLevel());
        pmanager.setPermissionLevel(PermissionLevel.ADMIN);
        System.out.println(pmanager.getPermissionLevel());
    }



}
