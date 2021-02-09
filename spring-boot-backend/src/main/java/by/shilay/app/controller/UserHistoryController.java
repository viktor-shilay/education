package by.shilay.app.controller;

import by.shilay.app.dto.UserHistoryDto;
import by.shilay.app.service.api.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users-history")
public class UserHistoryController {

    private final UserHistoryService userHistoryService;

    @Autowired
    public UserHistoryController(UserHistoryService userHistoryService) {
        this.userHistoryService = userHistoryService;
    }

    @GetMapping("/{id}")
    public List<UserHistoryDto> getHistories(@PathVariable ("id") Long id){
        return userHistoryService.findByTargetUserId(id);
    }

}
