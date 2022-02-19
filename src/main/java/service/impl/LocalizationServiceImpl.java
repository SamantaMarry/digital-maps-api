package service.impl;

import entity.Localization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LocalizationRepository;
import service.LocalizationService;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    @Autowired
    private LocalizationRepository localizationRepository;


    @Override
    public Localization findById(String id) {
        return this.localizationRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
    }
}
