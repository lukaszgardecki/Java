package com.mojastrona.projekt_readstack.domain.api;

import com.mojastrona.projekt_readstack.domain.discovery.Discovery;
import com.mojastrona.projekt_readstack.domain.discovery.DiscoveryDao;

import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {
    private final DiscoveryDao discoveryDao = new DiscoveryDao();

    public List<DiscoveryBasicInfo> findAll() {
        return discoveryDao.findAll().stream()
                .map(DiscoveryMapper::map)
                .collect(Collectors.toList());
    }

    private static class DiscoveryMapper {
        static DiscoveryBasicInfo map(Discovery discovery) {
            return new DiscoveryBasicInfo(
                    discovery.getTitle(),
                    discovery.getUrl(),
                    discovery.getDescription(),
                    discovery.getDateAdded()
            );
        }
    }
}
