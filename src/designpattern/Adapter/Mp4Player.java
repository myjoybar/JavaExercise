package designpattern.Adapter;

import designpattern.Adapter.interfaces.AdvancedMediaPlayer;

/**
 * Created by joybar on 30/05/17.
 */
public class Mp4Player  implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
