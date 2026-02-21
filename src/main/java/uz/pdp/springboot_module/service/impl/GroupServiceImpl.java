package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.repository.GroupRepository;
import uz.pdp.springboot_module.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupResponse create(GroupCreator creator) {
        Group group = Group.builder()
                .name(creator.name())
                .level(creator.level())
                .build();
        Group save = groupRepository.save(group);
        return new GroupResponse(
                save.getId(),
                save.getName(),
                save.getLevel()
        );
    }

    @Override
    public List<GroupResponse> findAllGroups() {
        List<Group> groups = groupRepository.findAll();

        return groups.stream()
                .map(group -> new GroupResponse(
                        group.getId(),
                        group.getName(),
                        group.getLevel()
                )).toList();
    }

    @Override
    public GroupResponse findGroupById(Integer id) {
        return groupRepository.findById(id)
                .map(group -> new GroupResponse(
                        group.getId(),
                        group.getName(),
                        group.getLevel()
                )).orElse(null);
    }

    @Override
    public void deleteGroupById(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    public GroupResponse updateGroup(Group group) {
        Group save = groupRepository.save(group);
        return new GroupResponse(
                save.getId(),
                save.getName(),
                save.getLevel()
        );
    }
}
