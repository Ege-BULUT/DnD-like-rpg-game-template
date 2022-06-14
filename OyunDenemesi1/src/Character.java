import java.util.Scanner;

public class Character {

    public Interfaces interfaces = new Interfaces();

    public static String Races[] = {"Dragonborn","Dwarf","Elf","Gnome","Half-Elf","Half-Orc","Halfling","Human","Thiefling"};
    public static String Classes[] = {"Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer","Warlock","Wizard"};


    public static Scanner scan = new Scanner(System.in);

    String _name;
    String _class;
    String _race;

    private int _exp;
    private int gold;

    private int _statPoints;

    private int _level;
    private int armor;
    private int _Str;
    private int _Vit;
    private int _Cha;
    //public int Con;
    //public int Dex;
    //public int speed;
    //public int Int;
    //public int Wis;

    public String[] characterInfo = {_name+" "+_level+"lvl  - "+_exp,"","STR: "+_Str,"VIT: "+_Vit,"CHA: "+_Cha};
/*
    //public int Strength;
    //public int Dexterity;
    //public int Constitution;
    //public int Intelligence;
    //public int Wisdom;
    //public int Charisma;

    //public int Acrobatics = 0;
    //public int AnimalHandling = 0;
    //public int Arcana = 0;
    //public int Athletics = 0;
    //public int Deception = 0;
    //public int History = 0;
    //public int Insight = 0;
    //public int Intimidation = 0;
    //public int Investigation = 0;
    //public int Medicine = 0;
    //public int Nature = 0;
    //public int Perception = 0;
    //public int Performance = 0;
    //public int Persuasion = 0;
    //public int Religion = 0;
    //public int SleightOfHand = 0;
    //public int Survival = 0;
*/

    public Character() {}

    public void updateCharacter(int str, int vit, int cha, int statPoints) {
        _Str = str;
        _Vit = vit;
        _Cha = cha;
        _statPoints = statPoints;
    }

    public Character(String Name, String Class, String Race, int level, int str, int vit, int cha, int statPoints){
        _name = Name;
        _class = Class;
        _race = Race;
        _level = level;
        _Str = str;
        _Vit = vit;
        _Cha = cha;
        _statPoints = statPoints;
    }

    public Character(String Name, String Class, String Race) {
        _name = Name;
        _class = Class;
        _race = Race;
    }

    public void levelUp(){
       _exp = 0;
        _level++;
       _statPoints += 3;
    }


    public void getCharacter() {

        interfaces.mesaj_grup(characterInfo);
        //("\n______________________\n\n" + this._name + "'s info :\n Race-> " + this._race + " | Class-> " + this._class + "\n level-> " + this._level + " | Armor-> " + this.armor + "\nStats:" + "\n| Strength-> " + this._Str + "| Vitality-> " + this._Vit + "| Charisma-> " + this._Cha);
    }

    public String getName() {
        return this._name;
    }

    public void setName(int no){
        if(!Interfaces.bugfix){scan.nextLine();}  // bug var
        Interfaces.bugfix = false;               // bugfix
        Interfaces.bugfix2 = false;              // bugfix
        System.out.println("Karakterin yeni tam adını gir");
        String newName = scan.nextLine();
        _name = newName;
    }



    /*      ### Getters and Setters Area ###        */

    public int get_exp() {return _exp;}
    public int getGold() {return gold;}
    public int get_Str() {return _Str;}
    public int get_Vit() {return _Vit;}
    public int get_Cha() {return _Cha;}
    public int get_level() {return _level;}
    public String get_race() {return _race;}
    public String get_class() {return _class;}
    public int get_statPoints() {return _statPoints;}
    public void set_exp(int _exp) {this._exp = _exp;}
    public void setGold(int gold) {this.gold = gold;}
    public void set_Str(int _Str) {this._Str = _Str;}
    public void set_Vit(int _Vit) {this._Vit = _Vit;}
    public void set_Cha(int _Cha) {this._Cha = _Cha;}
    public void setArmor(int armor) {this.armor = armor;}
    public void set_race(String _race) {this._race = _race;}
    public void set_name(String _name) {this._name = _name;}
    public void set_level(int _level) {this._level = _level;}
    public void set_class(String _class) {this._class = _class;}
    public void set_statPoints(int _statPoints) {this._statPoints = _statPoints;}

}
