package com.example.app.link;

import com.example.app.link.dto.CreateLinkDto;
import com.example.app.link.dto.LinkDto;
import com.example.app.link.dto.UpdateLinkDto;
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
        return linkService.findLinkById(id)
                .map(el -> {
                    Optional<LinkDto> updatedLink = linkService.updateLinkName(id, linkDto);
                    if (updatedLink.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                .header("Reason", "wrong password")
                                .build();
                    }
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }
}
