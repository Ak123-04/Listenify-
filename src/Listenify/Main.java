package Listenify;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {


    public static LinkedList<Album>albums=new LinkedList<>();
    public static void main(String[] args) {

        Album Arjit_singh = new Album("Arjit Singh", "Farzi");
        Arjit_singh.addSongToAlbum("Rahat", 3.5);
        Arjit_singh.addSongToAlbum("Tum mile", 5.5);
        Arjit_singh.addSongToAlbum("Rabta", 4.5);

        albums.add(Arjit_singh);

        Album Atif_aslam = new Album("Atif aslam", "Calm songs");
        Atif_aslam.addSongToAlbum("Tere liye", 4.5);
        Atif_aslam.addSongToAlbum("Sajda", 5.0);
        Atif_aslam.addSongToAlbum("jeene laga hoon", 5.5);

        albums.add(Atif_aslam);

        LinkedList<Song> playlist = new LinkedList<>();

        albums.get(0).addSongToPlayList("Rahat", playlist);
        albums.get(0).addSongToPlayList("Rabta", playlist);
        albums.get(1).addSongToPlayList("jeene laga hoon", playlist);

        play(playlist);
        
    }
    public static void play(LinkedList<Song> playlist){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song>listIterator=playlist.listIterator();//it is iterator which will iterate on playlist made by us.

        //validation check.
        if(playlist.size()==0){
            return;
        }

        printmenu();
        System.out.println("Now playing"+listIterator.next());
        boolean forward=true;
        boolean quit=false;


        while(!quit) {
        int choice=sc.nextInt();
            switch (choice) {
                case 0:
                    quit=true;
                    break;

                case 1:
                    if(forward==false){
                        listIterator.next();
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }
                    else{
                        System.out.println("you are already at the last song");
                    }
                    break;

                case 2:
                    if (forward == true) {//already toward right side of last printed value.
                        listIterator.previous();
                        forward=false;
                    }if(listIterator.hasPrevious()){
                            System.out.println(listIterator.previous().toString());
                        }
                    else{
                    System.out.println("you are already at the first song");
                }
                    break;

                case 3: if(forward==true){//I am on RHS print the previous song.
                    System.out.println(listIterator.previous().toString());
                    forward=false;
                }else{//forward is false and I am on LHS
                    System.out.println(listIterator.next().toString());
                    forward=true;
                }
                break;
                case 4:
                        printAllSongs(playlist);
                break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    break;
            }

        }
    }
    private static void printAllSongs(LinkedList<Song> playlist){

        ListIterator<Song>listIterator=playlist.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
    private static void printmenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - replay current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

}