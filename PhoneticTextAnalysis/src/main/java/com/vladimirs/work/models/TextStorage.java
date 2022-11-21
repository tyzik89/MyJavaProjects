package com.vladimirs.work.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextStorage {

    private ObservableList<CharSequence> charSequenceObservableList = FXCollections.observableArrayList();

    public void addWord(CharSequence charSequence) {
        charSequenceObservableList.add(charSequence);
    }

    public void clearStorage() {
        charSequenceObservableList.clear();
    }
}
