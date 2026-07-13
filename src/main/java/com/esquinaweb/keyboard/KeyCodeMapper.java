package com.esquinaweb.keyboard;

import java.util.HashMap;
import java.util.Map;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import javafx.scene.input.KeyCode;

public class KeyCodeMapper {

    private static final Map<Integer, KeyCode> MAP = new HashMap<>();

    static {

        MAP.put(NativeKeyEvent.VC_W, KeyCode.W);
        MAP.put(NativeKeyEvent.VC_A, KeyCode.A);
        MAP.put(NativeKeyEvent.VC_S, KeyCode.S);
        MAP.put(NativeKeyEvent.VC_D, KeyCode.D);
        MAP.put(NativeKeyEvent.VC_SHIFT, KeyCode.SHIFT);
        MAP.put(NativeKeyEvent.VC_SPACE, KeyCode.SPACE);

    }
    
    public static KeyCode toKeyCode(int nativeCode) {

        return MAP.get(nativeCode);

    }
}