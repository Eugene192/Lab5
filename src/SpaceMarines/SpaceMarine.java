package SpaceMarines;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static SpaceMarines.JustScanner.Scan;

/**
 * This is the collection class that we collect in this program.
 * */

public class SpaceMarine implements Serializable{ //разбор на байты и сбор обратно
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    private LocalDate creationDate = LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    //private java.time.LocalDate creationDateWithoutTime = LocalDate.now(); // Тоже самое что и выше но без время

    private Long health; //Поле может быть null, Значение поля должно быть больше 0
    private Long heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine() {
        this.setChapter();
        this.setId();
        this.setName();
        this.setHealth();
        this.setHeartCount();
        this.setMeleeWeapon();
        System.out.println("SpaceMarine "+ name+" создан");
    }


    private void setChapter(){
        int chapterChoice;
        while(true) {
            try {
                System.out.print("Если хотите добавить Chapter, введите 1 иначе 2: ");
                chapterChoice = Integer.parseInt(Scan());
                if (chapterChoice != 1 && chapterChoice != 2) {
                    System.out.println("Введите 1 или 2!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Надо ввести int!");
            }
        }
        switch (chapterChoice){
            case 1:
                chapter = new Chapter();
                chapter.makeChapter();
                break;
            case 2:
                break;
        }
    }
    private void setMeleeWeapon() {
        while (true) {
            System.out.println("Введите номер оружия ближнего боя");
            System.out.println("1 - POWER_SWORD\n2 - MANREAPER\n3 - LIGHTING_CLAW\n4 - POWER_BLADE");
            try{
                int weaponChoice = Integer.parseInt(Scan());
                if (weaponChoice < 1 || weaponChoice > 4) {
                    System.out.println("Вы указали неправильный номер! Проверьте и введите еще раз");
                }

                else {
                    switch (weaponChoice) {
                        case 1 ->
                            meleeWeapon = MeleeWeapon.POWER_SWORD;
                        case 2 ->
                            meleeWeapon = MeleeWeapon.MANREAPER;
                        case 3 ->
                            meleeWeapon = MeleeWeapon.LIGHTING_CLAW;
                        case 4 ->
                            meleeWeapon = MeleeWeapon.POWER_BLADE;
                    }
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести int!");
            }
        }
    }
    private void setHeartCount(){
        while (true) {
            System.out.print("Введите heartCount(0<heartCount<=3): ");
            try{
                heartCount = Long.parseLong(Scan());
                if (heartCount>3 || heartCount<=0){
                    System.out.println("Значение heartCount должно быть от 1 до 3!");
                }else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести Long");
            }

        }
    }

    private void setHealth(){
        while(true){
            System.out.print("Введите значение больше 0 (Long)health: ");
            try{
                String sHealth = Scan();
                if (sHealth.replaceAll(" ", "").equals("")){
                    health = null;
                    break;
                }
                health = Long.parseLong(sHealth);
                if (health<=0){
                    System.out.println("Значение health должно быть больше 0!");
                }else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести Long!");
            }
        }
    }
    public void setId(){
        this.id = (int) (Math.random() * 1000000)+1; //только целая часть + 1 тк > 0
    }
    //пришлось сделать паблик тк взял за значение и его надо менять
    private void setName(){
        while (true){
            System.out.print("Введите имя: ");
            name = Scan();
            if(name.replaceAll(" ", "").equals("")){
                System.out.println("Вы ввели пустую строчку! Имя не может быть пустой строчкой.");
            }else{break;}
        }
    }

    public int getId(){
        return id;
    }
    public Chapter getChapter(){return chapter; }
    public LocalDate getDate(){return creationDate;}

    public String getName(){return name;}

    @Override
    public String toString(){
        return ("Name: " + name + "\nid: "+ id + "\nКоординаты: " + coordinates + "\nДата: " + creationDate+"\nhealth: " + health + ", heartCount: " + heartCount +
                "\nmeleeWeapon: " + meleeWeapon + "\nChapter: "+ chapter);
    }
}

