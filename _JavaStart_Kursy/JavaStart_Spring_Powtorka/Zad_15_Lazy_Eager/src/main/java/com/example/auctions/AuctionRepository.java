package com.example.auctions;

import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<Auction, Long> {
}
