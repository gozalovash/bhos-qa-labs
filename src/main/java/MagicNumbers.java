class Wizards {
    String wName;
    String wPasswd;

    public void setwName(String name){
        wName = name;
    }
    public String getwName(){
        return wName;
    }
    public void setwPasswd(String passw){
        wPasswd = passw;
    }
    public String getwPasswd(){
        return wPasswd;
    }

    public static void main(String[] args) {
        Wizards wizard = new Wizards();
        wizard.setwName("Hermione");
        wizard.setwPasswd("Leviosa");
        System.out.println(wizard.getwName());
        System.out.println(wizard.getwPasswd());
    }
}
