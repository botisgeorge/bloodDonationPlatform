package BloodDonationPlatform.Repositories;

import BloodDonationPlatform.Entities.Programare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProgramareRepository extends JpaRepository<Programare,Long> {
    Programare findById(int id);
    List<Programare> findByDataAndIdLocatie(String data, Long idLocatie);
}
