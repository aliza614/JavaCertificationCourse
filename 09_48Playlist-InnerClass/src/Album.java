import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

  //         1.  Album

//    -  It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
private String name;
private String artist;
private SongList songs;
//    -  A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();//new ArrayList<Song>();
    }

//    -  And three methods, they are:

  //                  -  addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise.
    public boolean addSong(String title, double duration){
        return this.songs.add( new Song(title,duration));
        //        if(findSong(title)==null) {
//            songs.add(new Song(title, duration));
//            return true;
//        }
//        return false;
    }
//        -  findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists, null if it doesn't exists.
//    private Song findSong(String title){
//        for (Song song:songs)
//            if (song.getTitle().equals(title))
//            {
//                return song;
//            }
//        return null;
//    }
  //                  -  addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the track number, or false otherwise.
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist)
    {   Song checkedSong =this.songs.findSong(trackNumber);
        if (checkedSong!=null)
        {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("this album does not have a track "+trackNumber);
        return false;

//    {    int indexNumber=trackNumber-1;
//        if((indexNumber>=0)&&(indexNumber<=songs.size())){
//            songs.add(this.songs.get(indexNumber));
//            return true;
//        }
//        return false;
    }
//        -  addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the name of the song, or false otherwise.
public boolean addToPlayList(String title, LinkedList<Song> playlist)
{
    Song checkedSong= songs.findSong(title);
//    Song song=findSong(title);
    if(checkedSong!=null){
        playlist.add(checkedSong);
        return true;
    }
    System.out.println("the song "+title+" is not in the album.");
    return false;
}

private class SongList{
        private ArrayList<Song> songs;

        private SongList(){
            this.songs=new ArrayList<Song>();
        }
        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }
    private Song findSong(String title){
        for (Song song:songs)
            if (song.getTitle().equals(title))
            {
                return song;
            }
        return null;
    }

    public Song findSong(int trackNumber){
            int index=trackNumber-1;
            if((index>0)&& (index<songs.size())){
                return songs.get(index);
            }
            return null;
    }
}
//
}
