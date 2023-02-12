package com.example.app;

import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private static final String PATH_REDIRECT = "http://localhost:8080/redir/";
    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;
    private final MyIdGenerator generator;

    public LinkService(LinkRepository linkRepository, LinkMapper linkMapper, MyIdGenerator generator) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
        this.generator = generator;
    }

    public LinkDto createLink(CreateLinkDto createLinkDto) {
        Link link = getLink(createLinkDto);
        Link savedLink = linkRepository.save(link);
        return linkMapper.map(savedLink);
    }

    private Link getLink(CreateLinkDto createLinkDto) {
        String id;
        do {
            id = generator.generate();
        } while (linkRepository.existsById(id));

        return new Link(
                id,
                createLinkDto.getName(),
                createLinkDto.getTargetUrl(),
                PATH_REDIRECT + id,
                0L
        );
    }

}
