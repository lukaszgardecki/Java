package com.example.app.link;

import com.example.app.link.dto.CreateLinkDto;
import com.example.app.link.dto.LinkDto;
import com.example.app.link.dto.UpdateLinkDto;
import com.example.app.link.exceptions.InvalidPasswordException;
import com.example.app.link.exceptions.LinkNotFoundException;
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
    public void updateLinkName(String id, UpdateLinkDto link) {
        Optional<Link> linkToUpdate = linkRepository.findById(id);
        linkToUpdate.orElseThrow(LinkNotFoundException::new);
        linkToUpdate.filter(entity -> checkPassword(entity, link.getPassword()))
                .orElseThrow(InvalidPasswordException::new)
                .setName(link.getName());
    }

    public void deleteLink(String id, String password) {
        Optional<Link> linkToDelete = linkRepository.findById(id);
        linkToDelete.orElseThrow(LinkNotFoundException::new);
        Link link = linkToDelete.filter(entity -> checkPassword(entity, password))
                .orElseThrow(InvalidPasswordException::new);
        linkRepository.delete(link);
    }


    @Transactional
    public Optional<LinkDto> incrementVisitById(String id) {
        Optional<Link> link = linkRepository.findById(id);
        link.ifPresent(el -> el.setVisits(el.getVisits() + 1));
        return link.map(linkMapper::map);
    }

    private boolean checkPassword(Link entity, String password) {
        return entity.getPassword() != null && entity.getPassword().equals(password);
    }

}
