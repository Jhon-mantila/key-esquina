package com.esquinaweb.controller;

import com.esquinaweb.mouse.MouseHook;
import com.esquinaweb.ui.ModeContainer;

public class MouseController {

    private final ModeContainer modeContainer;
    private final MouseHook mouseHook;

    public MouseController(ModeContainer modeContainer) {

        this.modeContainer = modeContainer;

        mouseHook = new MouseHook(this);

    }

    public void start() {

        mouseHook.register();

    }

}