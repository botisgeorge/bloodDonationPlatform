package BloodDonationPlatform.Service;

import BloodDonationPlatform.Entities.Location;
import BloodDonationPlatform.Entities.User;
import BloodDonationPlatform.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User registerUser(User user)
    {
        user.setRole(3);
        userRepository.save(user);
        return user;
    }

    public User registerDoctor(User doctor)
    {
        doctor.setRole(2);
        userRepository.save(doctor);
        return doctor;
    }

    public List<User> getDoctors()
    {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> doctors = StreamSupport.stream(userIterable.spliterator(), false)
                .filter(user -> user.getRole() == 2)
                .collect(Collectors.toList());
        return doctors;

    }

    public User loginUser(User user)
    {
        User findUser = userRepository.findByUsername(user.getUsername());
        if (findUser.getPassword().equals(user.getPassword()))
            return findUser;
        else
            return null;
    }

    public User updateUser(User user, User dto)
    {
        User findUser = userRepository.findByUsername(user.getUsername());
        if(findUser!=null)
        {
            findUser.setName(dto.getName());
            findUser.setLocation(dto.getLocation());
            findUser.setGrupaSange(dto.getGrupaSange());
            findUser.setEmail(dto.getEmail());
            findUser.setPhoneNumber(dto.getPhoneNumber());
            findUser.setProfilePicture(dto.getProfilePicture());
            userRepository.save(findUser);
            return findUser;
        }
        else
            return null;
    }

    public void deleteUser(User user)
    {
        User findUser = userRepository.findByUsername(user.getUsername());
        if(findUser!=null)
            userRepository.delete(findUser);
    }

    public void deleteById(long id)
    {
        userRepository.deleteById(id);
    }

    public User getById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new NoSuchElementException("User not found with id: " + id);
        }
    }
}
