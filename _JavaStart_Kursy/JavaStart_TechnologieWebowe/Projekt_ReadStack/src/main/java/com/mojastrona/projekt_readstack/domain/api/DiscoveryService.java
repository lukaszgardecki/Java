package com.mojastrona.projekt_readstack.domain.api;

import com.mojastrona.projekt_readstack.domain.discovery.Discovery;
import com.mojastrona.projekt_readstack.domain.discovery.DiscoveryDao;
import com.mojastrona.projekt_readstack.domain.user.UserDao;
import com.mojastrona.projekt_readstack.domain.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {
    private final DiscoveryDao discoveryDao = new DiscoveryDao();
    private final DiscoveryMapper discoveryMapper = new DiscoveryMapper();

    public void add(DiscoverySaveRequest saveRequest) {
        Discovery discoveryToSave = discoveryMapper.map(saveRequest);
        discoveryDao.save(discoveryToSave);
    }

    public List<DiscoveryBasicInfo> findAll() {
        return discoveryDao.findAll()
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    public List<DiscoveryBasicInfo> findAllByCategory(int categoryId) {
        return discoveryDao.findByCategory(categoryId)
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    private static class DiscoveryMapper {
        private final UserDao userDao = new UserDao();
        private final VoteDao voteDao = new VoteDao();

        DiscoveryBasicInfo map(Discovery d) {
            return new DiscoveryBasicInfo(
                    d.getId(),
                    d.getTitle(),
                    d.getUrl(),
                    d.getDescription(),
                    d.getDateAdded(),
                    voteDao.countByDiscoveryId(d.getId())
            );
        }

        Discovery map(DiscoverySaveRequest ds) {
            return new Discovery(
                    ds.getTitle(),
                    ds.getUrl(),
                    ds.getDescription(),
                    LocalDateTime.now(),
                    ds.getCategoryId(),
                    userDao.findByUsername(ds.getAuthor())
                            .orElseThrow()
                            .getId()
            );
        }
    }
}
