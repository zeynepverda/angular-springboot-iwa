package pl.dmcs.zva.springbootjsp_iwa2025.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Team;
import pl.dmcs.zva.springbootjsp_iwa2025.repository.TeamRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teams")
public class TeamRESTController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamRESTController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") long id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teamRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllTeams() {
        teamRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Team> updateTeam(@RequestBody Team team,
                                           @PathVariable("id") long id) {
        team.setId(id);
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Team> updatePartOfTeam(@RequestBody Map<String, Object> updates,
                                                 @PathVariable("id") long id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (updates.containsKey("teamName")) {
            team.setTeamName((String) updates.get("teamName"));
        }
        if (updates.containsKey("studentList")) {
            team.setStudentList((List<pl.dmcs.zva.springbootjsp_iwa2025.model.Student>) updates.get("studentList"));
        }
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeam(@PathVariable("id") long id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Team>> updateAllTeams(@RequestBody List<Team> teams) {
        teamRepository.deleteAll();
        List<Team> updated = teamRepository.saveAll(teams);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}