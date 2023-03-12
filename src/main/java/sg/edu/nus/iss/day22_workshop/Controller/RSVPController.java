package sg.edu.nus.iss.day22_workshop.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.Exception.Nonsense;
import sg.edu.nus.iss.day22_workshop.Model.RSVP;
import sg.edu.nus.iss.day22_workshop.Service.RSVPService;

@RequestMapping("/api/rsvp")
@RestController
public class RSVPController {
    @Autowired
    RSVPService rsvpSvc;

    @GetMapping("/count")
    public ResponseEntity<Integer> getRSVPcount() {
        Integer rsvpCount = rsvpSvc.count();

        return ResponseEntity.ok().body(rsvpCount);
    }

    @GetMapping("/")
    public ResponseEntity<List<RSVP>> getAllRSVP() {
        List<RSVP> rsvp = new ArrayList<RSVP>();
        rsvp = rsvpSvc.findAll();
        if (rsvp.isEmpty()) {
            throw new Nonsense("No such guest");
        } else {
            return ResponseEntity.ok().body(rsvp);
        }
    }

    @GetMapping("/{RSVP-id}")
    public ResponseEntity<RSVP> findById(@PathVariable("RSVP-id") Integer id) {
        RSVP rsvp = rsvpSvc.findById(id);

        return ResponseEntity.ok().body(rsvp);
    }

    @GetMapping("")
    public ResponseEntity<List<RSVP>> findByName(@RequestParam("q") String name) {
        List<RSVP> findByName = new ArrayList<RSVP>();
        findByName = rsvpSvc.findByName(name);
        if (findByName.isEmpty()) {
            return new ResponseEntity<>(findByName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(findByName, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> createRSVP(@RequestBody RSVP rsvp) {
        Boolean created = rsvpSvc.save(rsvp);

        if (created) {
            return new ResponseEntity<>("RSVP has been created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("RSVP not created", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping({ "/{id}" })
    public ResponseEntity<String> updateRSVP(@PathVariable("id") Integer id, @RequestBody RSVP rsvp) {
        RSVP rsvp2 = rsvpSvc.findById(id);
        if (rsvp2 != null) {
            boolean updated = rsvpSvc.update(rsvp);
            if (updated) {
                return new ResponseEntity<>("RSVP record successfully updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("RSVP not updated", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("RSVP not found", HttpStatus.NOT_FOUND);
        }
    }

}
