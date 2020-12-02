package com.rakovets.course.design.example.pattern.iterator.example.social_networks;

import com.rakovets.course.design.example.pattern.iterator.example.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
