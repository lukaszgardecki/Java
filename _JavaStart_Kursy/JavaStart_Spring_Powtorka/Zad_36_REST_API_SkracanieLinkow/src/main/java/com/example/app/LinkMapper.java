package com.example.app;

import org.springframework.stereotype.Service;

@Service
public class LinkMapper {

    public LinkDto map(Link entity) {
        LinkDto dto = new LinkDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTargetUrl(entity.getTargetUrl());
        dto.setRedirectUrl(entity.getRedirectUrl());
        dto.setVisits(entity.getVisits());
        return dto;
    }

    public Link map(LinkDto dto) {
        Link link = new Link();
        link.setId(dto.getId());
        link.setName(dto.getName());
        link.setTargetUrl(dto.getTargetUrl());
        link.setRedirectUrl(dto.getRedirectUrl());
        link.setVisits(dto.getVisits());
        return link;
    }
}
