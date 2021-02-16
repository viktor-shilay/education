package by.shilay.app.service.impl;

import by.shilay.app.config.URLConstants;
import by.shilay.app.model.Material;
import by.shilay.app.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final RestTemplate restTemplate;

    @Autowired
    public MaterialServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Material> getAllByDiscipline(Long id) {
        return restTemplate.getForObject(URLConstants.MATERIALS_URL + "/discipline/" + id, List.class);
    }

    @Override
    public List<Material> getAllByAuthor(Long id) {
        return restTemplate.getForObject(URLConstants.MATERIALS_URL + "/author/" + id, List.class);
    }

    @Override
    public void create(Material material) {
        restTemplate.postForObject(URLConstants.MATERIALS_URL, material, Material.class);
    }

}
