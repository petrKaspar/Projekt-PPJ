package cz.tul.provisioner;

import cz.tul.data.Autor;
import cz.tul.data.Bill;
import cz.tul.data.User;
import cz.tul.repositories.BaseAutorRepository;
import cz.tul.repositories.BaseBillRepository;
import cz.tul.repositories.BaseUserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
// provision - ustanovení, poskytování
@Component
@Transactional//(noRollbackFor=Exception.class)
public class DBProvisioner implements InitializingBean {

    @Autowired
    private BaseBillRepository billRepository;

    @Autowired
    private BaseUserRepository userRepository;

    @Autowired
    private BaseAutorRepository autorRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        //afterPropertiesSet() je call-back metoda z InitializingBean interface

        provisionUsersCollectionIfEmpty();
        provisionBillsCollectionIfEmpty();

        provisionAutorCollectionIfEmpty();
       // provisionKomentarCollectionIfEmpty();
       // provisionObrazekCollectionIfEmpty();
    }
    private boolean provisionAutorCollectionIfEmpty() throws IOException {
        boolean isEmpty = autorRepository.count() == 0;
        if (isEmpty) {
            /*autorRepository.save(new Autor("Jack", "Bauer"));
            autorRepository.save(new Autor("Chloe", "O'Brian"));
            autorRepository.save(new Autor("Kim", "Bauer"));
            for (Autor a:autorRepository.findAll()) {
                System.out.println(a.toString());

            }*/
            try (BufferedReader read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/provision/autori.txt")))) {
                List<Autor> els = read.lines().map(s -> s.split("\\s"))
                        //.map(a -> new Autor(a[0], a[1])).collect(Collectors.toList());
                .map(a -> new Autor(Long.valueOf(a[0]).longValue() , a[1], a[2])).collect(Collectors.toList());
                System.out.println(els.size()+" AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                for (Autor a:els) {
                    System.out.println(a.toString());

                }
                autorRepository.save(els);
            }
        }
        return isEmpty;
    }



    private boolean provisionUsersCollectionIfEmpty() throws IOException {
        boolean isEmpty = userRepository.count() == 0;
        if (isEmpty) {

            try (BufferedReader read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/provision/users.txt")))) {
                List<User> els = read.lines().map(s -> s.split("\\s"))
                        .map(a -> new User(UUID.fromString(a[0]), a[1], Integer.parseInt(a[2]))).collect(Collectors.toList());

                userRepository.save(els);
            }
        }
        return isEmpty;
    }

    private boolean provisionBillsCollectionIfEmpty() throws IOException {
        boolean isEmpty = billRepository.count() == 0;
        if (isEmpty) {

            try (BufferedReader read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/provision/bills.txt")))) {
                List<Bill> els = read.lines().map(s -> s.split("\\s"))
                        .map(a -> new Bill(UUID.fromString(a[0]), Long.parseLong(a[2]), new User(UUID.fromString(a[1])))).collect(Collectors.toList());

                billRepository.save(els);
            }
        }
        return isEmpty;
    }


}
