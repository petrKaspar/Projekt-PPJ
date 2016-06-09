package cz.tul.services;

import cz.tul.data.Bill;
import cz.tul.repositories.BaseBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillService {

    @Autowired
    private BaseBillRepository billRepository;

    public Iterable<Bill> listBills() {
        return billRepository.findAll();
    }

}
