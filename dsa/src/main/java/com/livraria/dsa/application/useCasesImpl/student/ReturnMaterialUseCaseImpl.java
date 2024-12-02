package com.livraria.dsa.application.useCasesImpl.student;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.adapters.repositories.ReturnRepository;
import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Return;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.student.ReturnMaterialUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnMaterialUseCaseImpl implements ReturnMaterialUseCase {

    private final MaterialRepository materialRepository;
    private final StudentRepository alunoRepository;
    private final ReturnRepository devolucaoRepository;

    @Autowired
    public ReturnMaterialUseCaseImpl(MaterialRepository materialRepository, StudentRepository alunoRepository, ReturnRepository devolucaoRepository) {
        this.materialRepository = materialRepository;
        this.alunoRepository = alunoRepository;
        this.devolucaoRepository = devolucaoRepository;
    }

    @Override
    public boolean execute(Return devolucao) {
        try {
            Material material = this.materialRepository.findByTitulo(devolucao.getMaterial().getTitulo());
            if(material.getCopiesAvailable() == material.getTotalCopies()){
                System.out.println("Nenhum exemplar disponivel");
            }

            Student aluno = this.alunoRepository.findByCpf(devolucao.getStudent().getCpf());

            devolucao.getMaterial().setCopiesAvailable(+1);
            this.devolucaoRepository.save(devolucao);
            return true;
        }
        catch (Exception e){
            System.out.println("Não foi possivel realizar a devolução");
        }
        return false;
    }
}
