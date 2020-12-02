package com.rakovets.course.design.example.pattern.bridge.example.remotes;

import com.rakovets.course.design.example.pattern.bridge.example.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
