package BloodDonationPlatform;
import BloodDonationPlatform.Entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BloodDonationPlatformApplication {

	public User User;

	public static void main(String[] args) {
		SpringApplication.run(BloodDonationPlatformApplication.class, args);
	}

}
