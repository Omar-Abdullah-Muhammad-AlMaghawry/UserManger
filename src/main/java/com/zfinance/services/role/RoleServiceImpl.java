package com.zfinance.services.role;

import com.zfinance.exceptions.BusinessException;
import com.zfinance.exceptions.DataNotFoundException;
import com.zfinance.orm.role.Role;
import com.zfinance.repositories.role.RoleRepository;
import com.zfinance.services.database.sequence.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{


    private SequenceGeneratorService sequenceGeneratorService;

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(SequenceGeneratorService sequenceGeneratorService, RoleRepository roleRepository) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(String id) throws Exception {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        else
            throw new DataNotFoundException(Role.class, id);
    }

    @Override
    public void save(Role role){
        role.setId(sequenceGeneratorService.generateSequence(Role.SEQUENCE_NAME));
        if(Objects.nonNull(roleRepository.findRoleByName(role.getName()))){
            throw new BusinessException("");
        }
        roleRepository.save(role);
    }
}
