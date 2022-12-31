package pl.javastart.equipy.components.user.mapper;

import pl.javastart.equipy.components.assignment.Assignment;
import pl.javastart.equipy.components.inventory.asset.Asset;
import pl.javastart.equipy.components.user.dto.UserAssignmentDto;

public class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment) {
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setAssetId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetId(asset.getId());
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
