package BloodDonationPlatform.Controllers;

import BloodDonationPlatform.Entities.Programare;
import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Service.ProgramareService;
import BloodDonationPlatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    public User currentUser = null;

    private UserService userService;
    private ProgramareService programareService;

    @Autowired
    public UserController(UserService userService, ProgramareService programareService)
    {
        this.userService=userService;
        this.programareService=programareService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/programare")
    ResponseEntity<Programare> createProgramare(@RequestBody Programare dto) {
        Programare newProgramare = dto;
        newProgramare.setIdDonator(currentUser.getId());
        newProgramare.setAcceptat(false);
        programareService.creeazaProgramare(newProgramare);
        return ResponseEntity.ok(newProgramare);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/programari")
    ResponseEntity<List<Programare>> getProgramariByDateAndLocation(
            @RequestParam("data") String data,
            @RequestParam("idLocatie") Long idLocatie
    ) {
        System.out.println(data+" "+idLocatie);
        List<Programare> programari = programareService.getByDataAndIdLocatie(data, idLocatie);
        return ResponseEntity.ok(programari);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/appointments")
    ResponseEntity<List<Programare>> getProgramari() {
        List<Programare> programari = programareService.getProgramari(currentUser);
        return ResponseEntity.ok(programari);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody User dto) {
        User registeredUser = userService.registerUser(dto);
        registeredUser.setRole(3);
        return ResponseEntity.ok(registeredUser);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User dto) {
        User user = userService.loginUser(dto);
        if (user != null) {
            currentUser = user;
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user")
    public ResponseEntity<User> getUserProfile() {
        User userProfile = currentUser;
        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/edit")
    public ResponseEntity<User> getEditProfile() {
        User userProfile = currentUser;
        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/edit")
    public ResponseEntity<User> updateUserProfile(@RequestBody User dto) {
        if (currentUser != null) {
            currentUser = userService.updateUser(currentUser, dto);
            return ResponseEntity.ok(currentUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser() {
        if (currentUser != null) {
            userService.deleteUser(currentUser);
            currentUser = null;
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

