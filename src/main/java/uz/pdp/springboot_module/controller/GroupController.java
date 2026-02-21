package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.service.GroupService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(GroupController.BASE_URL)
public class GroupController {
    public static final String BASE_URL = Constants.BASE_URL + "/groups";
    private final GroupService groupService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupResponse create(@RequestBody GroupCreator creator) {
        return groupService.create(creator);
    }

    @GetMapping("/findAll")
    public List<GroupResponse> findAll() {
        return groupService.findAllGroups();
    }

    @GetMapping("/findById/{id}")
    public GroupResponse findById(@PathVariable Integer id) {
        return groupService.findGroupById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        groupService.deleteGroupById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public GroupResponse update(@RequestBody Group group) {
        return groupService.updateGroup(group);
    }
}
