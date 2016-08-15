package com.marvel.resp;

/**
 * 语音消息
 * 
 * @author Marvel Cheng
 */
public class VoiceMessage extends BaseMessage {
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
