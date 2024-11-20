package com.livraria.dsa.core.useCases.material;

import com.livraria.dsa.core.domain.Material;

public interface FindMaterialByTitleUseCase {
    Material execute(String titulo);
}
