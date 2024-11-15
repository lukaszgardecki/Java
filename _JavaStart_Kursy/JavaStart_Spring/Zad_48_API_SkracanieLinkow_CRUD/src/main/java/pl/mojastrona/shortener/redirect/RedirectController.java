package pl.mojastrona.shortener.redirect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mojastrona.shortener.link.LinkService;
import pl.mojastrona.shortener.link.dto.LinkDto;

import java.net.URI;

@Controller
class RedirectController {
    private final LinkService linkService;

    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/redir/{id}")
    ResponseEntity<?> redirect(@PathVariable String id) {
        return linkService.incrementVisitsById(id)
                .map(LinkDto::getTargetUrl)
                .map(targetUrl -> ResponseEntity
                        .status(HttpStatus.FOUND)
                        .location(URI.create(targetUrl))
                        .build())
                .orElse(ResponseEntity.notFound().build());

    }
}
