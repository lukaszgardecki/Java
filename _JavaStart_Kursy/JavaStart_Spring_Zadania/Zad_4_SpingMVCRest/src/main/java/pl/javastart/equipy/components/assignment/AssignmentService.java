package pl.javastart.equipy.components.assignment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.equipy.components.assignment.exception.AssignmentAlreadyFinishedException;
import pl.javastart.equipy.components.assignment.exception.AssignmentNotFoundException;
import pl.javastart.equipy.components.inventory.asset.Asset;
import pl.javastart.equipy.components.inventory.asset.AssetRepository;
import pl.javastart.equipy.components.user.User;
import pl.javastart.equipy.components.user.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssignmentService {
    private AssignmentRepository assignmentRepository;
    private AssetRepository assetRepository;
    private UserRepository userRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, AssetRepository assetRepository, UserRepository userRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    AssignmentDto createAssignment(AssignmentDto assignmentDto) {
        Optional<Assignment> activeAssignmentForAsset = assignmentRepository.findByAsset_IdAndEndIsNull(assignmentDto.getAssetId());
        activeAssignmentForAsset.ifPresent(a -> {
            throw new InvalidAssignmentException("To wyposażenie jest aktualnie do kogoś przypisane");
        });
        Optional<User> user = userRepository.findById(assignmentDto.getUserId());
        Optional<Asset> asset = assetRepository.findById(assignmentDto.getAssetId());
        Assignment assignment = new Assignment();
        Long userId = assignmentDto.getUserId();
        Long assetId = assignmentDto.getAssetId();
        assignment.setUser(user.orElseThrow(() -> {
            throw new InvalidAssignmentException("Brak użytkownika z id: " + userId);
        }));
        assignment.setAsset(asset.orElseThrow(() -> {
            throw new InvalidAssignmentException("Brak wyposażenia z id: " + assetId);
        }));
        assignment.setStart(LocalDateTime.now());
        return AssignmentMapper.toDto(assignmentRepository.save(assignment));
    }

    @Transactional
    public LocalDateTime finishAssignment(Long assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        Assignment assignmentEntity = assignment.orElseThrow(AssignmentNotFoundException::new);
        if (assignmentEntity.getEnd() != null) {
            throw new AssignmentAlreadyFinishedException();
        } else {
            assignmentEntity.setEnd(LocalDateTime.now());
        }
        return assignmentEntity.getEnd();
    }
}
