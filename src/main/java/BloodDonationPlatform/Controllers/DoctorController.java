package BloodDonationPlatform.Controllers;

import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DoctorController {
    private UserService userService;

    @Autowired
    public DoctorController(UserService userService)
    {
        this.userService=userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addDoctor")
    ResponseEntity<User> registerDoctor(@RequestBody User dto) {
        User registeredDoctor = userService.registerDoctor(dto);
        registeredDoctor.setRole(2);
        return ResponseEntity.ok(registeredDoctor);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateDoctor")
    ResponseEntity<User> updateDoctor(@RequestBody User dto) {
        User doctorFound = userService.getById(dto.getId());
        User registeredDoctor = userService.updateUser(doctorFound,dto);
        return ResponseEntity.ok(registeredDoctor);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getDoctors")
    ResponseEntity<List<User>> getDoctors() {
        List<User> doctors = userService.getDoctors();
        return ResponseEntity.ok(doctors);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getDoctor/{id}")
    ResponseEntity<User> getDoctor(@PathVariable Long id) {
        if(id!=-1)
        {
            User doctor = userService.getById(id);
            return ResponseEntity.ok(doctor);
        }
        else
        {
            User doctor = new User();
            doctor.setName("-");
            return ResponseEntity.ok(doctor);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Doctor with ID " + id + " has been deleted.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", "Failed to delete doctor with ID " + id + "."));
        }
    }

}
