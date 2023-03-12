package sg.edu.nus.iss.day22_workshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day22_workshop.Model.RSVP;
import sg.edu.nus.iss.day22_workshop.Repository.RSVPRepository;

@Service
public class RSVPService {

    @Autowired
    RSVPRepository rsvpRepo;

    public int count(){
        return rsvpRepo.countAll();
    }

    public List<RSVP> findAll(){
        return rsvpRepo.findAll();
    }
    
    public RSVP findById(Integer id){
        return rsvpRepo.findById(id);
    }

    public List<RSVP> findByName(String name){
        return rsvpRepo.findByName(name);
    }

    public Boolean save(RSVP rsvp){
        return rsvpRepo.save(rsvp);
    }

    public Boolean update(RSVP rsvp){
        return rsvpRepo.update(rsvp);
    }

    public int[] batchUpdate(List<RSVP> rsvp){
        return rsvpRepo.batchUpdate(rsvp);
    }
}


