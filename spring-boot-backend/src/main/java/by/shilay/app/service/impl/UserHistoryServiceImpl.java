package by.shilay.app.service.impl;

import by.shilay.app.dto.UserHistoryDto;
import by.shilay.app.model.UserHistory;
import by.shilay.app.repository.UserHistoryRepository;
import by.shilay.app.service.api.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    @Autowired
    public UserHistoryServiceImpl(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    @Override
    public List<UserHistoryDto> findByTargetUserId(Long id) {
        return transferToListDto(userHistoryRepository.findAllByTargetUserId(id));
    }

    private UserHistoryDto transferToUserHistoryDto(UserHistory userHistory){
        UserHistoryDto userHistoryDto = new UserHistoryDto();
        userHistoryDto.setId(userHistory.getId());
        userHistoryDto.setDate(userHistory.getDate());
        userHistoryDto.setReason(userHistory.getReason());
        userHistoryDto.setTargetUser(userHistory.getTargetUser().getId());
        return userHistoryDto;
    }

    private List<UserHistoryDto> transferToListDto(List<UserHistory> userHistories){
        List<UserHistoryDto> userHistoryDtos = new ArrayList<>();
        for(UserHistory temp: userHistories){
            userHistoryDtos.add(transferToUserHistoryDto(temp));
        }
        return userHistoryDtos;
    }
}
