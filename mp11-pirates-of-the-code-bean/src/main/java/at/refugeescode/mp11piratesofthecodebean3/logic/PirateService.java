package at.refugeescode.mp11piratesofthecodebean3.logic;

import at.refugeescode.mp11piratesofthecodebean3.persistence.PieceOfEightRepository;
import at.refugeescode.mp11piratesofthecodebean3.persistence.Pirate;
import at.refugeescode.mp11piratesofthecodebean3.persistence.PirateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PirateService {

    private PirateRepository pirateRepository;

    private PieceOfEightRepository pieceOfEightRepository;

    private CsvParser csvParser;

    public PirateService(PirateRepository pirateRepository, PieceOfEightRepository pieceOfEightRepository, CsvParser csvParser) {
        this.pirateRepository = pirateRepository;
        this.pieceOfEightRepository = pieceOfEightRepository;
        this.csvParser = csvParser;
    }

    public void populatePirates() {

        // delete all the pirates and pieces of eight from the database
        deleteAll();

        // use the csvParser to get a list of all the pirates, the path should be "classpath:pirates.csv"

        PirateModule pirateModule = new PirateModule("classpath:pirates.csv");

        List<Pirate> pirates = csvParser.asList(pirateModule);
        System.out.println(pirates.get(0).toString());
        // for each pirate, save first manually the piece of eight,
        pirates.stream()
                .map(pirate -> pirate.getPieceOfEight()).forEach(pieceOfEight -> pieceOfEightRepository.save(pieceOfEight));
        // connect it to the corresponding pirate and then save the pirate
        pirates.stream().forEach(pirate -> pirateRepository.save(pirate));

        // for each pirate, save first manually the piece of eight,
        // connect it to the corresponding pirate and then save the pirate
    }

    public List<Pirate> findAll() {
        return pirateRepository.findAll(); // return all the pirates from the database
    }

    public void deleteAll() {

        // delete all pirates
        // delete all pieces of eight
        pieceOfEightRepository.deleteAll();

        pirateRepository.deleteAll();




    }
}
