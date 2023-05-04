package BloodDonationPlatform.Controllers;

import BloodDonationPlatform.Entities.Location;
import BloodDonationPlatform.Entities.Programare;
import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService)
    {
        this.locationService=locationService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getLocation/{id}")
    ResponseEntity<Location> getLocation(@PathVariable Long id) {
        Location location = locationService.getById(id);
        return ResponseEntity.ok(location);
    }
}
