package org.sid.jwtservice;

import org.sid.jwtservice.securityp.entities.AppRole;
import org.sid.jwtservice.securityp.entities.AppUser;
import org.sid.jwtservice.securityp.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class JwtServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(JwtServiceApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewRole(new AppRole(null, "USER"));
			accountService.addNewRole(new AppRole(null, "ADMIN"));
			accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
			accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));

			accountService.addNewUser(new AppUser(null, "user1", "12345", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "admin", "12345", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user3", "12345", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user2", "12345", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user4", "12345", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user5", "123456", new ArrayList<>()));

			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("admin", "USER");
			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("user2", "CUSTOMER_MANAGER");
			accountService.addRoleToUser("user3", "USER");
			accountService.addRoleToUser("user3", "PRODUCT_MANAGER");
			accountService.addRoleToUser("user4", "USER");
			accountService.addRoleToUser("user4", "BILLS_MANAGER");
			accountService.addRoleToUser("user5", "BILLS_MANAGER");

			/*vdoService.addCategory(new Category(null, "Movies", "desc"));
			vdoService.addCategory(new Category(null, "Series", "desc"));
			vdoService.addCategory(new Category(null, "Documentaries", "desc"));

			vdoService.addVdo(new Video(null,"La casa de papel","desccc",new ArrayList<>()));
*/
		};
	}
	/*@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Video.class, Category.class);

		catRepo.save(new Category(null,"Movies",null,null));
		catRepo.save(new Category(null,"Series",null,null));
		catRepo.save(new Category(null,"Documentaries",null,null));
		Random rnd=new Random();
		catRepo.findAll().forEach(c->{
			for (int i = 0; i <10 ; i++){
				Video v=new Video();
				v.setName(RandomString.make(18));
				v.setCurrentPrice(100+rnd.nextInt(10000));
				v.setAvailable(rnd.nextBoolean());
				v.setPromotion(rnd.nextBoolean());
				v.setSelected(rnd.nextBoolean());
				v.setCategory(c);
				v.setPhotoName("unknow.png");
				vdoRepo.save(v);
			}
		});

	}*/

}
