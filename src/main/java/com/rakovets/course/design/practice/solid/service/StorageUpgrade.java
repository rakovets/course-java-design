package com.rakovets.course.design.practice.solid.service;

import java.nio.file.Path;

public interface StorageUpgrade {
    void overwriting(Path... patches);
}
