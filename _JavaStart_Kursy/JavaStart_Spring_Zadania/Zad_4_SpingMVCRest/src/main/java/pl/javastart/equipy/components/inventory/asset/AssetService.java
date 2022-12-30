package pl.javastart.equipy.components.inventory.asset;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    private AssetRepository assetRepository;
    private AssetMapper assetMapper;

    AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .toList();
    }
}
