enum PermissionLevel{
    ADMIN,
    DEVELOPER,
    USER
}

public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel(){
        if (mCurrentLevel == PermissionLevel.ADMIN){
            return "Admin";
        }
        if (mCurrentLevel == PermissionLevel.DEVELOPER){
            return "Developer";
        }
        if (mCurrentLevel == PermissionLevel.USER){
            return "User";
        }
        return "EMPTY";
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
