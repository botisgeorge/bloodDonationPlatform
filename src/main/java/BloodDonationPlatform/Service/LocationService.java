package BloodDonationPlatform.Service;

import BloodDonationPlatform.Entities.Location;
import BloodDonationPlatform.Entities.Programare;
import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Repositories.LocationRepository;
import BloodDonationPlatform.Repositories.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final ProgramareRepository programareRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, ProgramareRepository programareRepository)
    {
        this.locationRepository=locationRepository;
        this.programareRepository=programareRepository;
    }

    public List<Location> getAllLocations()
    {
        Iterable<Location> locationIterable = locationRepository.findAll();
        List<Location> locations = StreamSupport.stream(locationIterable.spliterator(), false).collect(Collectors.toList());
        return locations;
    }
    public Location getById(long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isPresent()) {
            return optionalLocation.get();
        } else {
            throw new NoSuchElementException("Location not found with id: " + id);
        }
    }
}
