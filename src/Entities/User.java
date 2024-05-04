package Entities;

public class User {
    private String Id;
    public String name;
    public PlayingPiece p;

    public User(String ID, String name, PlayingPiece p)
    {
        this.Id=ID;
        this.name=name;
        this.p=p;
    }
}
