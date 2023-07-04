package Casting;

public class CastingTester {
    public static void main(String[] args) {

        Admin admin = new Admin();
        admin.readLogs();

        Manager manager = new Manager();
        manager.addUsers();

        //Пример  UpCasting - привидение типо, способность представить ссылку
        // на конкретный объект ввиде родительского класса
        //Он безопасен всегда, может происходить неявно
        //Casting не меняет сам объект (делает ссылку, не меняет поля)
        //Upcasting всегда работает если есть "is a relationship"
        //


        Role role = new GeneralUser();
        role.read();

        Object o = new GeneralUser();
        //o.read();

        Role role1 = (Role) new Manager(); // явный upCasting
        Object o1 = (Object) (Role) new Manager();

        Admin admin1 = new Admin();
        Role role2 = admin1; // не явный upCasting - мы можем любой объект рассматривать если отношения Parent - Child
        Object o2 = role2;

        test(o2);
        test(o1);
        test(role2);
        test(role1);

        test(123); //new integer -> downcast


//        Player dvdPlayer = new DVDPlayer();
//        Player mp3Player = new Mp3Player();
//        Player tapePlayer = new TapePlayer();

        System.out.println("*********МАСТЕР КЛАСС**********");
        Player[] players = {new DVDPlayer(), new Mp3Player(),new TapePlayer()};
        for (Player player:players){
            test(player);
            player.play();
            if(player instanceof Mp3Player){
                ((Mp3Player)player).SwitchSong();
            }
        }



        // Down casting - небезопастный. Всегда в явной форме
        // Процесс востановления ссылки для конкретного объекта

        System.out.println("__________Down casting__________");

        //String str = (String) new Object(); // Пример ошибки, мы не можем получить из строки объект , так как она не инициализирована
        //Role role3 = (Role) new DVDPlayer(); // Нельзя совмести две разные иерархии


        // instanceof  (проверяемая позиция (ссылка) и проверяемая иерархия(класс))
        Role r = (Role) new Admin();
        if(r instanceof Admin){
            Admin a =(Admin) r;
            a.readLogs();
            if (a instanceof SuperAdmin){
                SuperAdmin su = (SuperAdmin) a;
                su.canDoAllStuff();
            }
        }
        else if (r instanceof Manager) {
            Manager m = (Manager) r;
            m.addUsers();
        }
        else {
            GeneralUser gu = (GeneralUser) r;
            gu.createOrder();
        }

        System.out.println("_________PLAYER_________");
        Player p = new Mp3Player();
        if(p instanceof DVDPlayer){
            DVDPlayer a =(DVDPlayer) p;
            a.ImpressiveQuality();
        }
        else if (p instanceof Mp3Player){
            Mp3Player mp = (Mp3Player) p;
            mp.SwitchSong();
        }
        else {
            TapePlayer tp = (TapePlayer) p;
            tp.ChangeTapeSide();
        }




    }

    static void test(Object obj){
        System.out.println(obj.getClass().getSimpleName()); //принимает любой объект  и ввыводит имя класса в консоль
    }
}
abstract class Player{
    abstract void play();

}
class DVDPlayer extends Player{

    @Override
    void play() {
        System.out.println("playing disc");
    }
    void ImpressiveQuality (){
        System.out.println("Next Level Quality ");
    }
}
class Mp3Player extends Player{
    @Override
    void play() {
        System.out.println("playing songs from internal storage");
    }
    void SwitchSong (){
        System.out.println("Super fast switch song");
    }
}
class TapePlayer extends Player{
    @Override
    void play() {
        System.out.println("playing songs from tape");
    }
    void ChangeTapeSide (){
        System.out.println("Another tape side");
    }
}
