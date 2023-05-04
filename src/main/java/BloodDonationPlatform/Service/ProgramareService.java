package BloodDonationPlatform.Service;

import BloodDonationPlatform.Entities.Location;
import BloodDonationPlatform.Entities.Programare;
import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Repositories.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProgramareService {

    private final ProgramareRepository programareRepository;

    @Autowired
    public ProgramareService(ProgramareRepository programareRepository)
    {
        this.programareRepository=programareRepository;
    }

    public List<Programare> getProgramari(User user)
    {
        Iterable<Programare> locationIterable = programareRepository.findAll();
        List<Programare> programari = StreamSupport.stream(locationIterable.spliterator(), false).collect(Collectors.toList());
        programari.removeIf(p -> p.getIdDonator() != user.getId());
        return programari;
    }

    public Programare creeazaProgramare(Programare dto)
    {
        programareRepository.save(dto);
        return dto;
    }

    public List<Programare> getByDataAndIdLocatie(String data, Long idLocatie) {
        return programareRepository.findByDataAndIdLocatie(data, idLocatie);
    }
}
