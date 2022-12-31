package pl.javastart.equipy.components.inventory.asset.mapper;

import pl.javastart.equipy.components.assignment.Assignment;
import pl.javastart.equipy.components.inventory.asset.dto.AssetAssignmentDto;
import pl.javastart.equipy.components.user.User;

public class AssetAssignmentMapper {

    public static AssetAssignmentDto toDto(Assignment assignment) {
        AssetAssignmentDto dto = new AssetAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());

        User user = assignment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}
