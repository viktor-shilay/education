package by.shilay.app.service.impl;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.pageResponse.PageResponse;
import by.shilay.app.model.Discipline;
import by.shilay.app.repository.DisciplineRepository;
import by.shilay.app.service.api.DisciplineService;
import by.shilay.app.service.api.UserService;
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
    private final UserService userService;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository disciplineRepository, UserService userService) {
        this.disciplineRepository = disciplineRepository;
        this.userService = userService;
    }

    /*@Override
    public PageResponse<DisciplineDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Discipline> pageDiscipline = disciplineRepository.findAll(pageable);
        return transferToPageResponse(pageDiscipline);
    }*/

    @Override
    public List<DisciplineDto> getAll() {
        return transferToListDto(disciplineRepository.findAll());
    }

    @Override
    public Optional<Discipline> findOne(Long id) {
        return disciplineRepository.findAllById(id);
    }

    @Override
    public List<DisciplineDto> getAllByUser(Long id) {
        return transferToListDto((disciplineRepository.findAllByUserId(id)));
    }

    @Override
    public Discipline create(DisciplineDto disciplineDto) {
        Discipline discipline = transferToDiscipline(disciplineDto);
        return disciplineRepository.save(discipline);
    }

    @Override
    public Discipline update(Long id, DisciplineDto disciplineDto){
        Optional<Discipline> disciplineData = findOne(id);
        if(disciplineData.isPresent()) {
            Discipline updDiscipline = disciplineData.get();
            updDiscipline.setName(disciplineDto.getName());
            updDiscipline.setShortName(disciplineDto.getShortName());
            updDiscipline.setDescription(disciplineDto.getDescription());
            return disciplineRepository.save(updDiscipline);
        }
        return null;
    }

    private DisciplineDto transferToDisciplineDto(Discipline discipline){
        return new DisciplineDto(discipline.getId(), discipline.getName(),
                                 discipline.getShortName(), discipline.getDescription(),
                                 discipline.getUser().getId());
    }

    private Discipline transferToDiscipline(DisciplineDto disciplineDto){
        Discipline discipline = new Discipline();
        discipline.setId(disciplineDto.getId());
        discipline.setName(disciplineDto.getName());
        discipline.setShortName(disciplineDto.getShortName());
        discipline.setDescription(disciplineDto.getDescription());
        discipline.setUser(userService.getByUserId(disciplineDto.getUserId()));
        return discipline;
    }

    private List<DisciplineDto> transferToListDto(List<Discipline> disciplines) {
        List<DisciplineDto> disciplinesDtos = new ArrayList<>();
        for (Discipline temp : disciplines) {
            disciplinesDtos.add(transferToDisciplineDto(temp));
        }
        return disciplinesDtos;
    }

    private PageResponse transferToPageResponse(Page page){
        PageResponse<DisciplineDto> pageResponse = new PageResponse<>();
        pageResponse.setContent(transferToListDto(page.getContent()));
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());
        return pageResponse;
    }
}
