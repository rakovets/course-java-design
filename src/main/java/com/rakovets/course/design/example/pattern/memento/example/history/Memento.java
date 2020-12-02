package com.rakovets.course.design.example.pattern.memento.example.history;

import com.rakovets.course.design.example.pattern.memento.example.editor.Editor;

public class Memento {
    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
