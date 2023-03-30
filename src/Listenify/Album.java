package Listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String artiestName;
    public String albumName;

    public List<Song> songList; //created list to store the song objects;

    //initializing the arraylist.
public Album(String artiestName,String albumName){

    this.artiestName=artiestName;
    this.albumName=albumName;

    songList=new ArrayList<>();
}

//finding song in album
public boolean findSongInAlbum(String title){ //in this we can also add the artiest name ;

    for(Song song:songList){//iterating over song list(on song obj)
        if(song.title.equals(title)){//if entered title of song and song present in album matches return true.means already present in album.
            return true;
        }
    }
    return false;
}
//adding song to album
public String addSongToAlbum(String title,double duration){

    if(findSongInAlbum(title)){//checking whether song is already present in album or not.
        return "song is already present";
    }
    else{
        //need to create object of new song to add in songList.
        Song newSong=new Song(title,duration); //created object of new song.
        songList.add(newSong); //adding that song in songList made above.

        return "new song has been added";
    }
}

    //adding song to playlist.
public String addSongToPlayList(int trackNo, LinkedList<Song>playList){

    int index=trackNo-1;

    if(index>=0 && index<this.songList.size()){

        Song song=this.songList.get(index);//
        playList.add(song);// adding the song to playlist.
        return "song added to playlist";
    }
    return "Invalid track No";
}

public String addSongToPlayList(String title,LinkedList<Song>playList){
 //need to find song with that title.
    //after finding add that to the playlist.


    for(Song song:songList){//iterating over the song list.

        String title1 = title;
        if(title1.equals(song.title)){
            playList.add(song);
            return "song has been added";
        }
        }
    return "song not exist";
    }
    }
