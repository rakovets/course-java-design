package com.rakovets.course.design.example.pattern.iterator.example.iterators;

import com.rakovets.course.design.example.pattern.iterator.example.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
