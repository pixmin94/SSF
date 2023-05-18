package sg.ssf.day12.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {
    public List<Integer> generateRandomNumbers(int number) {
        return new Random()
            .ints(1, 31)
            .distinct()
            .limit(number)
            .boxed()
            .collect(Collectors.toList());
    }
}
