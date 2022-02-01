import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

  //         1.  Album

//    -  It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
private String name;
private String artist;
private ArrayList<Song> songs;
//    -  A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

//    -  And three methods, they are:

  //                  -  addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise.
    public boolean addSong(String title, double duration){
        if(findSong(title)==null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
//        -  findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists, null if it doesn't exists.
    private Song findSong(String title){
        for (Song song:songs)
            if (song.getTitle().equals(title))
            {
                return song;
            }
        return null;
    }
  //                  -  addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the track number, or false otherwise.
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist)
    {    int indexNumber=trackNumber-1;
        if((indexNumber>=0)&&(indexNumber<=songs.size())){
            songs.add(this.songs.get(indexNumber));
            return true;
        }
        return false;
    }
//        -  addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the name of the song, or false otherwise.
public boolean addToPlayList(String title, LinkedList<Song> playlist)
{
    Song song=findSong(title);
    if(song!=null){
        songs.add(song);
        return true;
    }
    return false;
}
//
}
