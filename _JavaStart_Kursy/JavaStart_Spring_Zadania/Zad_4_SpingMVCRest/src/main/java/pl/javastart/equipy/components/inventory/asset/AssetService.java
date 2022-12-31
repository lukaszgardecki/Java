package pl.javastart.equipy.components.inventory.asset;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.components.inventory.asset.dto.AssetAssignmentDto;
import pl.javastart.equipy.components.inventory.asset.dto.AssetDto;
import pl.javastart.equipy.components.inventory.asset.exception.AssetNotFoundException;
import pl.javastart.equipy.components.inventory.asset.exception.DuplicateSerialNumberException;
import pl.javastart.equipy.components.inventory.asset.mapper.AssetAssignmentMapper;
import pl.javastart.equipy.components.inventory.asset.mapper.AssetMapper;

import java.util.List;
import java.util.Optional;

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

    List<AssetDto> findAllByNameOrSerialNumber(String text) {
        return assetRepository.findAllByNameOrSerialNumber(text)
                .stream()
                .map(assetMapper::toDto)
                .toList();
    }

    Optional<AssetDto> findById(Long id) {
        return assetRepository.findById(id).map(assetMapper::toDto);
    }

    AssetDto save(AssetDto asset) {
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(a -> {
            throw new DuplicateSerialNumberException();
        });
        return mapAndSave(asset);
    }

    AssetDto update(AssetDto asset) {
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(a -> {
            if (!a.getId().equals(asset.getId())) {
                throw new DuplicateSerialNumberException();
            }
        });
        return mapAndSave(asset);
    }

    private AssetDto mapAndSave(AssetDto asset) {
        Asset assetEntity = assetMapper.toEntity(asset);
        Asset savedAsset = assetRepository.save(assetEntity);
        return assetMapper.toDto(savedAsset);
    }

    List<AssetAssignmentDto> getAssetAssignments(Long id) {
        return assetRepository.findById(id)
                .map(Asset::getAssignments)
                .orElseThrow(AssetNotFoundException::new)
                .stream()
                .map(AssetAssignmentMapper::toDto)
                .toList();
    }
}
