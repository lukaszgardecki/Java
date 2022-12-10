package pl.mojastrona.shortener.link;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mojastrona.shortener.link.dto.*;

import java.util.Optional;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    public LinkDto shortenLink(LinkCreateDto link) {
        String randomId;
        // Jeżeli link istnieje już w bazie to wygeneruj jeszcze raz:
        do {
            randomId = UUIDRandomIdGenerator.generateId();
        } while (linkRepository.existsById(randomId));

        // Tworzymy encję:
        Link newLink = new Link(randomId, link.getName(), link.getPassword(), link.getTargetUrl());
        // zapisujemy encję w bazie (metoda save zwraca ZAPISANĄ encję)
        Link savedLink = linkRepository.save(newLink);
        // zwracamy obiekt DTO: LinkDtoMapper konwertuje obiekt encji na obiekt dto
        return LinkDtoMapper.map(savedLink);
    }

    public Optional<LinkDto> findLinkById(String id) {
        return linkRepository.findById(id)
                .map(LinkDtoMapper::map);
    }

    @Transactional
    public Optional<LinkDto> incrementVisitsById(String id) {
        Optional<Link> link = linkRepository.findById(id);
        link.ifPresent(l -> l.setVisits(l.getVisits() + 1));
        return link.map(LinkDtoMapper::map);
    }

    @Transactional
    public void updateLink(String linkId, LinkUpdateDto link) {
        Optional<Link> linkToUpdate = linkRepository.findById(linkId);
        linkToUpdate.orElseThrow(LinkNotFoundException::new);
        linkToUpdate.filter(entity -> checkPassword(entity, link.getPassword()))
                .orElseThrow(InvalidPasswordException::new)
                .setName(link.getName());
    }

    @Transactional
    public void deleteById(String id, String password) {
        Optional<Link> linkById = linkRepository.findById(id);
        if (linkById.isPresent()) {
            Link linkToDelete = linkById.filter(link -> checkPassword(link, password))
                    .orElseThrow(InvalidPasswordException::new);
            linkRepository.delete(linkToDelete);
        }
    }


    private boolean checkPassword(Link entity, String password) {
        return entity.getPassword() != null && entity.getPassword().equals(password);
    }
}
