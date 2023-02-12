package com.example.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/api/links")
    ResponseEntity<LinkDto> createLink(CreateLinkDto linkDto) {

        LinkDto createdLink = linkService.createLink(linkDto);
        createdLink.setName(linkDto.getName());
        createdLink.setTargetUrl(linkDto.getTargetUrl());

        URI createdLinkUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/redir/{id}")
                        .buildAndExpand(createdLink.getId())
                        .toUri();

        return ResponseEntity.created(createdLinkUri)
                .header("Location", createdLinkUri.getPath())
                .body(createdLink);
    }

}
