package fr.da2i.jpo.services;

import fr.da2i.jpo.entities.Lycee;
import fr.da2i.jpo.repositories.LyceeRepository;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

@Service
public class LyceeService {
    public static final int MIN_DIST_LEVENSHTEIN = 4;
    private final LyceeRepository lyceeRepo;

    public LyceeService(LyceeRepository lyceeRepo) {
        this.lyceeRepo = lyceeRepo;
    }

    public Lycee getSimilarHighSchool(Lycee lycee) {
        LevenshteinDistance levenshtein = LevenshteinDistance.getDefaultInstance();
        for (Lycee other: lyceeRepo.findAll()) {
            int nameDistance = levenshtein.apply(lycee.getNom(), other.getNom());
            if (nameDistance < MIN_DIST_LEVENSHTEIN && lycee.getCodepostal().equals(other.getCodepostal())) {
                return other;
            }
        }
        return null;
    }
}
