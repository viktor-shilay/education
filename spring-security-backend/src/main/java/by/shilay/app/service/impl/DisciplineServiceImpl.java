package by.shilay.app.service.impl;

import by.shilay.app.config.URLConstants;
import by.shilay.app.model.Discipline;
import by.shilay.app.model.responseDto.PageResponse;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private final RestTemplate restTemplate;

    @Autowired
    public DisciplineServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*@Override
    public PageResponse<Discipline> getAll(int page, int size) {
        return restTemplate.getForObject(URLConstants.DISCIPLINES_URL + "?page=" + page + "&size=" + size,
                PageResponse.class);
    }*/

    @Override
    public List<Discipline> getAll() {
        return restTemplate.getForObject(URLConstants.DISCIPLINES_URL, List.class);
    }

    @Override
    public List<Discipline> getAllByUser(Long id) {
        return restTemplate.getForObject(URLConstants.DISCIPLINES_URL + "/user/" + id, List.class);
    }

    @Override
    public Discipline create(Discipline discipline) {
        return restTemplate.postForObject(URLConstants.DISCIPLINES_URL, discipline, Discipline.class);
    }

    @Override
    public void update(Long id, Discipline discipline) {
        restTemplate.put(URLConstants.DISCIPLINES_URL + "/" + id, discipline, Discipline.class);
    }
}
