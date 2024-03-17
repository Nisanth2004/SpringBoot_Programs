package com.fixdecode.sbcruddemo.pet;

import com.fixdecode.sbcruddemo.exception.PetNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService
{
    private PetRepository petRepository;

    @Override
    public Pet add(Pet pet)
    {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getPets()
    {
        return petRepository.findAll().stream().toList();
    }

    @Override
    public Pet update(Pet pet)
    {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Integer id)
    {
        petRepository.deleteById(id);
    }

    @Override
    public Optional<Pet> getById(Integer id) throws Exception
    {
       // get a single pet ,if id is not present throw exception
        return Optional.ofNullable(
                petRepository.findById(id).orElseThrow(() ->
                new PetNotFoundException("Pet Not found")));
    }


}
