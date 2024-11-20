package com.livraria.dsa.application.useCasesImpl.material;

import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.material.FindMaterialByTitleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindMaterialByTitleUseCaseImpl implements FindMaterialByTitleUseCase {

    private final MaterialRepository materialRepository;

    @Override
    public Material execute(String titulo) {
        return this.materialRepository.findByTitulo(titulo);
    }
}
