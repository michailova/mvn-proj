package abs;

//100% abstract class

public interface Playable {

    //public abstract by default;
    void  play();

    //by default the field is public and static final (constant)
    public abstract void stop();
    double pi = 3.14;
    public  static  final double pi2 = 3.14;

}
