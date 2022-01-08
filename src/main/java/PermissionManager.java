enum PermissionLevel{
    ADMIN,
    DEVELOPER,
    USER
}
// hi
public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel(PermissionLevel pLevel){
        if (pLevel == PermissionLevel.ADMIN){
            return "Admin";
        }
        if (pLevel == PermissionLevel.DEVELOPER){
            return "Developer";
        }
        if (pLevel == PermissionLevel.USER){
            return "User";
        }
        return "EMPTY";
    }

    private void setPermissionLevel(PermissionLevel pLevel){
        mCurrentLevel = pLevel;
    }

    public static void main(String[] args) {
        PermissionManager pmanager = new PermissionManager();
        System.out.println(pmanager.getPermissionLevel(pmanager.mCurrentLevel));
        pmanager.setPermissionLevel(PermissionLevel.ADMIN);
        System.out.println(pmanager.getPermissionLevel(pmanager.mCurrentLevel));
    }



}
