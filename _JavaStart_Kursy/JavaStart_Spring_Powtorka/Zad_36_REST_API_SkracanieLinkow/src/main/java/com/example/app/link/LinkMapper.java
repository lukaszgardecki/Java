package com.example.app.link;

import com.example.app.link.dto.LinkDto;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class LinkMapper {

    public LinkDto map(Link entity) {
        String redirectUrl = buildRedirectUrlFromId(entity.getId());

        return new LinkDto(
                entity.getId(),
                entity.getName(),
                entity.getTargetUrl(),
                redirectUrl,
                entity.getVisits()
        );
    }

    private String buildRedirectUrlFromId(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/redir/{id}")
                .buildAndExpand(id)
                .toUriString();
    }

}
