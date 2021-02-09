package by.shilay.app.service.api;

import by.shilay.app.dto.UserHistoryDto;

import java.util.List;

public interface UserHistoryService {
    List<UserHistoryDto> findByTargetUserId(Long id);
}
