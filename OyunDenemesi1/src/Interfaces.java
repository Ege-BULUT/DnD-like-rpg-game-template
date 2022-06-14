import java.util.Scanner;
public class Interfaces {

    public static Main main = new Main();
    public static Arena arena = new Arena();
    public static Character player = new Character();
    public static Scanner scan = new Scanner(System.in);
    public static boolean bugfix2 = true; //2. zar atımında null
    public static boolean bugfix = true; //2. karakter yaratımda null

    public static String Menu[] = {"     [ MENU ]","","1. [Yeni Oyun]","2. [Devam]"};
    public static String stats[]={"       [ STAT TABLOSU ]","","","1. [Str]: " + player.get_Str(),"2. [Vit]: " + player.get_Vit(),"3. [Cha]: " + player.get_Cha(),"","","5. [Menu]"};
    public static String Races[] = {"Hatalı Seçim","Dragonborn","Dwarf","Elf","Gnome","Half-Elf","Half-Orc","Halfling","Human","Thiefling"};
    public static String Classes[] = {"Hatalı Seçim","Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer","Warlock","Wizard"};
    public static String oyunMenu[];

    public void giris() throws InterruptedException{
        System.out.println("\n\n\n");

        mesaj_grup(Menu,2);
        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                bugfix=false;
                characterCreate();
            break;
            case 2:
                oyunMenu();
            break;
            default:
                System.out.print("Hatalı seçim");
                Thread.sleep(800);
                giris();
        }
    }

    public void oyunMenu() throws InterruptedException {
        System.out.println("\n\n\n");
        if(player.getName() == null){
            System.out.println("\nÖnce karakter yarat.");
            Thread.sleep(1000);
            giris();
        }
        else {
            mesaj_grup(oyunMenu,2);
            System.out.println("(Seçimin başındaki numarayı gir)");
            switch(scan.nextInt()){
                case 0:
                    giris();
                    break;
                case 1:
                    enterArena(player);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    player.getCharacter();
                    break;
            }
        }
    }

    public static void enterArena(Character player){

    }



    public static void logo() throws InterruptedException{
        int time = 75;
        System.out.println("\n\n");
        String logo[]={"O","y","u","n"," ","D","e","n","e","m","e","s","i","1"};
        for(int i = 0; i < logo.length; i++){
            System.out.print(logo[i]);
            Thread.sleep(100);                                  // WORK SMART
            System.out.print(" ");
        }
    }
    public static void mesaj(String msg) throws InterruptedException {mesaj(msg,false,1);}
    public static void mesaj(String msg, boolean efekt) throws InterruptedException {mesaj(msg,efekt,1);}
    public static void mesaj(String msg, boolean efekt, int type) throws InterruptedException {
        int time = 75-msg.length(); if(time < 10 ){time = 20;}
        System.out.println("\n");
        if(type == 1) {}
            System.out.print("┌"); if(efekt){Thread.sleep(time);} for(int i=-2; i<msg.length(); i++) {System.out.print("─");if(efekt){Thread.sleep(time);}} System.out.print("┐");
            System.out.print("\n│ "); if(efekt){Thread.sleep(time);} System.out.print(msg); if(efekt){Thread.sleep(time);} System.out.print(" │");
            System.out.print("\n└"); if(efekt){Thread.sleep(time);} for(int i=-2; i<msg.length(); i++) {System.out.print("─");if(efekt){Thread.sleep(time);}} System.out.print("┘\n");

        if(type == 2){
            System.out.print("╔"); if(efekt){Thread.sleep(time);} for(int i=-2; i<msg.length(); i++) {System.out.print("═");if(efekt){Thread.sleep(time);}} System.out.print("╗");
            System.out.print("\n║ "); if(efekt){Thread.sleep(time);} System.out.print(msg); if(efekt){Thread.sleep(time);} System.out.print(" ║");
            System.out.print("\n╚"); if(efekt){Thread.sleep(time);} for(int i=-2; i<msg.length(); i++) {System.out.print("═");if(efekt){Thread.sleep(time);}} System.out.print("╝\n");
        }

    }

    public static void mesaj_grup(String msg[]){mesaj_grup(msg,1);}
    public static void mesaj_grup(String msg[], int type){
        int longestWord = msg[0].length();
        for(int i = 1; i<msg.length;i++){if(msg[i].length()>longestWord){longestWord=msg[i].length();}}
        int boxWidth = longestWord+10;
        if(type == 1){
            System.out.print("┌");for(int i=-2; i<boxWidth; i++) {System.out.print("─");} System.out.print("┐");
            for(int i = 0; i<msg.length; i++){System.out.print("\n│ "); System.out.print(msg[i]); for(int s=0; s<boxWidth-msg[i].length(); s++){System.out.print(" ");}System.out.print(" │");}
            System.out.print("\n└");for(int i=-2; i<boxWidth; i++) {System.out.print("─");} System.out.print("┘\n");
        }
       if(type == 2){
           System.out.print("╔");for(int i=-2; i<boxWidth; i++) {System.out.print("═");} System.out.print("╗");
           for(int i = 0; i<msg.length; i++){System.out.print("\n║ "); System.out.print(msg[i]); for(int s=0; s<boxWidth-msg[i].length(); s++){System.out.print(" ");}System.out.print(" ║");}
           System.out.print("\n╚");for(int i=-2; i<boxWidth; i++) {System.out.print("═");} System.out.print("╝\n");
       }
       else if (type < 1 || type > 2){mesaj_grup(msg,1);}
    }

    public static void loading(int dots) throws InterruptedException {
        int time = 50-dots;
        for(int i = 0; i<dots; i++){System.out.print(".");Thread.sleep(time);}
    }

    public void characterCreate()throws InterruptedException{

       mesaj("Karakter yaratma ekranı", true);

        String name = setName();
        System.out.print("\n");
        String race = setRace();
        System.out.print("\n");
        String Class = setClass();

        System.out.println("Karakterin Yaratılıyor");
        loading(20);
        player = new Character(name, Class, race, 1, 1, 1, 1, 5);

        System.out.println("\n"+ player.getName()+" isimli karakterin başarı ile yaratıldı!");

        update();
        setStats();
        System.out.println("karakter özellikleri: ");
        player.getCharacter();
        Thread.sleep(1500);
        //oyunMenu();
    }

    public static String setName(){
        System.out.println("__________________________\n\nKarakterin tam adını gir: ");
        if(!bugfix){scan.nextLine();}  // bug var
        bugfix = false;               // bugfix
        bugfix2 = false;              // bugfix

        String name = scan.nextLine();
        return name;
    }

    public static String setRace(){

        System.out.println("Karakterinin Irkını seç");
        for(int i=1; i<Races.length; i++) { System.out.println(i+". "+Races[i]); }
        int secim = scan.nextInt();
        //System.out.println(Races[secim]);
        return Races[secim];
    }

    public static String setClass(){

        System.out.println("Karakterinin classını seç");
        for(int i=1; i<Classes.length; i++) { System.out.println(i+". "+Classes[i]); }
        int secim = scan.nextInt();
        //System.out.println(Classes[secim]);
        return Classes[secim];
    }

    public void setStats() throws InterruptedException {
        System.out.println("__________\nStat Points : "+player.get_statPoints());
        mesaj_grup(stats,1);
        if(player.get_statPoints()>0) {
            System.out.println("İstediğin statın numarasını gir, arttırmak için +, azaltmak için - ekle.");
            String stat = scan.next();
            System.out.println("Input = " + stat);
            String[] arrOfStr = stat.split("");
            System.out.println("array of input : ");
            for(int i = 0; i<arrOfStr.length;i++){System.out.println(arrOfStr[i]);}
            if (arrOfStr[1] == "+") {
                switch (arrOfStr[0]) {
                    case "1":
                        player.updateCharacter(player.get_Str()+1, player.get_Vit(), player.get_Cha(), player.get_statPoints() - 1);
                        update();
                        break;
                    case "2":
                        player.updateCharacter(player.get_Str(),player.get_Vit()+1, player.get_Cha(), player.get_statPoints() - 1);
                        update();
                        break;
                    case "3":
                        player.updateCharacter(player.get_Str(), player.get_Vit(), player.get_Cha() + 1, player.get_statPoints() - 1);
                        update();
                        break;
                    default:
                        System.out.println("Hatalı seçim");
                        Thread.sleep(1500);
                        setStats();
                        break;
                }

            } else if (arrOfStr[1] == "-") {
                switch (arrOfStr[0]) {
                    case "1":
                        if (player.get_Str() > 0) {
                            player.updateCharacter(player.get_Str()-1, player.get_Vit(), player.get_Cha(), player.get_statPoints()+1);
                            update();
                        } else System.out.println("Statı daha fazla azaltamazsın!");
                        break;
                    case "2":
                        if (player.get_Vit() > 0) {
                            player.updateCharacter(player.get_Str(), player.get_Vit()-1, player.get_Cha(), player.get_statPoints()+1);
                            update();
                        } else System.out.println("Statı daha fazla azaltamazsın!");
                        break;
                    case "3":
                        if (player.get_Cha() > 0) {
                            player.updateCharacter(player.get_Str(), player.get_Vit(), player.get_Cha()-1, player.get_statPoints()+1);
                            update();
                        } else System.out.println("Statı daha fazla azaltamazsın!");
                        break;
                    default:
                        System.out.println("Hatalı seçim");
                        Thread.sleep(1500);
                        setStats();
                        break;
                }
            }
            update();
        }
        else {Thread.sleep(1500); oyunMenu();}
    }

    public static void update(){
        oyunMenu = new String[]{player.getName()+"  |  "+ player.get_level() +"lvl  | Gold: "+ player.getGold(),"","","","1. [ Arena ]","2. [ Yaratık Avı ]","3. [ Dükkan ]","4. [ Envanter ]","5. [ Karakter Bilgisi ]","","0. [ Ana Menü ]"};
        stats = new String[]{"       [ STAT TABLOSU ]","","","1. [Str]: " + player.get_Str(),"2. [Vit]: " + player.get_Vit(),"3. [Cha]: " + player.get_Cha(),"","","5. [Menu]"};
    }

}