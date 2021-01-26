package by.shilay.app.service.impl;

import by.shilay.app.config.URLConstants;
import by.shilay.app.model.Discipline;
import by.shilay.app.model.responseDto.PageResponse;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private final RestTemplate restTemplate;

    @Autowired
    public DisciplineServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PageResponse<Discipline> getAll(int page, int size) {
        return restTemplate.getForObject(URLConstants.DISCIPLINES_URL + "?page=" + page + "&size=" + size,
                PageResponse.class);
    }
}
