package com.example.app.link;

import com.example.app.link.dto.CreateLinkDto;
import com.example.app.link.dto.LinkDto;
import com.example.app.link.dto.UpdateLinkDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;


    public LinkService(LinkRepository linkRepository, LinkMapper linkMapper) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
    }

    @Transactional
    public LinkDto createLink(CreateLinkDto createLinkDto) {
        String id;
        do {
            id = MyIdGenerator.generate();
        } while (linkRepository.existsById(id));
        Link link = new Link(id, createLinkDto.getName(), createLinkDto.getTargetUrl(), createLinkDto.getPassword());
        Link savedLink = linkRepository.save(link);
        return linkMapper.map(savedLink);
    }

    public Optional<LinkDto> findLinkById(String id) {
        return linkRepository.findById(id).map(linkMapper::map);
    }

    @Transactional
    public Optional<LinkDto> updateLinkName(String id, UpdateLinkDto dto) {
        Optional<Link> link = linkRepository.findById(id).filter(el -> el.getPassword() != null);
        Optional<Link> linkWithCorrectPass = link.filter(el -> el.getPassword().equals(dto.getPassword()));

        if (link.isEmpty() || linkWithCorrectPass.isEmpty()) {
            return Optional.empty();
        }
        linkWithCorrectPass.ifPresent(el -> el.setName(dto.getName()));
        return linkWithCorrectPass.map(linkMapper::map);
    }

    @Transactional
    public Optional<LinkDto> incrementVisitById(String id) {
        Optional<Link> link = linkRepository.findById(id);
        link.ifPresent(el -> el.setVisits(el.getVisits() + 1));
        return link.map(linkMapper::map);
    }

}
