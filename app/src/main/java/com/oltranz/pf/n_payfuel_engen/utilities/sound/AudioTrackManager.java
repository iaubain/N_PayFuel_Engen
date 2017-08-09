package com.oltranz.pf.n_payfuel_engen.utilities.sound;

/**
 * Created by ISHIMWE Aubain Consolateur. email: iaubain@yahoo.fr / aubain.c.ishimwe@oltranz.com Tel: +250 785 534 672 / +250 736 864 662 on 6/30/2017.
 */

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;

public class AudioTrackManager {
    private static final int RATE = 44100;
    private static final float MAXVOLUME = 100f;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int DOUBLE = 3;

    private AudioTrack audioTrack;
    private float volume;
    private int channel;
    private int length;
    private byte[] wave;

    public AudioTrackManager(){
        wave=new byte[RATE];
    }

    /**
     *set rate
     * @param rate
     */
    public void start(int rate){

        stop();
        if(rate>0){
            int hz = rate;
            int waveLen = RATE / hz;
            length = waveLen * hz;
            audioTrack=new AudioTrack(AudioManager.STREAM_MUSIC, RATE,
                    AudioFormat.CHANNEL_CONFIGURATION_STEREO, // CHANNEL_CONFIGURATION_MONO,
                    AudioFormat.ENCODING_PCM_8BIT, length, AudioTrack.MODE_STREAM);
            wave=SinWave.sin(wave, waveLen, length);
            if(audioTrack!=null){
                try {
                    audioTrack.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            return;
        }


    }

    /**
     * play
     */
    public void play(){

        if(audioTrack!=null){
            Log.i("Audio","play");
            audioTrack.write(wave, 0, length);
        }

    }

    /**
     * stop
     */
    public void stop(){

        if(audioTrack!=null){
            audioTrack.stop();
            audioTrack.release();
            audioTrack=null;
        }

    }

    /**
     * set volume
     * @param volume
     */
    public void setVolume(float volume){
        this.volume=volume;
        if(audioTrack!=null){
            switch (channel) {
                case LEFT:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        audioTrack.setVolume(volume);
                    }else
                        audioTrack.setStereoVolume(volume/MAXVOLUME, 0f);
                    break;
                case RIGHT:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        audioTrack.setVolume(volume);
                    }else
                        audioTrack.setStereoVolume(0f, volume/MAXVOLUME);
                    break;
                case DOUBLE:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        audioTrack.setVolume(volume);
                    }else
                        audioTrack.setStereoVolume(volume/MAXVOLUME, volume/MAXVOLUME);
                    break;
            }
        }
    }

    /**
     * set channel
     * @param channel
     */
    public void setChannel(int channel){
        this.channel=channel;
        setVolume(volume);
    }
}


