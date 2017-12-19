package animalDetector;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalDetectorController {

	@RequestMapping("/detect")
	public Map<String,String> detectAnimal(){
		Map<String,String> result = new HashMap<>();
		return result;
	}
}
