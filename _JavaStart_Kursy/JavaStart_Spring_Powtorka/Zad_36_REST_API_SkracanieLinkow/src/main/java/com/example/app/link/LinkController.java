package com.example.app.link;

import com.example.app.link.dto.CreateLinkDto;
import com.example.app.link.dto.LinkDto;
import com.example.app.link.dto.UpdateLinkDto;
import com.example.app.link.exceptions.InvalidPasswordException;
import com.example.app.link.exceptions.LinkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/links")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    ResponseEntity<LinkDto> save(@RequestBody CreateLinkDto linkDto) {

        LinkDto createdLink = linkService.createLink(linkDto);

        URI createdLinkUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdLink.getId())
                .toUri();

        return ResponseEntity.created(createdLinkUri).body(createdLink);
    }

    @GetMapping("/{id}")
    ResponseEntity<LinkDto> findById(@PathVariable String id) {
        return linkService.findLinkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateLink(@PathVariable String id, @RequestBody UpdateLinkDto linkDto) {
        try {
            linkService.updateLinkName(id, linkDto);
            return ResponseEntity.noContent().build();
        } catch (LinkNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidPasswordException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .header("Reason", e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteLink(@RequestHeader(name = "passwd") String password, @PathVariable String id) {
        try {
            linkService.deleteLink(id, password);
            return ResponseEntity.noContent().build();
        } catch (LinkNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidPasswordException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .header("Reason", e.getMessage())
                    .build();
        }
    }
}
