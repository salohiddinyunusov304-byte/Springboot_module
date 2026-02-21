package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;

import java.util.List;

public interface GroupService {
    GroupResponse create(GroupCreator creator);

    List<GroupResponse> findAllGroups();

    GroupResponse findGroupById(Integer id);

    void deleteGroupById(Integer id);

    GroupResponse updateGroup(Group group);
}
