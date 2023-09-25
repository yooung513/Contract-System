package ltoss.dma.code.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.code.domain.Code;
import ltoss.dma.code.repository.CodeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    public void save(Code code) { codeRepository.save(code); }

    public List<Code> findAll() { return codeRepository.findAll(); }
    public void updateCode(Code code) { codeRepository.save(code); }

    public void deleteByCode(String code) { codeRepository.deleteByCode(code); }
}
