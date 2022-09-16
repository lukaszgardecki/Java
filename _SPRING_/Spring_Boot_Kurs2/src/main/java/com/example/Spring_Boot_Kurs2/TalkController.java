package com.example.Spring_Boot_Kurs2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talks")
public class TalkController {

    private final TalkRepository talkRepository;

    @Autowired
    public TalkController(TalkRepository talkRepository) {
        this.talkRepository = talkRepository;
    }

    //@GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Talk> getTalks() {
        return talkRepository.findAll();
    }

    //@PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public void addTalk(@RequestBody Talk talk) {
        talkRepository.save(talk);
    }
}
