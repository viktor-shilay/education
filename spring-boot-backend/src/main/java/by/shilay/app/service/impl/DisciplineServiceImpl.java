package by.shilay.app.service.impl;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.PageResponse;
import by.shilay.app.model.Discipline;
import by.shilay.app.repository.DisciplineRepository;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public Discipline create(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public PageResponse<DisciplineDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Discipline> pageDiscipline = disciplineRepository.findAll(pageable);
        return transferToPageResponse(pageDiscipline);
    }

    @Override
    public Optional<Discipline> findOne(Long id) {
        return disciplineRepository.findAllById(id);
    }


    private static DisciplineDto transfer(Discipline discipline){
        return new DisciplineDto(discipline.getId(), discipline.getName(),
                discipline.getShortName(), discipline.getDescription());
    }

    private PageResponse transferToPageResponse(Page page){
        PageResponse<DisciplineDto> pageResponse = new PageResponse<>();
        pageResponse.setContent(transferToListDto(page.getContent()));
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());
        return pageResponse;
    }

    private List<DisciplineDto> transferToListDto(List<Discipline> disciplines) {
        List<DisciplineDto> disciplinesDtos = new ArrayList<>();
        for (Discipline temp : disciplines) {
            disciplinesDtos.add(transfer(temp));
        }
        return disciplinesDtos;
    }
}
