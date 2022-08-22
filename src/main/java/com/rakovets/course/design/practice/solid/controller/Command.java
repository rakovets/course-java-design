package com.rakovets.course.design.practice.solid.controller;

public interface Command {
    <T> T execute();
}
