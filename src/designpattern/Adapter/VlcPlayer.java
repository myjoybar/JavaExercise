package designpattern.Adapter;

import designpattern.Adapter.interfaces.AdvancedMediaPlayer;

/**
 * Created by joybar on 30/05/17.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
