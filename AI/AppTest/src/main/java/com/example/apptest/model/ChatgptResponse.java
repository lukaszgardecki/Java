package com.example.apptest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ChatgptResponse {
    private List<Choice> choices;
}
